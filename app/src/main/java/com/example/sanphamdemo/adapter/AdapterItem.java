package com.example.sanphamdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.activity.ThucDonBan;
import com.example.sanphamdemo.fragment.DetailProfileFragment;
import com.example.sanphamdemo.fragment.ProfileFragment;
import com.example.sanphamdemo.user.Ban_User;

import java.util.List;

public class AdapterItem extends BaseAdapter {

    private List<Ban_User> dataList;
    private LayoutInflater inflater;

  Context context;
    Ban_User data;
    public AdapterItem(Context context, List<Ban_User> dataList) {
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public AdapterItem() {
    }
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        ///////////
        if (view == null) {
            view = inflater.inflate(R.layout.itemhomefragment, null);
            holder = new ViewHolder();
            holder.detail_item = view.findViewById(R.id.detail_item);
            holder.tenbann = view.findViewById(R.id.tenban);
            holder.gioo = view.findViewById(R.id.gio);
            holder.giatien = view.findViewById(R.id.gia);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
         data = dataList.get(i);
        holder.tenbann.setText(data.getTen());
        holder.giatien.setText(data.getGia()+" Đ");
        holder.gioo.setText(data.getGiovao());
        if (data.getTrangthai() == 1){
            holder.tenbann.setTextColor(Color.parseColor("#00FF00"));


        }

        holder.detail_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, ThucDonBan.class);
                Bundle bundle = new Bundle();
                int idxoa = dataList.get(i).getId();
                 String ten  =dataList.get(i).getTen();
                String giovao = dataList.get(i).getGiovao();
                String gia = String.valueOf(dataList.get(i).getGia());
                String trangthai = String.valueOf(dataList.get(i).getTrangthai());
                String ngaythang  =dataList.get(i).getNgaythang();


                bundle.putString("idxoa", String.valueOf(idxoa));
                bundle.putString("ten", ten);
                bundle.putString("giovao", giovao);
                bundle.putString("gia", String.valueOf(gia));
                bundle.putString("trangthai", String.valueOf(trangthai));
                bundle.putString("ngaythang", ngaythang);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
        ////////


    }

    public static class ViewHolder  {

              LinearLayout detail_item;
         TextView tenbann, gioo, giatien;
    }
}
