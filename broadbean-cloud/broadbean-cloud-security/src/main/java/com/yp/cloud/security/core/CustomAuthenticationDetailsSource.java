package com.yp.cloud.security.core;

import com.yp.starter.captcha.CaptchaImageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义获取AuthenticationDetails 用于封装传进来的验证码
 * Created by yepeng on 2018/11/17.
 */
@Component
public class CustomAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Autowired
    private CaptchaImageHelper captchaImageHelper;

    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
        String cacheCaptcha = captchaImageHelper.getCaptcha(request, SecurityConstants.SECURITY_KEY);
        request.setAttribute(CustomWebAuthenticationDetails.FIELD_CACHE_CAPTCHA, cacheCaptcha);
        return new CustomWebAuthenticationDetails(request);
    }
}
