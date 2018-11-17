package com.yp.starter.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

/**
 * Created by yepeng on 2018/11/17.
 */
@Controller
public class TestCaptchaControler {
    @Autowired
    private CaptchaImageHelper captchaImageHelper;

    @GetMapping("captcha.jpg")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字符串
        String captchaCode = captchaImageHelper.generateVerifyCode(4);
        //存入session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("captchaCode");
        session.removeAttribute("codeTime");
        session.setAttribute(captchaCode, captchaCode.toLowerCase());
        session.setAttribute("codeTime", LocalDateTime.now());

        //生成图片
        int w = 100, h = 30;
        OutputStream outputStream = response.getOutputStream();
        captchaImageHelper.outputImage(w, h, outputStream, captchaCode);
    }
}
