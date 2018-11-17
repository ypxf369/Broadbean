package com.yp.cloud.security.core.userdetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Objects;

/**
 * 定制的UserDetail对象
 * Created by yepeng on 2018/11/17.
 */
public class CustomUserDetails extends User {
    private static final long serialVersionUID = -4461471539260584625L;

    private Long userId;
    private String nickname;
    private String language;

    public CustomUserDetails(String username, String password, Long userId, String nickname, String language, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.nickname = nickname;
        this.language = language;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLanguage() {
        return language;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomUserDetails)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        CustomUserDetails that = (CustomUserDetails) o;
        if (!Objects.equals(userId, that.userId)) {

            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + language.hashCode();
        return result;
    }
}
