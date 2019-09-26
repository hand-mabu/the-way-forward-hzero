package com.hand.app.service;

import com.hand.domain.entity.User;
import com.hand.infra.param.LoginParam;
import com.hand.infra.result.Result;

/**
 * @description
 * @author 刘梦辉
 * @date 2019/9/24
 */
public interface UserService {
    Result<User> login(LoginParam loginParam);
}
