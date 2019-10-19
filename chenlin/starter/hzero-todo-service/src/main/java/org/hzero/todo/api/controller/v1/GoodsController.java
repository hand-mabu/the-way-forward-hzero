package org.hzero.todo.api.controller.v1;

import io.choerodon.core.base.BaseController;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.*;
import org.hzero.core.util.Results;
import org.hzero.todo.app.service.GoodsService;
import org.hzero.todo.config.SwaggerApiConfig;
import org.hzero.todo.domain.entity.Goods;
import org.hzero.todo.domain.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.hzero.todo.config.SwaggerApiConfig.Goods;

@Api(tags = Goods)
@RestController("goodsController.v1")
@RequestMapping("/v1/goods")
public class GoodsController extends BaseController {

    private final GoodsService goodsService;
    private final GoodsRepository goodsRepository;

    public GoodsController(GoodsService goodsService, GoodsRepository goodsRepository) {
        this.goodsService = goodsService;
        this.goodsRepository = goodsRepository;
    }
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询商品")
    @GetMapping
    public ResponseEntity<Page<Goods>> pageTask(Goods goods, PageRequest pageRequest) {
        return Results.success(goodsRepository.pageAndSort(pageRequest, goods));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据goodsId查询goods")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "商品编号", paramType = "string")
    })
    @GetMapping("/id/{GoodsId}")
    public ResponseEntity<Goods> selectDetail(@PathVariable Long organizationId, @PathVariable String goodsId) {
        return Results.success(goodsRepository.selectDetailByGoodsId(goodsId));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据商品编号减少库存")
    @DeleteMapping("/delete/{goodsId}")
    public void updateNumber(@PathVariable Long organizationId, @PathVariable @ApiParam(value = "商品编号") String goodsId ,Goods goods) {
        goodsService.updateNumber(goods,goodsId);
    }
}
