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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.project.appmusic11.Activity.TrangChuActivity;
import com.project.appmusic11.Adapter.ThuVienPlayListAdapter;
import com.project.appmusic11.Model.ThuVienPlayListModel;
import com.project.appmusic11.R;

import java.util.ArrayList;


public class Fragment_ThuVien_Playlist extends Fragment {
    View view;
    ThuVienPlayListAdapter thuVienPlayListAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerViewThuVienPlayList;
    TextView tenThuVienPlayList;
    ArrayList<ThuVienPlayListModel> mangthuvienplaylist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thuvien_playlist, container, false);
        recyclerViewThuVienPlayList = view.findViewById(R.id.recyclerviewthuvienplaylist);
        tenThuVienPlayList = view.findViewById(R.id.textviewthuvienplaylist);
        GetData();
        swipeRefreshLayout = view.findViewById(R.id.swipethuvien);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                GetData();
                thuVienPlayListAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
        return view;
    }
    public void GetData() {
        mangthuvienplaylist = new ArrayList<>();
        mangthuvienplaylist.clear();
        Cursor dataThuVienPlayList = TrangChuActivity.databaseHelper.getData("SELECT * FROM ThuVienPlayList ");
        while (dataThuVienPlayList.moveToNext()) {
            int MaThuVienPlayList = dataThuVienPlayList.getInt(0);
            String TenThuVienPlayList = dataThuVienPlayList.getString(1);
            String HinhThuVienPlayList = dataThuVienPlayList.getString(2);
            mangthuvienplaylist.add(new ThuVienPlayListModel(MaThuVienPlayList, TenThuVienPlayList,HinhThuVienPlayList));
    }
                thuVienPlayListAdapter = new ThuVienPlayListAdapter(getActivity(), mangthuvienplaylist);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewThuVienPlayList.setLayoutManager(linearLayoutManager);
                recyclerViewThuVienPlayList.setAdapter(thuVienPlayListAdapter);
            }
    }
