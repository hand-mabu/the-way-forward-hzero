package com.hand.app.service.impl;

import com.hand.app.service.OrderService;
import com.hand.domain.entity.OrderInfo;
import com.hand.infra.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/9/25
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderInfoMapper ordeInfoMapper;

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return ordeInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        return ordeInfoMapper.selectByPrimaryKey(orderId);
    }
}
