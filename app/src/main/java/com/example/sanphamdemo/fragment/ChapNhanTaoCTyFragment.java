package com.example.sanphamdemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sanphamdemo.R;


public class ChapNhanTaoCTyFragment extends Fragment {


    private LinearLayout linearMore;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView dathanhtoan1;

    // TODO: Rename and change types of parameters

    String msthue,tenct,diachi,linhvuc,kihan;
    public ChapNhanTaoCTyFragment() {
        // Required empty public constructor
    }


    public static ChapNhanTaoCTyFragment newInstance() {
        ChapNhanTaoCTyFragment fragment = new ChapNhanTaoCTyFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chap_nhan_tao_c_ty, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        linearMore = (LinearLayout) view.findViewById(R.id.linearMore);
        a = (TextView) view.findViewById(R.id.a);
        b = (TextView) view.findViewById(R.id.b);
        c = (TextView) view.findViewById(R.id.c);
        d = (TextView) view.findViewById(R.id.d);
        e = (TextView) view.findViewById(R.id.e);
        dathanhtoan1 = (TextView) view.findViewById(R.id.dathanhtoan1);

        Bundle bundle = getArguments();
        msthue = bundle.getString("masothue");
        tenct = bundle.getString("tenct");
        diachi = bundle.getString("diachi");
        linhvuc = bundle.getString("linhvuc");
        kihan = bundle.getString("kihan");

        a.setText(msthue);
        b.setText(tenct);
        d.setText(diachi);
        c.setText(linhvuc);
        e.setText(kihan);


    }
}