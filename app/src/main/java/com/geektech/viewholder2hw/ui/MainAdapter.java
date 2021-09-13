package com.geektech.viewholder2hw.ui;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.viewholder2hw.R;
import com.geektech.viewholder2hw.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int TYPE_WITH_IMG = 0;
    private final int TYPE_WITH_TXT = 1;

    private ArrayList<Item> list = new ArrayList<>();

    private OnClick onClick;

    public void setList(ArrayList<Item> list) {
        this.list.addAll(list);
        this.onClick = onClick;
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        int i = 0;

        switch (list.get(position).getType()) {
            case 0:
                i = TYPE_WITH_IMG;
                break;
            case 1:
                i = TYPE_WITH_TXT;
                break;
        }
        return i;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_WITH_TXT:
                View TxtView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv, parent, false);
                return new ViewHolderTxt(TxtView);
            case TYPE_WITH_IMG:
                View imageView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_iv, parent, false);
                return new ViewHolderImage(imageView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_WITH_TXT:
                 ((ViewHolderTxt)holder).onBind(list.get(position));
                break;

            case TYPE_WITH_IMG:
                ((ViewHolderImage)holder).onBind(list.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolderImage extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView subTxt;

        public ViewHolderImage(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mainIv);
            subTxt = itemView.findViewById(R.id.subTv);
        }

        public void onBind(Item item) {
            image.setImageResource(item.getImage());
            subTxt.setText(item.getTitle());

            itemView.setOnClickListener(v -> {
                onClick.onItemClick(item);
            });
        }
    }

    public class ViewHolderTxt extends RecyclerView.ViewHolder {

        private TextView text;

        public ViewHolderTxt(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.mainTv);
        }

        public void onBind(Item item) {
            text.setText(item.getTitle());

            itemView.setOnClickListener(v -> {
                onClick.onItemClick(item);
            });
        }
    }

    public interface OnClick {
        void onItemClick (Item item);
    }
}
