package org.hzero.todo.app.service.impl;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.hzero.todo.infra.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.choerodon.core.exception.CommonException;
import org.hzero.todo.app.service.GoodsService;
import org.hzero.todo.domain.entity.Goods;
import org.hzero.todo.infra.mapper.GoodsMapper;
import org.hzero.todo.domain.repository.GoodsRepository;
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)//回滚
    public void updateNumber(Goods goods,String id) {
        Goods exist = goodsRepository.selectByPrimaryKey(goods);
        if (exist == null) {
            throw new CommonException("htdo.warn.goods.notFound");
        }
        goodsMapper.updateNumber(id);
    }

}


