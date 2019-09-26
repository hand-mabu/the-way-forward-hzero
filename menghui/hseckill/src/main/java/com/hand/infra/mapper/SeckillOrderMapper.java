package com.hand.infra.mapper;

import com.hand.domain.entity.SeckillOrder;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
public interface SeckillOrderMapper extends BaseMapper<SeckillOrder > {

    SeckillOrder selectByUserIdAndGoodsId(@Param("userId") long userId, @Param("goodsId") long goodsId);
}
