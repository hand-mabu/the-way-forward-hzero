package com.hand.infra.mapper;

import com.hand.domain.bo.GoodsBo;
import com.hand.domain.entity.Goods;
import io.choerodon.mybatis.common.BaseMapper;

import java.util.List;

/**
 * Mapper
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsBo> selectAllGoodes();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int updateStock(long goodsId);
}
