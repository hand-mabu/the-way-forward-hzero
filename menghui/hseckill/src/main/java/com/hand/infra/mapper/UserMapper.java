package com.hand.infra.mapper;

import com.hand.domain.entity.User;
import io.choerodon.mybatis.common.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper
 *
 * @author menghui.liu@hand-china.com 2019-09-25 18:13:55
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByPhoneAndPassword(@Param("phone") String phone , @Param("password") String password);

    User checkPhone(@Param("phone") String phone );
}
