package com.yp.cloud.security.core.userdetails;

import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 加载用户信息实现类
 * Created by yepeng on 2018/11/17.
 */
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(MessageAccessor.getMessage("login.username-or-password.error"));
        }

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new CustomUserDetails(username, user.getPassword(), user.getId(), user.getNickname(), user.getLanguage(), authorities);
    }
}
