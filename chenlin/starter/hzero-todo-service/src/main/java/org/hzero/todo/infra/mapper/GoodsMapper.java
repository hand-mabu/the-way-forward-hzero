package org.hzero.todo.infra.mapper;
import java.util.List;
import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.todo.domain.entity.Goods;

public interface GoodsMapper extends BaseMapper<Goods>{
    /**
     * 查询任务
     *
     * @param params 商品查询参数
     * @return Goods
     */
    List<Goods> selectGoods(Goods params);

    void updateNumber(String id);

    Goods selectGoodsById(String goodsId);
}
