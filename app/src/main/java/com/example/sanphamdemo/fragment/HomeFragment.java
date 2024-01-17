package com.example.sanphamdemo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sanphamdemo.R;

import com.example.sanphamdemo.adapter.HomeSliderAdapter;
import com.example.sanphamdemo.adapter.MyAdapter;
import com.example.sanphamdemo.adapter.YourResponseClass;
import com.example.sanphamdemo.interfaceall.Interface_ListBan;
import com.example.sanphamdemo.user.Ban_User;
import com.example.sanphamdemo.user.UngVien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private HomeSliderAdapter sliderAdapter;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    LinearLayout linearLayout6;
    ViewPager2 viewPagerSlide;
    ImageView textView18;
    ImageView textView19;
    LinearLayout linearMore;
    RelativeLayout relativeCty;
    ImageView imgCty;
    RelativeLayout relativeViecLam;
    ImageView imgViecLam;
    RelativeLayout relativeLuong;
    ImageView imgLuong,imagesearch;
    TextView tvTitleViecTot,textsearch;
    RecyclerView recyclerView_ViecTot;


    TextView tvTitleViecGoiY;
    RecyclerView recyclerView_ViecGoiY;
    RecyclerView.LayoutManager layoutManager_ViecGoiY;
    RecyclerView.LayoutManager layoutManager;
   // AdapterItem adapter1;
    private GridView gridView;
    private ArrayList<Ban_User> arrayList = new ArrayList<>();
    private ArrayList<UngVien> arrayListungven = new ArrayList<>();
    private List<YourResponseClass> arrayList3 = new ArrayList<>();
     MyAdapter adapter1;
    UngVien ungVien;
    private ArrayList<Ban_User> arrayList2 = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout6 = (LinearLayout) view.findViewById(R.id.linearLayout6);
        viewPagerSlide = (ViewPager2) view.findViewById(R.id.viewPagerSlide);
        textView18 = (ImageView) view.findViewById(R.id.textView18);
        imagesearch = (ImageView) view.findViewById(R.id.imagesearch);
        linearMore = (LinearLayout) view.findViewById(R.id.linearMore);
        textsearch = (TextView) view.findViewById(R.id.textsearch);
        tvTitleViecTot = (TextView) view.findViewById(R.id.tvTitle_viecTot);
        recyclerView_ViecTot = (RecyclerView) view.findViewById(R.id.recyclerView_viecTot);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ungVien = (UngVien) bundle.getSerializable("objungvien");
         //   Log.d("vvvvvvvvvvvvv", "123 : "+ ungVien.getIdUngVien());
            if (ungVien != null) {



            }
        }
        adapter1 = new MyAdapter(getActivity());
        adapter1.setData(arrayList);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView_ViecTot.setLayoutManager(linearLayoutManager2);
        recyclerView_ViecTot.setAdapter(adapter1);



String edit = textsearch.getText().toString();




        setupSlider();
     loadbaidang();

    }

    private void loadbaidang() {
        // Tạo Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.6:3000/") // Điền địa chỉ cơ sở của API của bạn
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Tạo instance của ApiService từ Retrofit
        Interface_ListBan apiService = retrofit.create(Interface_ListBan.class);

        // Gọi API để lấy dữ liệu
        Call<List<Ban_User>> call = apiService.getListProductlike();
        call.enqueue(new Callback<List<Ban_User>>() {
            @Override
            public void onResponse(Call<List<Ban_User>> call, Response<List<Ban_User>> response) {
                // Xử lý dữ liệu khi nhận được
                List<Ban_User> responseData = response.body();

                // Cập nhật dataList và thông báo thay đổi trong Adapter
                arrayList.addAll(responseData);
                adapter1.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Ban_User>> call, Throwable t) {
                // Xử lý khi có lỗi xảy ra
                Log.e("MainActivity", "Error: " + t.getMessage());
            }
        });
    }

    private void setupSlider() {
        List<Integer> imageList = Arrays.asList(
                R.drawable.card_image_1,
                R.drawable.card_image_2,
                R.drawable.card_image_3,
                R.drawable.card_image_4
        );

        sliderAdapter = new HomeSliderAdapter(imageList);
        viewPagerSlide.setAdapter(sliderAdapter);

        // Auto chuyển đổi slide mỗi 3 giây
        runnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = viewPagerSlide.getCurrentItem();
                int totalItems = imageList.size();
                int nextItem = (currentItem + 1) % totalItems;
                viewPagerSlide.setCurrentItem(nextItem);
                handler.postDelayed(this, 3000); // 3000 milliseconds = 3 seconds
            }
        };
        // Khởi động auto chuyển đổi
        handler.postDelayed(runnable, 3000); // 3000 milliseconds = 3 seconds
    }
}