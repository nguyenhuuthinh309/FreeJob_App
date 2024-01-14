package com.example.sanphamdemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.adapter.MyAdapter2;
import com.example.sanphamdemo.interfaceall.Interface_GetCongTy;
import com.example.sanphamdemo.interfaceall.Interface_getbaidangtheocongty;
import com.example.sanphamdemo.user.Ban_User;
import com.example.sanphamdemo.user.HoaDonCongTyy;
import com.example.sanphamdemo.user.UngVien;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CongTyCuaToiFragment extends Fragment {
    MyAdapter2 adapter1;
    private ArrayList<Ban_User> arrayList = new ArrayList<>();
    private LinearLayout linearLayout6,detail_congty;
    private TextView tencongty;
    private TextView masothue1;
    private LinearLayout linearMore;
    private EditText textsearch;
    private ImageView imagesearch;
    private TextView tvTitleViecTot,dangbai;
    private RecyclerView recyclerViewBaidang;
      List<HoaDonCongTyy> mlist= new ArrayList<>();
    List<Ban_User> mlist1= new ArrayList<>();
    String a;
    String tencongt;
    public CongTyCuaToiFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CongTyCuaToiFragment newInstance() {
        CongTyCuaToiFragment fragment = new CongTyCuaToiFragment();
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
        return inflater.inflate(R.layout.fragment_cong_ty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout6 = (LinearLayout) view.findViewById(R.id.linearLayout6);
        tencongty = (TextView)  view.findViewById(R.id.tencongty);
        masothue1 = (TextView)  view.findViewById(R.id.masothue1);
        linearMore = (LinearLayout)  view.findViewById(R.id.linearMore);
        textsearch = (EditText)  view.findViewById(R.id.textsearch);
        imagesearch = (ImageView)  view.findViewById(R.id.imagesearch);
        tvTitleViecTot = (TextView)  view.findViewById(R.id.tvTitle_viecTot);
        recyclerViewBaidang = (RecyclerView) view. findViewById(R.id.recyclerView_baidang);
        detail_congty = view.findViewById(R.id.detail_congty);
        dangbai = view.findViewById(R.id.dangbai);

        adapter1 = new MyAdapter2(getActivity());
        adapter1.setData((ArrayList<Ban_User>) mlist1);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerViewBaidang.setLayoutManager(linearLayoutManager2);
        recyclerViewBaidang.setAdapter(adapter1);

        Bundle bundle = getArguments();
        if (bundle != null) {
            // Lấy đối tượng UngVien từ Bundle
            UngVien ungVien = (UngVien) bundle.getSerializable("objungvien");
             a = String.valueOf(ungVien.getIdHoaDonCongTy());


            if (ungVien != null) {
                masothue1.setText("Mã Số Thuế : "+ a);

            }
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:3000/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        Interface_GetCongTy interfaceDelete = retrofit.create(Interface_GetCongTy.class);
        Call<List<HoaDonCongTyy>> call = interfaceDelete.getCongTy(a);
        call.enqueue(new Callback<List<HoaDonCongTyy>>() {
            @Override
            public void onResponse(Call<List<HoaDonCongTyy>> call, Response<List<HoaDonCongTyy>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<HoaDonCongTyy> ungVienResponse = response.body();
                    mlist.addAll(ungVienResponse);
                    for (HoaDonCongTyy myObject : ungVienResponse) {


                      tencongty.setText(myObject.getTenCongTy());
                      tencongt= myObject.getTenCongTy();


                        detail_congty.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putString("tenct", myObject.getTenCongTy());
                                bundle.putString("masothue", String.valueOf(myObject.getIdHoaDonCongTy()));
                                bundle.putString("diachi", myObject.getDiaChi());
                                bundle.putString("linhvuc", myObject.getLinhVuc());
                                bundle.putString("kihan", myObject.getKiHan());

                                ShowCompanyFragment fragmentB = new ShowCompanyFragment();
                                fragmentB.setArguments(bundle);
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragmentB)
                                        .addToBackStack(null)  // Để thêm Fragment B vào Stack, để có thể quay lại Fragment A
                                        .commit();

                            }
                        });

                        dangbai.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Bundle bundle = new Bundle();
                                bundle.putString("tenct", myObject.getTenCongTy());
                                bundle.putString("masothue", String.valueOf(myObject.getIdHoaDonCongTy()));
                                bundle.putString("diachi", myObject.getDiaChi());
                                bundle.putString("linhvuc", myObject.getLinhVuc());
                                bundle.putString("kihan", myObject.getKiHan());

                                DangBaiFragment fragmentB = new DangBaiFragment();
                                fragmentB.setArguments(bundle);
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.container, fragmentB)
                                        .addToBackStack(null)  // Để thêm Fragment B vào Stack, để có thể quay lại Fragment A
                                        .commit();
                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<List<HoaDonCongTyy>> call, Throwable t) {
                // Xử lý khi có lỗi kết nối
                Toast.makeText(getContext(), "Lỗi kết nối Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("zzzzzzzz", t.getMessage());

            }
        });


        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:3000/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();

        Interface_getbaidangtheocongty interfaceDelete1 = retrofit1.create(Interface_getbaidangtheocongty.class);
        Call<List<Ban_User>> call1 = interfaceDelete1.getBaidangtheocongty(a);
        call1.enqueue(new Callback<List<Ban_User>>() {
            @Override
            public void onResponse(Call<List<Ban_User>> call1, Response<List<Ban_User>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Ban_User> ungVienResponse = response.body();
                    mlist1.addAll(ungVienResponse);
                   adapter1.notifyDataSetChanged();
                    Log.d("zzzzzzzzzzzzzzzzzz", "true"+mlist1.size()+"");
                }else {
                    Log.d("zzzzzzzzzzzzzzzzzz", "faile"+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Ban_User>> call1, Throwable t) {
                // Xử lý khi có lỗi kết nối
                Toast.makeText(getContext(), "Lỗi kết nối Server " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("zzzzzzzz", t.getMessage());

            }
        });



    }
}