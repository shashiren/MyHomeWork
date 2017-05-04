package com.jikexueyuan.sendargs;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by stan on 2016/12/9.
 */

//public class User implements Serializable{
public class User implements Parcelable{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User(String name,int age){
        this.name = name;
        this.age = age;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
       parcel.writeString(getName());
        parcel.writeInt(getAge());

    }
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(),parcel.readInt());

        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };
}
