package com.jikexueyuan.contacts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<People> contacts;

    public MyAdapter(Context context, List<People> contacts){
        this.context = context;
        this.contacts = contacts;

    }
//    public void addContact(People p){
//        data.add(p);
//        notifyDataSetChanged();
//    }


    @Override
    public int getCount() {

        return contacts.size();
    }

    @Override
    public People getItem(int arg0) {

        return contacts.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {

        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ViewHolder holder;
        if (arg1==null){
            holder = new ViewHolder();
//            arg1 = LayoutInflater.from(getContext()).inflate(R.layout.list_cell,null);
            arg1 = View.inflate(context,R.layout.list_cell,null);
            holder.tvName = (TextView) arg1.findViewById(R.id.tvName);
            holder.tvNumber = (TextView) arg1.findViewById(R.id.tvNumber);
            arg1.setTag(holder);
        }else {
            holder = (ViewHolder) arg1.getTag();
        }
        People p =  getItem(arg0);
        holder.tvName.setText(p.getName());
        holder.tvNumber.setText(p.getNumber());


//        TextView tvName = (TextView) arg1.findViewById(R.id.tvName);
//        TextView tvNumber = (TextView) arg1.findViewById(R.id.tvNumber);
//
//        People p = getItem(arg0);
//        tvName.setText(p.getName());
//        tvNumber.setText(p.getNumber());


        return arg1;
    }

    public Context getContext() {
        return context;
    }

    private static class ViewHolder{
        TextView tvName;
        TextView tvNumber;
    }



    private List<People> data;
}

