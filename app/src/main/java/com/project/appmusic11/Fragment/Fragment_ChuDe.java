package com.project.appmusic11.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.project.appmusic11.Activity.TrangChuActivity;
import com.project.appmusic11.Adapter.ChuDeAdapter;
import com.project.appmusic11.Model.ChuDeModel;
import com.project.appmusic11.R;

import java.util.ArrayList;


public class Fragment_ChuDe extends Fragment {

    View view;
    ChuDeAdapter chuDeAdapter;
    RecyclerView recyclerViewChuDe;
    TextView tenChuDe;
    ArrayList<ChuDeModel> arrayChuDe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_chude, container, false);
        recyclerViewChuDe = view.findViewById(R.id.recyclerviewchude);
        tenChuDe = view.findViewById(R.id.txtchude);
        GetData();
        return view;
    }

    private void GetData() {
        arrayChuDe = new ArrayList<>();
        Cursor dataChuDe = TrangChuActivity.databaseHelper.getData("SELECT * FROM ChuDe");
        arrayChuDe.clear();
        while (dataChuDe.moveToNext()) {
            String MaChuDe =dataChuDe.getString(0);
            String TenChuDe = dataChuDe.getString(1);
            String HinhChuDe = dataChuDe.getString(2);
            arrayChuDe.add(new ChuDeModel(MaChuDe,TenChuDe,HinhChuDe));
        }
        chuDeAdapter = new ChuDeAdapter(getActivity(),arrayChuDe);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewChuDe.setLayoutManager(linearLayoutManager);
                recyclerViewChuDe.setAdapter(chuDeAdapter);
                dataChuDe.close();
            }
    }
