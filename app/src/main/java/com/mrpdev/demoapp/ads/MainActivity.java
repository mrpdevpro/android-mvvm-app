package com.mrpdev.demoapp.ads;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mrpdev.demoapp.R;
import com.mrpdev.demoapp.ads.viewmodel.MainViewModel;
import com.mrpdev.demoapp.databinding.ActivityMainBinding;
import com.mrpdev.demoapp.ui.common.GumTreeActivity;

import javax.inject.Inject;

public class MainActivity extends GumTreeActivity {

    @Inject
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();

        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewModel(mainViewModel);

        formatUI();
    }

    private void formatUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        component =null;
        super.onDestroy();
    }

    private void inject() {
        component = getComponent();
        component.inject(this);
    }

}
