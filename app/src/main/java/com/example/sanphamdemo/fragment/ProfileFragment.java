package com.example.sanphamdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.user.UngVien;


public class ProfileFragment extends Fragment {

    private TextView hovaten;
    private TextView kinhnghiem;
    private TextView myprofile;
    private RelativeLayout vieclam;
    private RelativeLayout congtycuatoi;
    private TextView dangxuat;


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView btnprofile = view.findViewById(R.id.myprofile);
        hovaten = (TextView) view.findViewById(R.id.hovaten);
        kinhnghiem = (TextView) view.findViewById(R.id.kinhnghiem);
        myprofile = (TextView) view.findViewById(R.id.myprofile);
        vieclam = (RelativeLayout) view.findViewById(R.id.vieclam);
        congtycuatoi = (RelativeLayout) view.findViewById(R.id.congtycuatoi);
        dangxuat = (TextView) view.findViewById(R.id.dangxuat);

        // Nhận dữ liệu từ Bundle của Fragment
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("obj")) {
            // Lấy đối tượng UngVien từ Bundle
            UngVien ungVien = (UngVien) bundle.getSerializable("obj");

            // Hiển thị thông tin lên TextView
           hovaten.setText(ungVien.getHoten());
           kinhnghiem.setText(ungVien.getKinhnghiem());
            // Các dòng code tương tự để hiển thị thông tin khác nếu cần

            btnprofile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DetailProfileFragment fragmentB = new DetailProfileFragment();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragmentB);
                    transaction.addToBackStack(null); // Để có thể quay lại FragmentA
                    transaction.commit();
                }
            });

        }
    }}