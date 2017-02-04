package com.gumtree.adsdemo.ui.databinding;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gumtree.adsdemo.addetails.AdditionalInformationAdapter;
import com.gumtree.adsdemo.addetails.net.models.AdditionalInformation;

/**
 * Created by marios on 4/2/2017.
 */

public class CommonBindingAdapter {
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, ObservableArrayList<AdditionalInformation> properties) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        recyclerView.setAdapter(new AdditionalInformationAdapter(properties));
     }
}