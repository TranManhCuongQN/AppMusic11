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
import com.project.appmusic11.Adapter.PlaylistAdapter;
import com.project.appmusic11.Model.PlayListModel;
import com.project.appmusic11.R;

import java.util.ArrayList;


public class Fragment_Playlist extends Fragment {
    View view;
    PlaylistAdapter playlistAdapter;
    RecyclerView recyclerViewplaylist;
    TextView tenPlaylist;
    ArrayList<PlayListModel> arrayPlayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist, container, false);
        recyclerViewplaylist = view.findViewById(R.id.recyclerviewplaylist);
        tenPlaylist = view.findViewById(R.id.txtplaylist);
        GetData();
        return view;
    }

    private void GetData() {
       arrayPlayList = new ArrayList<>();
        Cursor dataPlayList= TrangChuActivity.databaseHelper.getData("SELECT * FROM PlayList");
        arrayPlayList.clear();
        while (dataPlayList.moveToNext()) {
            String MaPlayList = dataPlayList.getString(0);
            String TenPlayList = dataPlayList.getString(1);
            String HinhPlayList = dataPlayList.getString(2);
            arrayPlayList.add(new PlayListModel(MaPlayList, TenPlayList, HinhPlayList));
        }
              playlistAdapter = new PlaylistAdapter(getActivity(),arrayPlayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewplaylist.setLayoutManager(linearLayoutManager);
                recyclerViewplaylist.setAdapter(playlistAdapter);
                dataPlayList.close();
            }

    }
