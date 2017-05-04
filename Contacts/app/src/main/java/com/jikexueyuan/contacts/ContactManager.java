package com.jikexueyuan.contacts;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by stan on 2017/4/12.
 */

public class ContactManager {
    public static List<People> getNumber(Context context){
        List<People> contacts = new ArrayList<People>();
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor =  resolver.query(ContactsContract.RawContacts.CONTENT_URI,
                new String[]{ContactsContract.RawContacts._ID},
                null,
                null,
                null);
        People people;
        while (cursor.moveToNext()){
            people = new People(null,null);
            long rawContactId = cursor.getLong(cursor.getColumnIndex(ContactsContract.RawContacts._ID));
            people.setRawContactId(rawContactId);

            Cursor dataCursor = resolver.query(ContactsContract.Data.CONTENT_URI,
                    null,
                    ContactsContract.Data.RAW_CONTACT_ID + "=?",
                    new String[]{String.valueOf(rawContactId)},
                    null);
            while (dataCursor.moveToNext()){
                String data1 = dataCursor.getString(dataCursor
                        .getColumnIndex(ContactsContract.Data.DATA1));
                String mimetype = dataCursor.getString(dataCursor
                        .getColumnIndex(ContactsContract.Data.MIMETYPE));

                if (mimetype.equals(StructuredName.CONTENT_ITEM_TYPE)){
                    people.setName(data1);
                }else if (mimetype.equals(Phone.CONTENT_ITEM_TYPE)){
                    people.setNumber(data1);
                }
            }
            contacts.add(people);
            contacts.clear();

        }
        cursor.close();
        return contacts;
    }

    public static  void  addContact(Context context, People people){

        ContentResolver resolver = context.getContentResolver();

        ContentValues values = new ContentValues();
        Uri rawContactUri = resolver.insert(RawContacts.CONTENT_URI, values);
        long rawContactId = ContentUris.parseId(rawContactUri);

        ContentValues valuesData1 = new ContentValues();
        valuesData1.put(Data.RAW_CONTACT_ID, rawContactId);
        valuesData1.put(Data.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
        valuesData1.put(Phone.NUMBER,people.getNumber());
        resolver.insert(Data.CONTENT_URI, valuesData1);

        ContentValues valuesData2 = new ContentValues();
        valuesData2.put(Data.RAW_CONTACT_ID, rawContactId);
        valuesData2.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        valuesData2.put(StructuredName.DISPLAY_NAME,people.getName());
        resolver.insert(RawContacts.CONTENT_URI, valuesData2);


    }

    public  static void updateContact(Context context, People people){

        ContentResolver resolver = context.getContentResolver();

        ArrayList<ContentProviderOperation> ops =
                new ArrayList<ContentProviderOperation>();

        ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
                .withSelection(ContactsContract.Data.RAW_CONTACT_ID + "=? AND" + Data.MIMETYPE + "=?",
                        new String[]{
                                String.valueOf(people.getRawContactId()),
                                StructuredName.CONTENT_ITEM_TYPE})
                .withValue(StructuredName.DISPLAY_NAME, people.getName())
                .build());

        ops.add(ContentProviderOperation.
                newUpdate(Data.CONTENT_URI)
                .withSelection(Data.RAW_CONTACT_ID + "=? AND" + Data.MIMETYPE + "=?",
                        new String[]{
                                String.valueOf(people.getRawContactId()),
                                Phone.CONTENT_ITEM_TYPE})
                .withValue(Phone.NUMBER, people.getNumber())
                .build());

        try {
            resolver.applyBatch(ContactsContract.AUTHORITY,ops);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        }
    }

    public  static void deleteContact(Context context,People people){
        ContentResolver reslover = context.getContentResolver();
        reslover.delete(RawContacts.CONTENT_URI, RawContacts._ID+"=?",
                new String[]{String.valueOf(people.getRawContactId())});
    }

}
