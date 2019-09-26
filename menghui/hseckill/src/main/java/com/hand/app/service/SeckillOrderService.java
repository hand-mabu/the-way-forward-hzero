package com.hand.app.service;

import com.hand.domain.bo.GoodsBo;
import com.hand.domain.entity.OrderInfo;
import com.hand.domain.entity.SeckillOrder;
import com.hand.domain.entity.User;

/**
 * @description
 * @author 刘梦辉
 * @date 2019/9/25
 */
public interface SeckillOrderService {

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId);


    OrderInfo insert(User user, GoodsBo goodsBo);

    OrderInfo getOrderInfo(long orderId);

    long getSeckillResult(Long userId, long goodsId);

    boolean checkPath(User user, long goodsId, String path);

    String createMiaoshaPath(User user, long goodsId);

}
