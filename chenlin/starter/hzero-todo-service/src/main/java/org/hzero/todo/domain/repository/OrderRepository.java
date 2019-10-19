package org.hzero.todo.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;
import org.hzero.todo.domain.entity.Order;
import org.hzero.todo.domain.entity.User;


public interface OrderRepository extends BaseRepository<Order> {
    /**
     * 根据用户编号查询商品详细
     *
     * @param id
     * @return Page
     */
    Page<Order> pageOrders(String id,PageRequest pageRequest);
}
