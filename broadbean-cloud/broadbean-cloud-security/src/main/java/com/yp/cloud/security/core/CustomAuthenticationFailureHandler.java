package com.yp.cloud.security.core;

import com.yp.cloud.security.config.SecurityProperties;
import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户认证失败，记录密码错误次数，并重定向到登录页面。
 * Created by yepeng on 2018/11/17.
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private UserService userService;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.setAttribute("username", username);
            session.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,
                    MessageAccessor.getMessage(exception.getMessage(), exception.getMessage()));
        }
        if (exception instanceof BadCredentialsException) {
            User user = userService.getUserByUsername(username);
            userService.loginFail(user.getId());
        }

        redirectStrategy.sendRedirect(request, response, securityProperties.getLoginPage() + "?username=" + username);
    }
}
