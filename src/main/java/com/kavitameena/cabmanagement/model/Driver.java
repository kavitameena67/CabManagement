package com.kavitameena.cabmanagement.model;

public class Driver {

    private Long id;
    private String name;
    private String mobileNo;
    private String licenseNo;

    public Driver(Long id, String name, String mobileNo, String licenseNo) {
        this.id = id;
        this.name = name;
        this.mobileNo = mobileNo;
        this.licenseNo = licenseNo;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
}
