package com.yp.cloud.security.core;

import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义认证成功处理器，用户认证成功，将密码错误次数置零。
 * Created by yepeng on 2018/11/17.
 */
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String username = request.getParameter("username");
        User user = userService.getUserByUsername(username);
        userService.loginSuccess(user.getId());
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
