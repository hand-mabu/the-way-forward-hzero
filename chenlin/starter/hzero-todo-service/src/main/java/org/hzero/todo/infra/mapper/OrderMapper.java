package org.hzero.todo.infra.mapper;

import java.util.List;
import io.choerodon.mybatis.common.BaseMapper;
import org.hzero.todo.domain.entity.Order;

public interface OrderMapper extends BaseMapper<Order>{
        /**
         * 查询任务
         *
         * @param id 订单查询参数
         * @return Order
         */
    List<Order> selectOrder(String id);
}
