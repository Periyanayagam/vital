package com.example.saravanakumar8.vitalmed.Model.response;

/**
 * Awesome Pojo Generator
 */
public class LoginResponse {


    private String message,groupid,userid,status;

    public LoginResponse(String message, String groupid, String userid, String status) {
        this.message = message;
        this.groupid = groupid;
        this.userid = userid;
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}