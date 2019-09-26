package com.hand.infra.repository.impl;

import com.hand.domain.entity.User;
import com.hand.domain.repository.UserRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Repository;

/**
 *  资源库实现
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

  
}
