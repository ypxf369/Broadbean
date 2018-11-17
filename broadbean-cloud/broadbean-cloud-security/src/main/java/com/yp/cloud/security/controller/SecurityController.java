package com.yp.cloud.security.controller;

import com.yp.cloud.security.domain.entity.User;
import com.yp.cloud.security.domain.service.ConfigService;
import com.yp.cloud.security.domain.service.UserService;
import com.yp.starter.captcha.CaptchaImageHelper;
import com.yp.starter.core.base.Result;
import com.yp.starter.core.util.Results;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by yepeng on 2018/11/17.
 */
@Controller
public class SecurityController {
    private static final String LOGIN_PAGE="login";

    private static final String INDEX_PAGE="index";

    private static final String FIELD_ERROR_MSG="errorMsg";
    private static final String FIELD_ENABLE_CAPTCHA="enableCaptcha";
/*
    @Autowired
    private CaptchaImageHelper captchaImageHelper;
    @Autowired
    private UserService userService;
    @Autowired
    private ConfigService configService;

    @RequestMapping("index")
    public String index(){
        return INDEX_PAGE;
    }

    @GetMapping("login")
    public String login(HttpSession session, Model model){
        String errorMsg=(String)session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        String username=(String)session.getAttribute(User.FIELD_USERNAME);
        if(StringUtils.isNotBlank(errorMsg)){
            model.addAttribute(FIELD_ERROR_MSG, errorMsg);
        }
        if(StringUtils.isNotBlank(username)){
            model.addAttribute(User.FIELD_USERNAME, username);
            User user = userService.getUserByUsername(username);
            if(user==null){
                model.addAttribute(FIELD_ERROR_MSG, MessageAccessor.getMessage("login.username-or-password.error"));
            }else{
                if(configService.isEnableCaptcha(user.getPasswordErrorTime())){
                    model.addAttribute(FIELD_ENABLE_CAPTCHA, true);
                }
            }
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        return LOGIN_PAGE;
    }

    @GetMapping("/public/captcha.jpg")
    public void captcha(HttpServletResponse response) {
        captchaImageHelper.generateAndWriteCaptchaImage(response, SecurityConstants.SECURITY_KEY);
    }

    @GetMapping("/user/self")
    @ResponseBody
    public Result test() {
        CustomUserDetails details = DetailsHelper.getUserDetails();

        return Results.successWithData(details);
    }*/
}
