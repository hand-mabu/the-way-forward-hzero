package org.hzero.todo.infra.repository.impl;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.hzero.mybatis.common.Criteria;
import org.hzero.todo.domain.entity.Goods;
import org.hzero.todo.domain.repository.GoodsRepository;
import org.hzero.todo.infra.mapper.GoodsMapper;

@Component
public class GoodsRepositoryImpl extends BaseRepositoryImpl<Goods> implements GoodsRepository {

    private final GoodsMapper goodsMapper;

    public GoodsRepositoryImpl(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    @Override
    public Page<Goods> pageGoods(Goods goods, PageRequest pageRequest) {
        return PageHelper.doPage(pageRequest, () -> goodsMapper.selectGoods(goods));
    }
    

    @Override
    public Goods selectDetailByGoodsId(String goodsId) {
        Goods goods = goodsMapper.selectGoodsById(goodsId);
        return goods;
    }

}
