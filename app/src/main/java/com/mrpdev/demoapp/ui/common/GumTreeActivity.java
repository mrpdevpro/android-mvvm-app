package com.mrpdev.demoapp.ui.common;

import android.support.v7.app.AppCompatActivity;

import com.mrpdev.demoapp.DemoApplication;
import com.mrpdev.demoapp.di.ActivityComponent;
import com.mrpdev.demoapp.di.ActivityModule;

/**
 * Created by marios on 4/2/2017.
 */

public class GumTreeActivity extends AppCompatActivity {
    protected ActivityComponent component;

    protected ActivityComponent getComponent() {
        return ((DemoApplication)getApplication()).getAppComponent().getActivitySubComponent(new ActivityModule(this));
    }
}
