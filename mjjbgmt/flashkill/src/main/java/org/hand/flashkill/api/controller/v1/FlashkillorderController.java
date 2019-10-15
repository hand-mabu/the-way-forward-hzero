package org.hand.flashkill.api.controller.v1;

import io.swagger.annotations.Api;
import org.hand.flashkill.config.SwaggerTags;
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

/**
 *  管理 API
 *
 * @author mengtao.yan@hand-chian.com 2019-10-14 17:12:38
 */
@Api(tags = SwaggerTags.FLASHKILL_ORDER)
@RestController("flashkillorderController.v1")
@RequestMapping("/v1/flashkillorders")
public class FlashkillorderController extends BaseController {

    @Autowired
    private FlashkillorderRepository flashkillorderRepository;

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

}
