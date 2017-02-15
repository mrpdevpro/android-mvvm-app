package com.mrpdev.demoapp.di;

import android.content.Context;

import com.mrpdev.demoapp.ui.services.CommunicationService;
import com.mrpdev.demoapp.ui.services.DialogService;
import com.mrpdev.demoapp.ui.services.NavigationService;
import com.mrpdev.demoapp.ui.services.TextProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class ActivityModule {
    private final Context context;

    public ActivityModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    NavigationService providesNavigationService(){
        return new NavigationService(context);
    }

    @Provides
    @ActivityScope
    TextProvider providesTextProvider(){
        return new TextProvider(context);
    }

    @Provides
    @ActivityScope
    CommunicationService providesCommunicationService(){
        return new CommunicationService(context);
    }

    @Provides
    @ActivityScope
    DialogService providesDialogService(){
        return new DialogService(context);
    }

}
