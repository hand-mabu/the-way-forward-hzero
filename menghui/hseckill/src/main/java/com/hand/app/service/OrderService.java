package com.hand.app.service;

import com.hand.domain.entity.OrderInfo;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/17
 * Time: 10:49
 * Such description:
 */
public interface OrderService {

    long addOrder(OrderInfo orderInfo);

    OrderInfo getOrderInfo(long rderId);
}
