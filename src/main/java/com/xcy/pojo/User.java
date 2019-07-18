package com.xcy.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class User implements Serializable {
    @ApiModelProperty("用户id，唯一标识")
    private int id;

    @ApiModelProperty("用户电话号码")
    private String phone;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户邮箱")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}