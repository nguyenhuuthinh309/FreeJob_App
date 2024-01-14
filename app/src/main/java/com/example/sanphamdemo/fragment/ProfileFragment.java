package com.example.sanphamdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.sanphamdemo.activity.DetailItemBaiDang;
import com.example.sanphamdemo.activity.Detail_CvtuyenDung;
import com.example.sanphamdemo.activity.PhanhoiCVActivity;
import com.example.sanphamdemo.user.Ban_User;
import com.example.sanphamdemo.user.CV_UngTuyen;
import com.example.sanphamdemo.user.UngVien;


public class ProfileFragment extends Fragment {

    private TextView hovaten1;
    private TextView role;
    private RelativeLayout vieclam;
    private TextView email;
    private TextView kinhnghiem;
    private TextView bangcap;
    private TextView diachi;
    private TextView sdt;
    private TextView update;
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

        hovaten1 = (TextView) view.findViewById(R.id.hovaten1);
        role = (TextView) view.findViewById(R.id.role);
        vieclam = (RelativeLayout) view.findViewById(R.id.vieclam);
        email = (TextView) view.findViewById(R.id.email);
        kinhnghiem = (TextView) view.findViewById(R.id.kinhnghiem);
        bangcap = (TextView) view.findViewById(R.id.bangcap);
        diachi = (TextView)view.findViewById(R.id.diachi);
        sdt = (TextView) view.findViewById(R.id.sdt);
        update = (TextView) view.findViewById(R.id.update);
        dangxuat = (TextView) view.findViewById(R.id.dangxuat);

        // Lấy Bundle từ Fragment
        Bundle bundle = getArguments();

        if (bundle != null) {
            // Lấy đối tượng UngVien từ Bundle
            UngVien ungVien = (UngVien) bundle.getSerializable("objungvien");

            if (ungVien != null) {
                hovaten1.setText(ungVien.getHoten());
                role.setText(ungVien.getRole());
                email.setText(ungVien.getEmail());
                diachi.setText(ungVien.getDiachi());
                sdt.setText(ungVien.getSdt());
                bangcap.setText(ungVien.getBangcap());
                kinhnghiem.setText(ungVien.getKinhnghiem());


                vieclam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onClickItem(ungVien);
                    }
                });

            }
        }




        }
    private void onClickItem(UngVien request) {
        Intent intent = new Intent(getContext(), PhanhoiCVActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("obj",request);
        intent.putExtras(bundle);
        getContext().startActivity(intent);
    }
    }