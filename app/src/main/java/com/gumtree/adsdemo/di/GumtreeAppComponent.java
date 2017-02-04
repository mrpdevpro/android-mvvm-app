package com.gumtree.adsdemo.di;

/**
 * Created by marios on 4/2/2017.
 */
public interface GumtreeAppComponent {
    ActivityComponent getActivitySubComponent(ActivityModule activityModule);
}
