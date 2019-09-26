package com.hand.infra.mq;

import com.hand.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeckillMessage {

    private User user;

    private long goodsId;

}
