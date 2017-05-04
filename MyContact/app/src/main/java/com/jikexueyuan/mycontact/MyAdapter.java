package com.jikexueyuan.mycontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by stan on 2017/4/21.
 */

public class MyAdapter extends BaseAdapter {

    private List<PhoneInfo> list;
    private Context context;
    private LinearLayout layout;

    public MyAdapter(List<PhoneInfo> list,Context context){
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        layout = (LinearLayout) inflater.inflate(R.layout.list_cell,null);
//        TextView tvName = (TextView) layout.findViewById(R.id.tv1);
//        TextView tvNumber = (TextView) layout.findViewById(R.id.tv2);
//        tvName.setText(list.get(i).getName());
//        tvNumber.setText(list.get(i).getNumber());
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_cell,null);
            holder = new ViewHolder();
            holder.tvNmae = (TextView) view.findViewById(R.id.edt1);
            holder.tvNumber = (TextView) view.findViewById(R.id.edt2);
            holder.tvNmae.setText(list.get(i).getName());
            holder.tvNumber.setText(list.get(i).getNumber());
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
            holder.tvNmae.setText(list.get(i).getName());
            holder.tvNumber.setText(list.get(i).getNumber());

        }

        return view;
    }
    private static class ViewHolder{
        TextView tvNmae;
        TextView tvNumber;
    }

}
