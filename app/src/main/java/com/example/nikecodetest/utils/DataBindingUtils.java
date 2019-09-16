package com.example.nikecodetest.utils;


import com.example.nikecodetest.adapter.WordDefinitionsAdapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Srinivas on 9/15/2019.
 */

public class DataBindingUtils {

    /**
     * Set Adapter to Recycler View
     * This is used with the {adapter}
     * attributes in the app namespace.
     * This will work if you import DataBindingUtils and call method with arguments
     */
    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RecyclerView.Adapter<WordDefinitionsAdapter.DataViewHolder> viewHolderAdapter) {
        recyclerView.setAdapter(viewHolderAdapter);
    }

    /**
     * Set layoutManager to Recycler View
     * This is used with the {layoutManager}
     * attributes in the app namespace.
     * This will work if you import DataBindingUtils and call method with arguments
     */
    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }
}
