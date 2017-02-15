package com.mrpdev.demoapp.ads.viewmodel;

import android.databinding.BaseObservable;

import com.mrpdev.demoapp.ui.services.NavigationService;

/**
 * Created by marios on 4/2/2017.11
 */

public class MainViewModel extends BaseObservable {
    private NavigationService navigationService;

    public MainViewModel(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    public void gotoDetailsCommand() {
        String commandId = "123455";
        navigationService.gotoDetails(commandId);
    }
}
