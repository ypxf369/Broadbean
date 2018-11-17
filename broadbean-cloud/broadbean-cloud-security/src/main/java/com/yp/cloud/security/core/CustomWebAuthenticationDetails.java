package com.yp.cloud.security.core;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 自定义 WebAuthenticationDetails 用于封装传入的验证码以及缓存的验证码，用于后续校验。
 * Created by yepeng on 2018/11/17.
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    public static final String FIELD_CACHE_CAPTCHA = "cacheCaptcha";

    private String inputCaptcha;
    private String cacheCaptcha;


    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        cacheCaptcha = (String) request.getAttribute(FIELD_CACHE_CAPTCHA);
        inputCaptcha = request.getParameter(CaptchaResult.FIELD_CAPTCHA);
    }

    public String getInputCaptcha() {
        return inputCaptcha;
    }

    public String getCacheCaptcha() {
        return cacheCaptcha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomWebAuthenticationDetails that = (CustomWebAuthenticationDetails) o;
        return Objects.equals(inputCaptcha, that.inputCaptcha) &&
                Objects.equals(cacheCaptcha, that.cacheCaptcha);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (inputCaptcha != null ? inputCaptcha.hashCode() : 0);
        return result;
    }
}
