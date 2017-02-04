package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.domain.AdDetailDomainService;
import com.gumtree.adsdemo.addetails.viewmodel.AdDetailViewModel;
import com.gumtree.adsdemo.ads.viewmodel.MainViewModel;
import com.gumtree.adsdemo.ui.services.NavigationService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class ViewModelsModule {
    @Provides
    public AdDetailViewModel providesAdDetailViewModel(AdDetailDomainService service){
        return new AdDetailViewModel(service) ;
    }

    @Provides
    public MainViewModel providesMainViewModel(NavigationService service){
        return new MainViewModel(service) ;
    }
}
