package com.hand.domain.repository;

import com.hand.domain.bo.GoodsBo;
import com.hand.domain.entity.Goods;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 资源库
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
public interface GoodsRepository extends BaseRepository<Goods> {

    List<GoodsBo> getSeckillGoodsList();
}
