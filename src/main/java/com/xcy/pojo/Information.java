package com.xcy.pojo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: http://www/qfedu.com
 * @Date: 2019/7/20
 * @Description:
 * @version: 1.0
 */
public class Information {
    private int id;
    @ApiModelProperty("发件人ID")
    private int recipients;
    @ApiModelProperty("收件人ID")
    private int addresser;
    @ApiModelProperty("发送内容")
    private String content;
    @ApiModelProperty("发送时间")
    private String sendTime;
    @ApiModelProperty("是否已读状态")
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipients() {
        return recipients;
    }

    public void setRecipients(int recipients) {
        this.recipients = recipients;
    }

    public int getAddresser() {
        return addresser;
    }

    public void setAddresser(int addresser) {
        this.addresser = addresser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
