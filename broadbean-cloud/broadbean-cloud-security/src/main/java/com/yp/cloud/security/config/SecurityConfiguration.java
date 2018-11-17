package com.yp.cloud.security.config;

import com.yp.cloud.security.core.CustomAuthenticationDetailsSource;
import com.yp.cloud.security.core.CustomAuthenticationFailureHandler;
import com.yp.cloud.security.core.CustomAuthenticationProvider;
import com.yp.cloud.security.core.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Security 主配置器
 * Created by yepeng on 2018/11/17.
 */
@Component
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties properties;
    @Autowired
    private CustomAuthenticationDetailsSource authenticationDetailsSource;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;
    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private CustomAuthenticationFailureHandler authenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/webjars/**", "/public/**", "/login", "/favicon.ico")
                .permitAll() // 允许匿名访问的地址
                .and() // 使用and()方法相当于XML标签的关闭，这样允许我们继续配置父类节点。
                .authorizeRequests()
                .anyRequest()
                .authenticated() // 其它地址都需进行认证
                .and()
                .formLogin() // 启用表单登录
                .loginPage(properties.getLoginPage()) // 登录页面
                .defaultSuccessUrl("/index") // 默认的登录成功后的跳转地址
                .authenticationDetailsSource(authenticationDetailsSource)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .and()
                .csrf()
                .disable()
        ;

    }

    /**
     * 设置认证处理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
        super.configure(auth);
    }

    /**
     * 密码处理器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
