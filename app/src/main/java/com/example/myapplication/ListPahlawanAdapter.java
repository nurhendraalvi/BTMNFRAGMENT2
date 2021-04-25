package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListPahlawanAdapter extends RecyclerView.Adapter<ListPahlawanAdapter.ViewHolder> {

    private ArrayList<ListPahlawanModel> listHero = new ArrayList<>();
    private Context context;

    public ListPahlawanAdapter(ArrayList<ListPahlawanModel> listHero, Context context) {
        this.listHero = listHero;
        this.context = context;
    }

    public ArrayList<ListPahlawanModel> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_pahlawan, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //Glide.with(context).load(getListHero().get(position).getHeroImage()).into(holder.ivPahlawan);
        holder.ivPahlawan.setImageResource(getListHero().get(position).getHeroImage());
        holder.tvTitle.setText(getListHero().get(position).getHeroName());
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String heroName = "Your Hero is " + getListHero().get(position).getHeroName();
                intent.putExtra(Intent.EXTRA_TEXT, heroName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });


    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivPahlawan;
        TextView tvTitle;
        Button btnShare, btnPreview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPahlawan = itemView.findViewById(R.id.item_list_iv);
            tvTitle = itemView.findViewById(R.id.item_list_tv_title);
            btnShare = itemView.findViewById(R.id.item_list_btn_share);
            btnPreview = itemView.findViewById(R.id.item_list_btn_preview);
        }
    }
}
