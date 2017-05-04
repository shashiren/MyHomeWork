package com.jikexueyuan.contacts;

/**
 * Created by stan on 2017/4/17.
 */

public class ContactsBean {
    private String name;
    private String number;
    private long rawContactId;

    public ContactsBean(String name) {
        this.name = name;
        this.number = number;
        this.rawContactId = rawContactId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setRawContactId(long rawContactId) {
        this.rawContactId = rawContactId;
    }

    public String getName() {
        return name;
    }

    public long getRawContactId() {
        return rawContactId;
    }

    public String getNumber() {
        return number;
    }
}
