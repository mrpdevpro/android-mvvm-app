package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.AdDetailsActivity;
import com.gumtree.adsdemo.ads.MainActivity;

import dagger.Subcomponent;

/**
 * The subcomponent used by Activities of the app.
 * Has access to the current Context
 */
@ActivityScope
@Subcomponent(modules = {ActivityModule.class, ViewModelsModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject (AdDetailsActivity adDetailsActivity);
}

