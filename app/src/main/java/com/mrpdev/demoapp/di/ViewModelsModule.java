package com.mrpdev.demoapp.di;

import com.mrpdev.demoapp.addetails.domain.AdDetailDomainService;
import com.mrpdev.demoapp.addetails.viewmodel.AdDetailViewModel;
import com.mrpdev.demoapp.ads.viewmodel.MainViewModel;
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
public class ViewModelsModule {
    @Provides
    public AdDetailViewModel providesAdDetailViewModel(AdDetailDomainService service, CommunicationService communicationService, TextProvider textProvider, DialogService dialogService){
        return new AdDetailViewModel(service,communicationService,textProvider,dialogService) ;
    }

    @Provides
    public MainViewModel providesMainViewModel(NavigationService service){
        return new MainViewModel(service) ;
    }
}
