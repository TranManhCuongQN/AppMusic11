package com.project.appmusic11.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.appmusic11.Activity.MainActivity;
import com.project.appmusic11.R;

public class Fragment_Thoat extends Fragment {
    Button btn;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thoat, container, false);
        AnhXa();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(startMain);
                getActivity().finish();
                System.exit(0);
            }
        });
        return  view;
    }
    private void AnhXa() {
        btn = view.findViewById(R.id.btndangxuat);
    }
}
