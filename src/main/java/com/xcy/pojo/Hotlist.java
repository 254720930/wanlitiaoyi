package com.xcy.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/18
 * @Description:
 * @version: 1.0
 */
public class Hotlist {
    private int id;
    @ApiModelProperty("创建者头像地址")
    private String headportrait;

    public String getHotlistname() {
        return hotlistname;
    }

    public void setHotlistname(String hotlistname) {
        this.hotlistname = hotlistname;
    }

    @ApiModelProperty("活动名字")
    private String hotlistname;
    @ApiModelProperty("活动总人数")
    private int sumuser;
    @ApiModelProperty("创建者昵称")
    private String username;
    @ApiModelProperty("活动时间")
    private String activitytime;
    @ApiModelProperty("活动地址")
    private String addresss;
    @ApiModelProperty("主办单位")
    private String hostunit;
    @ApiModelProperty("报名人数")
    private int usernum;
    @ApiModelProperty("报名须知")
    private String application;
    @ApiModelProperty("活动费用")
    private double applicationcost;
    @ApiModelProperty("详情咨询")
    private String particulars;
    @ApiModelProperty("活动状态")
    private String state;
    @ApiModelProperty("活动头像地址")
    private String hotlistImgUrl;

    public int getId() {
        return id;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public int getSumuser() {
        return sumuser;
    }

    public void setSumuser(int sumuser) {
        this.sumuser = sumuser;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getHotlistImgUrl() {
        return hotlistImgUrl;
    }

    public void setHotlistImgUrl(String hotlistImgUrl) {
        this.hotlistImgUrl = hotlistImgUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(String activitytime) {
        this.activitytime = activitytime;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public String getHostunit() {
        return hostunit;
    }

    public void setHostunit(String hostunit) {
        this.hostunit = hostunit;
    }

    public int getUsernum() {
        return usernum;
    }

    public void setUsernum(int usernum) {
        this.usernum = usernum;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public double getApplicationcost() {
        return applicationcost;
    }

    public void setApplicationcost(double applicationcost) {
        this.applicationcost = applicationcost;
    }

    public String getParticulars() {
        return particulars;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Hotlist{" +
                "id=" + id +
                ", activitytime='" + activitytime + '\'' +
                ", addresss='" + addresss + '\'' +
                ", hostunit='" + hostunit + '\'' +
                ", usernum=" + usernum +
                ", application='" + application + '\'' +
                ", applicationcost=" + applicationcost +
                ", particulars='" + particulars + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
