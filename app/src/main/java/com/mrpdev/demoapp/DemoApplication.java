package com.mrpdev.demoapp;

import android.app.Application;

import com.mrpdev.demoapp.di.AppModule;
import com.mrpdev.demoapp.di.DaggerAppComponent;
import com.mrpdev.demoapp.di.DaggerDebugAppComponent;
import com.mrpdev.demoapp.di.DemoAppComponent;
import com.mrpdev.demoapp.di.MockedNetModule;
import com.mrpdev.demoapp.di.NetModule;

/**
 * Created by marios on 4/2/2017.
 */

public class DemoApplication extends Application {

    private DemoAppComponent appComponent;

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

    public DemoAppComponent getAppComponent() {
        return appComponent;
    }
}
