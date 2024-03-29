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
import com.project.appmusic11.Adapter.NgheSiAdapter;
import com.project.appmusic11.Model.NgheSiModel;
import com.project.appmusic11.R;

import java.util.ArrayList;


public class Fragment_NgheSi extends Fragment {

    View view;
    NgheSiAdapter ngheSiAdapter;
    RecyclerView recyclerViewNgheSi;
    TextView tenNgheSi;
    ArrayList<NgheSiModel> arrayNgheSi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_nghesi, container, false);
        recyclerViewNgheSi = view.findViewById(R.id.recyclerviewnghesi);
        tenNgheSi = view.findViewById(R.id.txtnghesi);
        GetData();
        return view;
    }

    private void GetData() {
        arrayNgheSi = new ArrayList<>();
        Cursor dataNgheSi = TrangChuActivity.databaseHelper.getData("SELECT * FROM NgheSi");
        arrayNgheSi.clear();
        while (dataNgheSi.moveToNext()) {
                 String MaNgheSi =dataNgheSi.getString(0);
                 String TenNgheSi = dataNgheSi.getString(1);
                 String HinhNgheSi = dataNgheSi.getString(2);
                 arrayNgheSi.add(new NgheSiModel(MaNgheSi,TenNgheSi,HinhNgheSi));
              }
                ngheSiAdapter = new NgheSiAdapter(getActivity(), arrayNgheSi);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewNgheSi.setLayoutManager(linearLayoutManager);
                recyclerViewNgheSi.setAdapter(ngheSiAdapter);
                dataNgheSi.close();
    }

}
