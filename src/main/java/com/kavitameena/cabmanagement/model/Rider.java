package com.kavitameena.cabmanagement.model;

public class Rider {

    private Long id;
    private String name;
    private String emailId;
    private String phoneNo;

    public Rider(String name, String emailId, String phoneNo) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
