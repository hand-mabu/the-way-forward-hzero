package org.hzero.todo.api.controller.v1;

import io.choerodon.core.base.BaseController;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.util.Results;
import org.hzero.todo.domain.entity.Order;
import org.hzero.todo.domain.repository.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hzero.todo.config.SwaggerApiConfig.Order;

@Api(tags = Order)
@RestController("orderController.v1")
@RequestMapping("/v1/order")
public class OrderController  extends BaseController{

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Permission(level = ResourceLevel.SITE)
    @ApiOperation(value = "分页查询订单")
    @GetMapping
    public ResponseEntity<Page<Order>> pageOrder(String id, PageRequest pageRequest) {
        return Results.success(orderRepository.pageOrders(id,pageRequest));
    }

}
