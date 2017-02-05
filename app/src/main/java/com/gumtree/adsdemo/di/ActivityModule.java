package com.gumtree.adsdemo.di;

import android.content.Context;

import com.gumtree.adsdemo.ui.services.CommunicationService;
import com.gumtree.adsdemo.ui.services.DialogService;
import com.gumtree.adsdemo.ui.services.NavigationService;
import com.gumtree.adsdemo.ui.services.TextProvider;

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
