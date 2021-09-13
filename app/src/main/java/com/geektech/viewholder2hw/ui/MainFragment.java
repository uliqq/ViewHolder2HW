package com.geektech.viewholder2hw.ui;

import android.os.Binder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geektech.viewholder2hw.R;
import com.geektech.viewholder2hw.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainFragment extends Fragment implements MainAdapter.OnClick {

    private MainAdapter adapter = new MainAdapter();
    private RecyclerView recyclerView;
    private ArrayList<Item> list = new ArrayList<>();
    private TextView toastTv;
    private ImageView toastIv;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createList();
        initRecycler(view);
        createDivider();
        initView(view);
    }

    private void initView(View view) {
        toastIv = view.findViewById(R.id.toastIv);
        toastTv = view.findViewById(R.id.toastTv);
    }

    private void createDivider() {
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    private void initRecycler(View view) {
        recyclerView = view.findViewById(R.id.mainRv);
        adapter.setList(list);
        recyclerView.setAdapter(adapter);
    }

    private void createList() {
        list.add(new Item(0, "Northern Lights", R.drawable.nl));
        list.add(new Item(1, "Nature"));
        list.add(new Item(0, "Forest", R.drawable.forest));
        list.add(new Item(1, "Hello"));
        list.add(new Item(0, "Mountains", R.drawable.mount));
        list.add(new Item(1, "Yooo, wassup!"));
        list.add(new Item(0, "Space", R.drawable.space));
        list.add(new Item(1, "Ni-i-i-i-i-ce"));
        list.add(new Item(0, "Village", R.drawable.village));
        list.add(new Item(1, "No way!"));
        list.add(new Item(0, "Northern Lights", R.drawable.nl));
        list.add(new Item(1, "C'mon!"));
        list.add(new Item(0, "Space", R.drawable.space));
        list.add(new Item(1, "Yessir!"));

        Collections.shuffle(list);
    }

    @Override
    public void onItemClick(Item item) {
        
        View layout = getLayoutInflater().inflate(R.layout.item_custom_toast, null);
        Toast toast = new Toast(getActivity().getBaseContext());
        toast.setGravity(Gravity.TOP,0,278);
        toast.setDuration(Toast.LENGTH_LONG);
        toastTv.setText(item.getTitle());
        toastIv.setImageResource(item.getImage());
        toast.setView(layout);
        toast.show();
    }
}