package com.papermelody.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.papermelody.R;
import com.papermelody.model.OnlineMusic;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HgS_1217_ on 2017/4/10.
 */

public class MusicHallRecyclerViewAdapter extends RecyclerView.Adapter<MusicHallRecyclerViewAdapter.ViewHolder>  {
    /**
     * 音乐圈用于显示作品的RecyclerView的Adapter
     */

    private LayoutInflater layoutInflater;
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<OnlineMusic> onlineMusics;

    public MusicHallRecyclerViewAdapter (Context context) {
        this.context = context;
        onlineMusics = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    public MusicHallRecyclerViewAdapter (Context context, List<OnlineMusic> musics) {
        this.context = context;
        onlineMusics = new ArrayList<>(musics);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_online_music, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setView(onlineMusics.get(position));
        holder.itemView.setOnClickListener((View view) -> {
            int pos = holder.getLayoutPosition();
            onItemClickListener.OnItemClick(onlineMusics.get(pos));
        });
    }

    @Override
    public int getItemCount() {
        if (onlineMusics == null) {
            return 0;
        }
        return onlineMusics.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        /* 持有每个item的所有界面元素 */

        @BindView(R.id.item_img_online_music)
        ImageView imgOnlineMusic;
        @BindView(R.id.item_text_online_music_title)
        TextView textTitle;
        @BindView(R.id.item_text_online_music_author)
        TextView textAuthor;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        private void setView(OnlineMusic music) {
            textTitle.setText(music.getMusicName());
            textAuthor.setText(music.getMusicAuthor());
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void OnItemClick(OnlineMusic music);
    }
}
