package com.example.sanphamdemo.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.activity.DetailItemBaiDang;
import com.example.sanphamdemo.activity.Detail_CvtuyenDung;
import com.example.sanphamdemo.activity.Home;
import com.example.sanphamdemo.activity.PhanhoiCVActivity;
import com.example.sanphamdemo.activity.SuaFrofileActivity;
import com.example.sanphamdemo.activity.SuabaidangActivity;
import com.example.sanphamdemo.dangnhap.DangNhap;
import com.example.sanphamdemo.dangnhap.TaikhoanJob;
import com.example.sanphamdemo.interfaceall.Interface_UngVien;
import com.example.sanphamdemo.interfaceall.Interface_XoaYeuCau;
import com.example.sanphamdemo.user.Ban_User;
import com.example.sanphamdemo.user.CV_UngTuyen;
import com.example.sanphamdemo.user.Delete_YeuCau;
import com.example.sanphamdemo.user.UngVien;
import com.example.sanphamdemo.user.UngVienResponse;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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


        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Bạn có chắc muốn thoát?")
                        .setPositiveButton("Chấp nhận", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                               startActivity(new Intent(getContext(), TaikhoanJob.class));
                            }
                        })
                        .setNegativeButton("Từ chối", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.create().show();

            }
        });
        // Lấy Bundle từ Fragment
        Bundle bundle = getArguments();

        if (bundle != null) {
            // Lấy đối tượng UngVien từ Bundle
            UngVien ungVien = (UngVien) bundle.getSerializable("objungvien");

            if (ungVien != null) {

                SharedPreferences sharedPreferences = getContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

// Lấy thông tin người dùng từ SharedPreferences
                int userId = sharedPreferences.getInt("user_id", -1);
                String userEmail = sharedPreferences.getString("user_email", "");
                String userMatKhau = sharedPreferences.getString("user_matkhau", "");

// Kiểm tra xem thông tin đã được lưu thành công hay không
                if (userId != -1) {
                    // Thực hiện các thao tác với userId, userEmail, userMatKhau
                    Log.d("UserInfo", "User ID: " + userId);
                    Log.d("UserInfo", "User Email: " + userEmail);
                    Log.d("UserInfo", "User MatKhau: " + userMatKhau);
                } else {
                    // Trường hợp không tìm thấy giá trị, bạn có thể xử lý tùy ý
                    Log.e("UserInfo", "User ID not found in SharedPreferences");
                }

                hovaten1.setText(ungVien.getHoten());
                role.setText(ungVien.getRole());
                email.setText(ungVien.getEmail());
                diachi.setText(ungVien.getDiachi());
                sdt.setText(ungVien.getSdt());
                bangcap.setText(ungVien.getBangcap());
                kinhnghiem.setText(ungVien.getKinhnghiem());
                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getContext(), SuaFrofileActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("obj",ungVien);
                        intent.putExtras(bundle);
                        getContext().startActivity(intent);
                    }
                });


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