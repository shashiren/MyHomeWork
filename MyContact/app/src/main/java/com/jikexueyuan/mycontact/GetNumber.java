package com.jikexueyuan.mycontact;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stan on 2017/4/21.
 */

public class GetNumber {
    public static List<PhoneInfo> list = new ArrayList<PhoneInfo>();

    public static String getNumber(Context context){
        Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI,null,null,null,null);
        String phoneName;
        String phoneNumber;
        while (cursor.moveToNext()){
            phoneName = cursor.getString(cursor.getColumnIndex(Phone.DISPLAY_NAME));
            phoneNumber = cursor.getString(cursor.getColumnIndex(Phone.NUMBER));
            PhoneInfo phoneInfo = new PhoneInfo(phoneName,phoneNumber);
            System.out.println(phoneName+phoneNumber);
            list.add(phoneInfo);
        }
        return null;
    }
}
