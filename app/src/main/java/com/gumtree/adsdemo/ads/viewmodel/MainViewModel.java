package com.gumtree.adsdemo.ads.viewmodel;

import android.databinding.BaseObservable;

import com.gumtree.adsdemo.ui.services.NavigationService;

/**
 * Created by marios on 4/2/2017.
 */

public class MainViewModel extends BaseObservable {
    private NavigationService navigationService;

    public MainViewModel(NavigationService navigationService){
        this.navigationService = navigationService;
    }

    public void gotoDetailsCommand(){
        String commandId = "123455";
        navigationService.gotoDetails(commandId);
    }
}
