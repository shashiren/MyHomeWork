package com.jikexueyuan.mycontact;

/**
 * Created by stan on 2017/4/21.
 */

public class PhoneInfo {
    private String name;
    private String number;

    public PhoneInfo(String name,String number){
        setName(name);
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
