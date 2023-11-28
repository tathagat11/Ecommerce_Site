package com.academia6_3.ESDProject.OtherObjects;

public class AuthObject {
    private Integer rollNo;
    private String password;

    public AuthObject() {
    }

    public AuthObject(Integer rollNo, String password) {
        this.rollNo = rollNo;
        this.password = password;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
