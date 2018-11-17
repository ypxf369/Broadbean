package com.yp.cloud.security.core;

import com.yp.cloud.security.core.userdetails.CustomUserDetailsService;
import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.ConfigService;
import com.yp.cloud.security.domain.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 自定义认证处理器，主要加入了验证码的检查，如果用户密码输入错误三次以上，则需要验证码。
 * Created by yepeng on 2018/11/17.
 */
@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomUserDetailsService detailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ConfigService configService;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        String username=userDetails.getUsername();
        User user=userService.getUserByUsername(username);

        //检查验证码
        if (authentication.getDetails() instanceof CustomWebAuthenticationDetails) {
            if (configService.isEnableCaptcha(user.getPasswordErrorTime())) {
                CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
                String inputCaptcha = details.getInputCaptcha();
                String cacheCaptcha = details.getCacheCaptcha();
                if (StringUtils.isEmpty(inputCaptcha) || !StringUtils.equalsIgnoreCase(inputCaptcha, cacheCaptcha)) {
                    throw new AuthenticationServiceException("login.captcha.error");
                }
                authentication.setDetails(null);
            }
        }

        // 检查密码是否正确
        String password = userDetails.getPassword();
        String rawPassword = authentication.getCredentials().toString();

        boolean match = passwordEncoder.matches(rawPassword, password);
        if (!match) {
            throw new BadCredentialsException("login.username-or-password.error");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        //如有其他逻辑处理，可在此处进行处理
        return detailsService.loadUserByUsername(username);
    }
}
