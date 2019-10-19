package org.hzero.todo.domain.repository;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.todo.domain.entity.Goods;
import java.util.List;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
public interface  GoodsRepository extends BaseRepository<Goods>{
    /**
     * 分页查询商品
     *
     * @param goods Goods
     * @param pageRequest 分页参数
     * @return Page<Goods>
     */
    Page<Goods> pageGoods(Goods goods, PageRequest pageRequest);


    /**
     * 根据商品编号查询商品详细
     *
     * @param goodsId 任务编号
     * @return Goods
     */
    Goods selectDetailByGoodsId(String goodsId);

}

