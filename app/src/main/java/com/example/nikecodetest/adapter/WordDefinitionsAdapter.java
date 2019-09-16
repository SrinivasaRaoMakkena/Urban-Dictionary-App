package com.example.nikecodetest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikecodetest.R;
import com.example.nikecodetest.databinding.ListItemBinding;
import com.example.nikecodetest.model.WordDefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class WordDefinitionsAdapter extends RecyclerView.Adapter<WordDefinitionsAdapter.DataViewHolder> {


    private List<WordDefinition> mWordDefinitions;
    private Context mContext;
    //private SchoolsContract  mContract;

    public WordDefinitionsAdapter(Context context) {
        this.mContext = context;
        mWordDefinitions = new ArrayList<WordDefinition>();
        // this.mContract = contract;

        System.out.println("length adapter constructor" + mWordDefinitions.size());
        //this.mSchoolsContract=sContract;
    }


    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        //System.out.println("length adapter create " + mWordDefinitions.size());
        ListItemBinding listItemBinding =
                DataBindingUtil.inflate(inflater, R.layout.list_item, parent,
                        false);
        viewHolder = new DataViewHolder(mContext, listItemBinding);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        //System.out.println("word definition size:  " + mWordDefinitions.size());
        holder.bind(mWordDefinitions.get(position));
    }

    @Override
    public int getItemCount() {
        System.out.println("length adapter item 1  " + mWordDefinitions.size());
        if (mWordDefinitions.size() > 0) {
            System.out.println("length adapter item 2 " + mWordDefinitions.size());
            return mWordDefinitions.size();
        }
        return 0;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;
        Context mContext;

        public DataViewHolder(Context context, ListItemBinding itemView) {
            super(itemView.getRoot());

            this.binding = itemView;
            this.mContext = context;
            binding.executePendingBindings();
        }


        void bind(WordDefinition definition) {
            if (null == binding.getData()) {
                binding.setData(
                        definition
                );
            }
        }


    }


    public void updateData(@Nullable List<WordDefinition> data) {
//
//        if (data.size() > this.mWordDefinitions.size()) {
//            this.mWordDefinitions.add(data.get(data.size() - 1));
//            notifyItemInserted(data.size() - 1);
//        } else {
        this.mWordDefinitions.clear();
        Collections.sort(data);
        this.mWordDefinitions.addAll(data);
        notifyDataSetChanged();

    }

}
