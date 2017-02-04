package com.gumtree.adsdemo;

import android.app.Application;
import android.util.Log;

import com.gumtree.adsdemo.di.AppModule;
import com.gumtree.adsdemo.di.DaggerAppComponent;
import com.gumtree.adsdemo.di.DaggerDebugAppComponent;
import com.gumtree.adsdemo.di.DebugAppComponent;
import com.gumtree.adsdemo.di.GumtreeAppComponent;
import com.gumtree.adsdemo.di.MockedNetModule;
import com.gumtree.adsdemo.di.NetModule;

/**
 * Created by marios on 4/2/2017.
 */

public class GumtreeApplication extends Application {

    private GumtreeAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if(!BuildConfig.DEBUG)
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .netModule(new NetModule())
                    .build();
        else
            appComponent = DaggerDebugAppComponent.builder()
                    .appModule(new AppModule(this))
                    .mockedNetModule(new MockedNetModule())
                    .build();
    }

    public GumtreeAppComponent getAppComponent() {
        return appComponent;
    }
}
