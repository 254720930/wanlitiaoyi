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
    private int age;
    @ApiModelProperty("身高")
    private String heights;
    @ApiModelProperty("体重")
    private String weights;
    @ApiModelProperty("星座")
    private String constellation;
    @ApiModelProperty("血型")
    private String blood;
    @ApiModelProperty("民族")
    private String nation;
    @ApiModelProperty("学历")
    private String niversitys;
    @ApiModelProperty("职业")
    private String job;
    @ApiModelProperty("年收入")
    private String income;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("婚况状况")
    private String marry;
    @ApiModelProperty("性格")
    private String characters;
    @ApiModelProperty("独白")
    private String monologue;
    @ApiModelProperty("兴趣爱好")
    private String hobbies;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHeights() {
        return heights;
    }

    public void setHeights(String heights) {
        this.heights = heights;
    }

    public String getWeights() {
        return weights;
    }

    public void setWeights(String weights) {
        this.weights = weights;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
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
                ", age=" + age +
                ", heights='" + heights + '\'' +
                ", weights='" + weights + '\'' +
                ", constellation='" + constellation + '\'' +
                ", blood='" + blood + '\'' +
                ", nation='" + nation + '\'' +
                ", niversitys='" + niversitys + '\'' +
                ", job='" + job + '\'' +
                ", income='" + income + '\'' +
                ", address='" + address + '\'' +
                ", marry='" + marry + '\'' +
                ", characters='" + characters + '\'' +
                ", monologue='" + monologue + '\'' +
                ", hobbies='" + hobbies + '\'' +
                ", cardz='" + cardz + '\'' +
                ", cardf='" + cardf + '\'' +
                '}';
    }

}