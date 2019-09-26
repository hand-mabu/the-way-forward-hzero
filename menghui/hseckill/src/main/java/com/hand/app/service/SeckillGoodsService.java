package com.hand.app.service;

import com.hand.domain.bo.GoodsBo;

import java.util.List;

/**
 * @description
 * @author 刘梦辉
 * @date 2019/9/25
 */
public interface SeckillGoodsService {

    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
