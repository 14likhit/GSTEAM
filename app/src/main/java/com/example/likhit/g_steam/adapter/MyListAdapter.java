package com.example.likhit.g_steam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.likhit.g_steam.R;
import com.example.likhit.g_steam.model.GameList;

import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    Context context;

    private List<GameList> mDataset;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public ImageView imageView;


        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.icon);


        }
    }
   /* public void add(int position, GameList item) {
        mDataset.add(position, item);
        notifyItemInserted(position);
    }
    public void remove(GameList item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
*/
    public MyListAdapter(List<GameList> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_game, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(mDataset.get(position).getGame());
        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getThumbailurl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
