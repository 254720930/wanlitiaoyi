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

    @ApiModelProperty("头像图片地址")
    private String headportrait;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private String age;
    @ApiModelProperty("身高")
    private String height;
    @ApiModelProperty("体重")
    private String weight;
    @ApiModelProperty("星座")
    private String constellation;
    @ApiModelProperty("血型")
    private String bloodtype;
    @ApiModelProperty("民族")
    private String nation;
    @ApiModelProperty("学历")
    private String niversitys;
    @ApiModelProperty("职业Id")
    private int occupationId;
    @ApiModelProperty("职业")
    private int occupation;
    @ApiModelProperty("年收入")
    private String incomes;
    @ApiModelProperty("地址")
    private String addressss;
    @ApiModelProperty("婚况ID")
    private int marryId;
    @ApiModelProperty("婚况状况")
    private int marrys;
    @ApiModelProperty("性格")
    private String characters;
    @ApiModelProperty("独白")
    private String monologue;
    @ApiModelProperty("兴趣爱好")
    private String interest;
    @ApiModelProperty("身份证正面")
    private String cardz;
    @ApiModelProperty("身份证反面")
    private String cardf;



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

    public String getHeadportrait() {
        return headportrait;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNiversitys() {
        return niversitys;
    }

    public void setNiversitys(String niversitys) {
        this.niversitys = niversitys;
    }

    public int getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(int occupationId) {
        this.occupationId = occupationId;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public String getIncomes() {
        return incomes;
    }

    public void setIncomes(String incomes) {
        this.incomes = incomes;
    }

    public String getAddressss() {
        return addressss;
    }

    public void setAddressss(String addressss) {
        this.addressss = addressss;
    }

    public int getMarryId() {
        return marryId;
    }

    public void setMarryId(int marryId) {
        this.marryId = marryId;
    }

    public int getMarrys() {
        return marrys;
    }

    public void setMarrys(int marrys) {
        this.marrys = marrys;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }

    public String getMonologue() {
        return monologue;
    }

    public void setMonologue(String monologue) {
        this.monologue = monologue;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getCardz() {
        return cardz;
    }

    public void setCardz(String cardz) {
        this.cardz = cardz;
    }

    public String getCardf() {
        return cardf;
    }

    public void setCardf(String cardf) {
        this.cardf = cardf;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", headportrait='" + headportrait + '\'' +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", constellation='" + constellation + '\'' +
                ", bloodtype='" + bloodtype + '\'' +
                ", nation='" + nation + '\'' +
                ", niversitys='" + niversitys + '\'' +
                ", occupationId=" + occupationId +
                ", occupation=" + occupation +
                ", incomes='" + incomes + '\'' +
                ", addressss='" + addressss + '\'' +
                ", marryId=" + marryId +
                ", marrys=" + marrys +
                ", characters='" + characters + '\'' +
                ", monologue='" + monologue + '\'' +
                ", interest='" + interest + '\'' +
                ", cardz='" + cardz + '\'' +
                ", cardf='" + cardf + '\'' +
                '}';
    }
}