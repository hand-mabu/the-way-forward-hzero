package com.hand.app.service.impl;

import com.hand.app.service.SeckillGoodsService;
import com.hand.domain.bo.GoodsBo;
import com.hand.domain.repository.GoodsRepository;
import com.hand.domain.repository.SeckillGoodsRepository;
import com.hand.infra.mapper.GoodsMapper;
import com.hand.infra.mapper.SeckillGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘梦辉
 * @description
 * @date 2019/9/25
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsRepository goodsRepository;

    @Autowired
    SeckillGoodsMapper seckillGoodsMapper;

    @Autowired
    SeckillGoodsRepository seckillGoodsRepository;

    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsRepository.getSeckillGoodsList();
    }

    @Override
    public GoodsBo getseckillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.getseckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    public int reduceStock(long goodsId) {
        return seckillGoodsMapper.reduceStock(goodsId);
    }
}
