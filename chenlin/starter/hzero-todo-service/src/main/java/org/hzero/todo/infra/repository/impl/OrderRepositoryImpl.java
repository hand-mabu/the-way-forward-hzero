package org.hzero.todo.infra.repository.impl;


import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.todo.domain.entity.Goods;
import org.hzero.todo.domain.entity.Order;
import org.hzero.todo.domain.repository.OrderRepository;
import org.hzero.todo.infra.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {

    private final OrderMapper orderMapper;

    public OrderRepositoryImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public Page<Order> pageOrders(String id,PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, () -> orderMapper.selectOrder(id));
    }

}
