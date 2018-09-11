package com.dmxiaoshen.message.sdk.dto;

/**
 * Created by hzhsg on 2018/8/21.
 */
public class SMSMessageDTO {

    private String id;

    private String content;

    private String sendBy;

    private String receiveCellphone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getReceiveCellphone() {
        return receiveCellphone;
    }

    public void setReceiveCellphone(String receiveCellphone) {
        this.receiveCellphone = receiveCellphone;
    }

    @Override
    public String toString() {
        return "SMSMessageDTO{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", sendBy='" + sendBy + '\'' +
                ", receiveCellphone='" + receiveCellphone + '\'' +
                '}';
    }
}
