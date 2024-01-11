package com.example.sanphamdemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.adapter.RequestAdapter;
import com.example.sanphamdemo.user.ServerResponse;
import com.example.sanphamdemo.user.HoaDonCongTyy;
import com.example.sanphamdemo.interfaceall.Interface_HoaDonCongTy;
import com.example.sanphamdemo.interfaceall.Interface_AddYeucau;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThongtinhoadonFragment extends Fragment {
    private ImageView imageView;
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView dathanhtoan;
    private RequestAdapter adapter1;
    private RecyclerView recyclerView;


    private ArrayList<HoaDonCongTyy> arrayList = new ArrayList<>();
    private RequestAdapter adapter;

    String msthue,tenct,diachi,linhvuc,kihan;

    public ThongtinhoadonFragment() {
        // Required empty public constructor
    }


    public static ThongtinhoadonFragment newInstance() {
        ThongtinhoadonFragment fragment = new ThongtinhoadonFragment();
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
        return inflater.inflate(R.layout.fragment_thongtinhoadon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imageView = (ImageView) view.findViewById(R.id.imageView);



        imageView = (ImageView) view.findViewById(R.id.imageView);
        dathanhtoan = (TextView) view.findViewById(R.id.dathanhtoan1);
        a = view.findViewById(R.id.a);
        b = (TextView) view.findViewById(R.id.b);
        c = (TextView) view.findViewById(R.id.c);
        d = (TextView) view.findViewById(R.id.d);
        e = (TextView) view.findViewById(R.id.e);



        // Trong onCreateView hoặc onViewCreated
        Bundle bundle = getArguments();

            // Xử lý dữ liệu nhận được ở đây


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


        if (kihan == "") {

            Toast.makeText(getContext(), "0 thang", Toast.LENGTH_SHORT).show();
        } else if (kihan.equals("1 Tháng")) {
            int tien = 85000;
            Toast.makeText(getContext(), "1 thang", Toast.LENGTH_SHORT).show();
            String imageUrl = "https://api.vietqr.io/image/970422-999993092003-mpJvWLi.jpg?accountName=NGUYEN%20HUU%20THINH&amount="+tien+"&addInfo=Thanh%20toan%201 thang";
            Picasso.get().load(imageUrl).into(imageView);
        }else if (kihan.equals("3 Tháng")) {
            int tien = 150000;
            Toast.makeText(getContext(), "3 thang", Toast.LENGTH_SHORT).show();
            String imageUrl = "https://api.vietqr.io/image/970422-999993092003-mpJvWLi.jpg?accountName=NGUYEN%20HUU%20THINH&amount="+tien+"&addInfo=Thanh%20toan%203 thang";
            Picasso.get().load(imageUrl).into(imageView);

        } else if (kihan.equals("6 Tháng")) {
            int tien = 220000;
            Toast.makeText(getContext(), "6 thang", Toast.LENGTH_SHORT).show();
            String imageUrl = "https://api.vietqr.io/image/970422-999993092003-mpJvWLi.jpg?accountName=NGUYEN%20HUU%20THINH&amount="+tien+"&addInfo=Thanh%20toan%206 thang";
            Picasso.get().load(imageUrl).into(imageView);

        }else {
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        }


        dathanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getArguments();
                 msthue = bundle.getString("masothue");
                 tenct = bundle.getString("tenct");
                 diachi = bundle.getString("diachi");
                 linhvuc = bundle.getString("linhvuc");
                 kihan = bundle.getString("kihan");
                 String giatien1="0";
                 if (kihan.equals("1 Tháng")){
                     giatien1 = "85.000";

                 } else  if (kihan.equals("3 Tháng")){
                    giatien1 = "150.000";

                }else{
                     giatien1 = "220.000";
                 }


                String requestId = msthue ;
                 String tenctyeucau = tenct;
                String trangthai = "0";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.6:3000/")
                        .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                        .build();

                Interface_AddYeucau interfaceDelete = retrofit.create(Interface_AddYeucau.class);
                Call<ServerResponse> call = interfaceDelete.addYeuCau(requestId,trangthai,tenctyeucau,giatien1);
                call.enqueue(new Callback<ServerResponse>() {
                    @Override
                    public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                        if (response.isSuccessful()) {
                            ServerResponse svrResponseDelete = response.body();

                            dathanhtoan.setText("Chờ Xác Nhận");
                            Toast.makeText(getContext(), "Chờ Xác Nhận", Toast.LENGTH_SHORT).show();

                            String trangthai = "Chưa Xác Nhận";
                           String thanhtien = "0";
                           if (kihan.equals("1 Tháng")){
                               thanhtien ="85.000 Đ";
                           }else
                            if (kihan.equals("3 Tháng")){
                                thanhtien ="150.000 Đ";
                            }else
                            if (kihan.equals("6 Tháng")){
                                thanhtien ="220.000 Đ";
                            }else {
                                thanhtien ="0";
                            }
                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("http://192.168.1.6:3000/")
                                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                                    .build();

                            Interface_HoaDonCongTy interfaceDelete = retrofit.create(Interface_HoaDonCongTy.class);
                            Call<HoaDonCongTyy> call1 = interfaceDelete.adDHoadonCongTy(Integer.parseInt(msthue),"2",tenct,diachi,linhvuc,kihan,trangthai,thanhtien);
                            call1.enqueue(new Callback<HoaDonCongTyy>() {
                                @Override
                                public void onResponse(Call<HoaDonCongTyy> call, Response<HoaDonCongTyy> response) {
                                    if (response.isSuccessful()) {
                                        HoaDonCongTyy svrResponseDelete = response.body();

                                    } else {
                                        try {
                                            String errorBody = response.errorBody().string();
                                            Toast.makeText(getContext(), "add thất bại: " + errorBody, Toast.LENGTH_SHORT).show();

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<HoaDonCongTyy> call, Throwable t) {
                                    // Xử lý lỗi kết nối
                                    Toast.makeText(getContext(), "lỗi kết nối", Toast.LENGTH_SHORT).show();
                                }
                            });



                        } else {
                            try {
                                String errorBody = response.errorBody().string();
                                Toast.makeText(getContext(), "add thất bại: " + errorBody, Toast.LENGTH_SHORT).show();

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ServerResponse> call, Throwable t) {
                        // Xử lý lỗi kết nối
                        Toast.makeText(getContext(), "lỗi kết nối", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}


