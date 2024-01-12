package com.example.sanphamdemo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.dangnhap.DangNhap;
import com.example.sanphamdemo.fragment.Admin_DSyeucau_Fragment;
import com.example.sanphamdemo.fragment.HomeFragment;
import com.example.sanphamdemo.fragment.KhamPhaFragment;
import com.example.sanphamdemo.fragment.LapCongTyFragment;
import com.example.sanphamdemo.fragment.MenuFragment;
import com.example.sanphamdemo.fragment.ProfileFragment;
import com.example.sanphamdemo.fragment.ThongBaoFragment;
import com.example.sanphamdemo.fragment.YeuThichFragment;
import com.example.sanphamdemo.user.UngVien;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    private NavigationView navigationView;
    MenuItem unLockAccItem;
    MenuItem companyManegeItem;
    TextView email1, hotem1;
    Menu menu;
    private Toolbar mToolbar;
    UngVien ungVien;
    private static final String TAG = "YourActivity";

    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        bind();
        mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(mToolbar); // add toolbar vào ứng dụng
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,mToolbar,0,0);
        toggle.syncState();// tạo nút 3 gạch trên actionbar

        setupBottomNavigationView();
        showInitialFragment();

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        if (intent != null) {
            // Kiểm tra xem Intent có chứa dữ liệu không
            if (intent.hasExtra("objungvien")) {
                // Lấy đối tượng UngVien từ Intent
                UngVien ungVien = (UngVien) intent.getSerializableExtra("objungvien");
                     // email1.setText(ungVien.getHoten());
                // Thực hiện các thao tác khác với dữ liệu
            }
        }
        // Nhận dữ liệu từ Intent
        // Nhận dữ liệu từ Intent


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.dsbaidang) {
            replaceFragment(HomeFragment.newInstance());
        } else if (item.getItemId() == R.id.lapct) {
            replaceFragment(LapCongTyFragment.newInstance());
        } else if (item.getItemId() == R.id.thongbao) {
            replaceFragment(ThongBaoFragment.newInstance());
        } else if (item.getItemId() == R.id.admin_danhsachyeucau) {
            replaceFragment(Admin_DSyeucau_Fragment.newInstance());
        }



        item.setCheckable(false);

        // Đóng Navigation Drawer sau khi xử lý sự kiện
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        ///////////////////

    }
    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void bind(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navigationView = findViewById(R.id.nav_view);


        email1 = navigationView.getHeaderView(0).findViewById(R.id.profile_name);
        hotem1 = navigationView.getHeaderView(0).findViewById(R.id.profile_email);




        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        menu = navigationView.getMenu();



    }

    private void setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private void showInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;

                int itemId = item.getItemId(); // Lưu lại giá trị R.id để sử dụng trong lambda


                if (item.getItemId() == R.id.bnav_home) {
                    selectedFragment = new HomeFragment();
                } else if (item.getItemId() == R.id.bnav_yeuThich) {
                    selectedFragment = new YeuThichFragment();
                } else if (item.getItemId() == R.id.bnav_khamPha) {
                    selectedFragment = new KhamPhaFragment();
                } else if (item.getItemId() == R.id.bnav_menu) {
                    selectedFragment = new MenuFragment();

                }


                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                }

                return true;
            };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
        replaceFragment(HomeFragment.newInstance());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");

    }


}