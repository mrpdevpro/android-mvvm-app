package com.gumtree.adsdemo.ui.services;

import android.content.Context;
import android.content.Intent;

import com.gumtree.adsdemo.addetails.AdDetailsActivity;

/**
 * Wraps the navigation details from activity to activity
 * Provided by D.I. to viewmodels
  */
public class NavigationService {
    private Context context;

    public NavigationService(Context context) {

        this.context = context;
    }
    public void gotoDetails(String id){
        Intent intent = new Intent(context,AdDetailsActivity.class);
        intent.putExtra("adId",id);

        context.startActivity(intent);
    }
}
