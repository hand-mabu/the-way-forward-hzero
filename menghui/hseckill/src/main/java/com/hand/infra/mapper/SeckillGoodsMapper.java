package com.hand.infra.mapper;

import com.hand.domain.entity.SeckillGoods;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

    int reduceStock(@Param("goodsId") long goodsId);
}
