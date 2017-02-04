package com.gumtree.adsdemo.ui.common;

import android.support.v7.app.AppCompatActivity;

import com.gumtree.adsdemo.GumtreeApplication;
import com.gumtree.adsdemo.di.ActivityComponent;
import com.gumtree.adsdemo.di.ActivityModule;

/**
 * Created by marios on 4/2/2017.
 */

public class GumTreeActivity extends AppCompatActivity {
    protected ActivityComponent component;

    protected ActivityComponent getComponent() {
        return ((GumtreeApplication)getApplication()).getAppComponent().getActivitySubComponent(new ActivityModule(this));
    }
}
