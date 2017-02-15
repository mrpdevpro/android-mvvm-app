package com.mrpdev.demoapp.di;

/**
 * Created by marios on 4/2/2017.
 */
public interface DemoAppComponent {
    ActivityComponent getActivitySubComponent(ActivityModule activityModule);
}
