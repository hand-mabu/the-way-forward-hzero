package com.hand.infra.repository.impl;

import com.hand.domain.bo.GoodsBo;
import com.hand.domain.entity.Goods;
import com.hand.domain.repository.GoodsRepository;
import com.hand.infra.mapper.GoodsMapper;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  资源库实现
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
@Repository
public class GoodsRepositoryImpl extends BaseRepositoryImpl<Goods> implements GoodsRepository {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsMapper.selectAllGoodes();
    }
}
