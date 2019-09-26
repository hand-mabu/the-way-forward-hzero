package com.hand.domain.vo;

import com.hand.domain.bo.GoodsBo;
import com.hand.domain.entity.OrderInfo;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/19
 * Time: 0:40
 * Such description:
 */
@Setter
@Getter
public class OrderDetailVo {
    private GoodsBo goods;
    private OrderInfo order;
}
