package com.project.appmusic11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.appmusic11.Activity.PlayNhacActivity;
import com.project.appmusic11.Model.BaiHatYeuThichModel;
import com.project.appmusic11.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YeuThichAdapter extends RecyclerView.Adapter<YeuThichAdapter.ViewHolder>{

    Context context;
    ArrayList<BaiHatYeuThichModel> mangbaihatyeuthich;
    View view;

    public YeuThichAdapter(Context context, ArrayList<BaiHatYeuThichModel> mangbaihatyeuthich) {
        this.context = context;
        this.mangbaihatyeuthich = mangbaihatyeuthich;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_yeuthich,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHatYeuThichModel baiHatYeuThichModel = mangbaihatyeuthich.get(position);
        holder.txtTenBaiHat.setText(baiHatYeuThichModel.getTenBaiHat());
        holder.txtTenCaSi.setText(baiHatYeuThichModel.getTenCaSi());
        Picasso.get().load(baiHatYeuThichModel.getHinhBaiHat()).into(holder.img);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlayNhacActivity.class);
                intent.putExtra("cakhucyeuthich", mangbaihatyeuthich.get(holder.getBindingAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangbaihatyeuthich.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtTenBaiHat, txtTenCaSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgnhacyeuthich);
            txtTenBaiHat = itemView.findViewById(R.id.txttennhacyeuthich);
            txtTenCaSi = itemView.findViewById(R.id.txtcasiyeuthich);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhucyeuthich", mangbaihatyeuthich.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
