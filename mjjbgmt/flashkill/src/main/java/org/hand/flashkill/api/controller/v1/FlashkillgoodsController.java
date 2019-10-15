package org.hand.flashkill.api.controller.v1;

import io.swagger.annotations.Api;
import org.hand.flashkill.config.SwaggerTags;
import org.hand.flashkill.domain.entity.FlashkillgoodsSearch;
import org.hzero.core.util.Results;
import org.hzero.core.base.BaseController;
import org.hand.flashkill.domain.entity.Flashkillgoods;
import org.hand.flashkill.domain.repository.FlashkillgoodsRepository;
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

/**
 *  管理 API
 *
 * @author mengtao.yan@hand-chian.com 2019-10-11 17:29:49
 */
@Api(tags = SwaggerTags.FLASHKILL)
@RestController("flashkillgoodsController.v1")
@RequestMapping("/v1/flashkillgoodss")
public class FlashkillgoodsController extends BaseController {

    @Autowired
    private FlashkillgoodsRepository flashkillgoodsRepository;

    @ApiOperation(value = "列表")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping
    public ResponseEntity<Page<Flashkillgoods>> list(Long organizationId,FlashkillgoodsSearch flashkillgoodsSearch, @ApiIgnore @SortDefault(value = FlashkillgoodsSearch.FIELD_ID,
            direction = Sort.Direction.DESC) PageRequest pageRequest) {
        Flashkillgoods flashkillgoods = new Flashkillgoods();
        flashkillgoods.setGoodsName(flashkillgoodsSearch.getGoodsName());
        Page<Flashkillgoods> list = flashkillgoodsRepository.pageAndSort(pageRequest, flashkillgoods);
        return Results.success(list);
    }

    @ApiOperation(value = "明细")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @GetMapping("/{id}")
    public ResponseEntity<Flashkillgoods> detail(@PathVariable Long id) {
        Flashkillgoods flashkillgoods = flashkillgoodsRepository.selectByPrimaryKey(id);
        return Results.success(flashkillgoods);
    }

    @ApiOperation(value = "创建")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PostMapping
    public ResponseEntity<Flashkillgoods> create(@RequestBody Flashkillgoods flashkillgoods) {
        validObject(flashkillgoods);
        flashkillgoodsRepository.insertSelective(flashkillgoods);
        return Results.success(flashkillgoods);
    }

    @ApiOperation(value = "修改")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @PutMapping
    public ResponseEntity<Flashkillgoods> update(@RequestBody Flashkillgoods flashkillgoods) {
        SecurityTokenHelper.validToken(flashkillgoods);
        flashkillgoodsRepository.updateByPrimaryKeySelective(flashkillgoods);
        return Results.success(flashkillgoods);
    }

    @ApiOperation(value = "删除")
    @Permission(level = ResourceLevel.ORGANIZATION)
    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Flashkillgoods flashkillgoods) {
        SecurityTokenHelper.validToken(flashkillgoods);
        flashkillgoodsRepository.deleteByPrimaryKey(flashkillgoods);
        return Results.success();
    }

}
