package com.yp.core.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yp.core.base.BaseDTO;
import com.yp.core.util.Dates;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统用户
 * Created by yepeng on 2018/11/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "sys_user")
public class User extends BaseDTO {
    private static final long serialVersionUID = -7395431342743009038L;

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 生日
     */
    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date birthday;

    /**
     * 性别：1-男/0-女
     */
    private Integer gender;

    /**
     * 是否启用：1/0
     */
    private Integer enabled;

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
