package com.yp.cloud.security.domain.service;

import com.yp.cloud.security.domain.entity.User;
import com.yp.starter.core.base.Service;

/**
 * Created by yepeng on 2018/11/17.
 */
public interface UserService extends Service<User> {
    User getUserByUsername(String username);
}
