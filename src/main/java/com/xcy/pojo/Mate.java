package com.xcy.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/22
 * @Description:
 * @version: 1.0
 */
public class Mate {
    private int id;
    @ApiModelProperty("心仪对象性别")
    private String sex;
    @ApiModelProperty("最低身高")
    private int minHeight;
    @ApiModelProperty("最高身高")
    private int maxHeight;
    @ApiModelProperty("最大年龄")
    private int maxAge;
    @ApiModelProperty("最小年龄")
    private int minAge;
    @ApiModelProperty("年收入")
    private String income;
    @ApiModelProperty("省份")
    private String address;
    @ApiModelProperty("婚况")
    private String marry;
    @ApiModelProperty("学历")
    private String eduinfo;
    @ApiModelProperty("爱好")
    private String characters;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getEduinfo() {
        return eduinfo;
    }

    public void setEduinfo(String eduinfo) {
        this.eduinfo = eduinfo;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "Mate{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", minHeight=" + minHeight +
                ", maxHeight=" + maxHeight +
                ", maxAge=" + maxAge +
                ", minAge=" + minAge +
                ", income='" + income + '\'' +
                ", address='" + address + '\'' +
                ", marry='" + marry + '\'' +
                ", eduinfo='" + eduinfo + '\'' +
                ", characters='" + characters + '\'' +
                '}';
    }
}
