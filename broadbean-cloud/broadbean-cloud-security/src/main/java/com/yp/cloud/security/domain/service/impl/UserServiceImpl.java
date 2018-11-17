package com.yp.cloud.security.domain.service.impl;

import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.UserService;
import com.yp.starter.core.base.BaseService;
import com.yp.starter.core.base.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yepeng on 2018/11/17.
 */
@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

    @Autowired
    private Mapper<User> mapper;

    @Override
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return mapper.selectOne(user);
    }
}
