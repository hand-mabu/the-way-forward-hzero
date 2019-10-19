package org.hzero.todo.app.service;
import org.hzero.todo.domain.entity.Goods;

public interface GoodsService {


    /**
     * 更新商品库存
     *
     * @param  goods Goods goodsId String 任务
     * @return Goods
     */
    void updateNumber(Goods goods,String goodsId);


}