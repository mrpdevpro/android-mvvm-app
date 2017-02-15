package com.mrpdev.demoapp.ui.databinding;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.mrpdev.demoapp.R;
import com.mrpdev.demoapp.addetails.AdImageAdapter;
import com.mrpdev.demoapp.addetails.AdditionalInformationAdapter;
import com.mrpdev.demoapp.addetails.net.models.AdditionalInformation;
import com.rd.PageIndicatorView;

import java.util.ArrayList;

/**
 * Created by marios on 4/2/2017.
 */

public class CommonBindingAdapter {
    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, ObservableArrayList<AdditionalInformation> properties) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        recyclerView.setAdapter(new AdditionalInformationAdapter(properties));
     }

    @BindingAdapter("images")
    public static void setImageList(ViewPager viewPager, ArrayList<String> imageList) {
        if(imageList != null) {
            viewPager.setAdapter(new AdImageAdapter(imageList));

            PageIndicatorView pageIndicatorView = (PageIndicatorView)viewPager.getRootView().findViewById(R.id.pageIndicatorView);
            pageIndicatorView.setViewPager(viewPager);
        }
    }
}