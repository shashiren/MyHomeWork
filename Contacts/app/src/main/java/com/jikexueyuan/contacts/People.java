package com.jikexueyuan.contacts;

public class People {
    public People(String name,String number) {
        setNumber(number);
        setName(name);
    }

//    public People() {
//
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setRawContactId(long rawContactId) {
        this.rawContactId = rawContactId;
    }

    public long getRawContactId() {
        return rawContactId;
    }

    private String name;
    private String number;
    private  long  rawContactId;


    public void setRawContactId(People oldContact) {
    }
}
