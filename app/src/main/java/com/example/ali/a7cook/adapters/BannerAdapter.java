package com.example.ali.a7cook.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ali.a7cook.R;
import com.example.ali.a7cook.data.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    private List<Banner> banners;
    public BannerAdapter(List<Banner> banners) {
        this.banners = banners;
    }


    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner,parent,false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        holder.bindBanner(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView bannerImageView;
        public BannerViewHolder(View itemView) {
            super(itemView);
            bannerImageView= (ImageView)itemView;
        }

        public void bindBanner(Banner banner)
        {
            Picasso.get().load(banner.getImg()).into(bannerImageView);
        }
    }
}
