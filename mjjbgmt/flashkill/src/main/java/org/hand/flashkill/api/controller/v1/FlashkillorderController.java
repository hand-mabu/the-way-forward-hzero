package org.hand.flashkill.api.controller.v1;

import io.choerodon.core.oauth.CustomUserDetails;
import io.swagger.annotations.Api;
import org.hand.flashkill.config.SwaggerTags;
import org.hand.flashkill.domain.entity.Flashkillgoods;
import org.hand.flashkill.domain.repository.FlashkillgoodsRepository;
import org.hzero.core.exception.MessageException;
import org.hzero.core.helper.DetailsExtractor;
import org.hzero.core.properties.CoreProperties;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hand.flashkill.domain.entity.Flashkillorder;
import org.hand.flashkill.domain.repository.FlashkillorderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.hzero.mybatis.helper.SecurityTokenHelper;

import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.annotation.SortDefault;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.pagehelper.domain.Sort;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 管理 API
 *
 * @author mengtao.yan@hand-chian.com 2019-10-14 17:12:38
 */
@Api(tags = SwaggerTags.FLASHKILL_ORDER)
@RestController("flashkillorderController.v1")
@RequestMapping("/v1/flashkillorders")
public class FlashkillorderController extends BaseController {

    @Autowired
    private FlashkillorderRepository flashkillorderRepository;
    @Autowired
    private FlashkillgoodsRepository flashkillgoodsRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Flashkillorder>> list(Flashkillorder flashkillorder, @ApiIgnore @SortDefault(value = Flashkillorder.FIELD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Page<Flashkillorder> list = flashkillorderRepository.pageAndSort(pageRequest, flashkillorder);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{id}")
    public ResponseEntity<Flashkillorder> detail(@PathVariable Long id) {
        Flashkillorder flashkillorder = flashkillorderRepository.selectByPrimaryKey(id);
        return Results.success(flashkillorder);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<Flashkillorder> create(@RequestBody Flashkillorder flashkillorder) {
        validObject(flashkillorder);
        flashkillorderRepository.insertSelective(flashkillorder);
        return Results.success(flashkillorder);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<Flashkillorder> update(@RequestBody Flashkillorder flashkillorder) {
        SecurityTokenHelper.validToken(flashkillorder);
        flashkillorderRepository.updateByPrimaryKeySelective(flashkillorder);
        return Results.success(flashkillorder);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Flashkillorder flashkillorder) {
        SecurityTokenHelper.validToken(flashkillorder);
        flashkillorderRepository.deleteByPrimaryKey(flashkillorder);
        return Results.success();
    }


    @ApiOperation(value = "秒杀")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping("/kill/{goodsId}")
    public ResponseEntity<Flashkillorder> kill(@PathVariable Long goodsId, HttpServletRequest request) {
        CustomUserDetails userDetails = new DetailsExtractor(new CoreProperties()).extractDetails(request);
        Flashkillgoods flashkillgoods = flashkillgoodsRepository.selectByPrimaryKey(goodsId);
        Flashkillorder flashkillorder = new Flashkillorder();

        if (flashkillgoods == null) {
            throw new MessageException("找不到商品id 对应商品");
        }

        if (flashkillgoods.getInventory() <= 0) {
            throw new MessageException("商品库存不足");
        }

        //  减少相应库存
        flashkillgoods.setInventory(flashkillgoods.getInventory() - 1);
        flashkillgoodsRepository.updateByPrimaryKey(flashkillgoods);

        //  创建秒杀订单
        flashkillorder.setGoodsId(goodsId);
        flashkillorder.setUserId(userDetails.getUserId());
        flashkillorderRepository.insertSelective(flashkillorder);

        return Results.success(flashkillorder);
    }

    @ApiOperation(value = "付款")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/pay/{orderId}")
    public ResponseEntity<Flashkillorder> kill(@PathVariable Long orderId) {
        Flashkillorder flashkillorder = flashkillorderRepository.selectByPrimaryKey(orderId);

        if (flashkillorder == null) {
            throw new MessageException("找不到订单");
        }

        if(!Objects.equals(flashkillorder.getPay(), "T")){
            throw new MessageException("订单状态不正确");
        }

        flashkillorder.setPay("Y");
        flashkillorderRepository.updateByPrimaryKey(flashkillorder);

        return Results.success(flashkillorder);
    }

    @ApiOperation(value = "付款失败-增加库存")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping("/nopay/{orderId}")
    public ResponseEntity<Flashkillorder> nopay(@PathVariable Long orderId) {
        Flashkillorder flashkillorder = flashkillorderRepository.selectByPrimaryKey(orderId);
        if (flashkillorder == null) {
            throw new MessageException("找不到订单");
        }

        if(!Objects.equals(flashkillorder.getPay(), "T")){
            throw new MessageException("订单状态不正确");
        }

        Flashkillgoods flashkillgoods = flashkillgoodsRepository.selectByPrimaryKey(flashkillorder.getGoodsId());
        flashkillgoods.setInventory(flashkillgoods.getInventory() +  1);
        flashkillgoodsRepository.updateByPrimaryKey(flashkillgoods);

        flashkillorder.setPay("N");
        flashkillorderRepository.updateByPrimaryKey(flashkillorder);

        return Results.success(flashkillorder);
    }
}
