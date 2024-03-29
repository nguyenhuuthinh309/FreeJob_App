package com.example.sanphamdemo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sanphamdemo.R;
import com.example.sanphamdemo.user.UngVien;

public class LapCongTyFragment extends Fragment {
    String selectedValue;
    String a;
    public LapCongTyFragment() {
        // Required empty public constructor
    }

    public static LapCongTyFragment newInstance() {
        LapCongTyFragment fragment = new LapCongTyFragment();
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
        return inflater.inflate(R.layout.fragment_lapcongty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText masothue =  view.findViewById(R.id.masothue);

        EditText   tenct =  view.findViewById(R.id.tenct);

        EditText   diachi =   view.findViewById(R.id.diachi);

        EditText     edtLinhVuc =   view.findViewById(R.id.edtLinhVuc);

     Spinner   caidatbanspinner = (Spinner)  view.findViewById(R.id.caidatbanspinner);

    TextView btnCreateCompany = (TextView)  view.findViewById(R.id.btn_create_company);

        //ImageView    btnBack = (ImageView)  view.findViewById(R.id.btnBack);


        btnCreateCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        String[] items = {"", "1 Tháng", "3 Tháng","6 Tháng"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        caidatbanspinner.setAdapter(adapter);
        caidatbanspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id1) {
                // Xử lý khi một mục được chọn
                 selectedValue = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Xử lý khi không có mục nào được chọn
            }
        });

         btnCreateCompany.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Bundle bundle1 = getArguments();
                 if (bundle1 != null) {
                     // Lấy đối tượng UngVien từ Bundle
                     UngVien ungVien = (UngVien) bundle1.getSerializable("objungvien");
                     a = String.valueOf(ungVien.getIdUngVien());


                     if (ungVien != null) {

                         Bundle bundle = new Bundle();
                         String masothuegui = masothue.getText().toString();
                         String tengui = tenct.getText().toString();
                         String diachigui = diachi.getText().toString();
                         String linhvucgui = edtLinhVuc.getText().toString();
                         String kihangui = selectedValue;
                         bundle.putString("idUngVien",a);
                         bundle.putString("masothue",masothuegui);
                         bundle.putString("tenct", tengui);
                         bundle.putString("diachi", diachigui);
                         bundle.putString("linhvuc", linhvucgui);
                         bundle.putString("kihan", kihangui);
                         ThongtinhoadonFragment fragment = new ThongtinhoadonFragment();
                         fragment.setArguments(bundle);
                         FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                         transaction.replace(R.id.container, fragment);
                         transaction.addToBackStack(null); // Để có thể quay lại FragmentA
                         transaction.commit();
                     }
                 }



             }
         });


    }


}