package com.xcy.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/19
 * @Description:
 * @version: 1.0
 */
public class Dynamic {
    @ApiModelProperty("动态ID")
    private int id;
    @ApiModelProperty("动态发布时间")
    private String dynamicTime;
    @ApiModelProperty("动态内容")
    private String dynamiccontent;
    @ApiModelProperty("动态图片地址")
    private String dynamicImgUrl;
    @ApiModelProperty("用户Id")
    private int userId;
    @ApiModelProperty("用户头像")
    private String headportrait;
    @ApiModelProperty("用户昵称")
    private String username;
    @ApiModelProperty("置顶权限")
    private int upcode;

    public int getUpcode() {
        return upcode;
    }

    public void setUpcode(int upcode) {
        this.upcode = upcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDynamicTime() {
        return dynamicTime;
    }

    public void setDynamicTime(String dynamicTime) {
        this.dynamicTime = dynamicTime;
    }

    public String getDynamiccontent() {
        return dynamiccontent;
    }

    public void setDynamiccontent(String dynamiccontent) {
        this.dynamiccontent = dynamiccontent;
    }

    public String getDynamicImgUrl() {
        return dynamicImgUrl;
    }

    public void setDynamicImgUrl(String dynamicImgUrl) {
        this.dynamicImgUrl = dynamicImgUrl;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
                "id=" + id +
                ", dynamicTime='" + dynamicTime + '\'' +
                ", dynamiccontent='" + dynamiccontent + '\'' +
                ", dynamicImgUrl='" + dynamicImgUrl + '\'' +
                ", userId=" + userId +
                '}';
    }
}
