package com.yp.cloud.security.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by yepeng on 2018/11/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String mobile;
    private String email;
    private String language;
    private Integer enabled;
    private Date disabledDate;
    private String photo_url;
    private Integer passwordErrorTime;
    private Long version;
    private Date createDate;
    private Long createBy;
    private Long updateBy;
    private Date updateDate;

    public Long getId() {
        return id;
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

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public Date getDisabledDate() {
        return disabledDate;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public Integer getPasswordErrorTime() {
        return passwordErrorTime;
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public void setDisabledDate(Date disabledDate) {
        this.disabledDate = disabledDate;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public void setPasswordErrorTime(Integer passwordErrorTime) {
        this.passwordErrorTime = passwordErrorTime;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
