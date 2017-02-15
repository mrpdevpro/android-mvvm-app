package com.mrpdev.demoapp.di;

import com.mrpdev.demoapp.addetails.domain.AdDetailDomainService;
import com.mrpdev.demoapp.addetails.domain.AdDetailDomainServiceDefault;
import com.mrpdev.demoapp.addetails.net.AdDetailNetService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class ServicesModule {
    @Provides
    public AdDetailDomainService providesAdDetailDomainService(AdDetailNetService netService){
        return  new AdDetailDomainServiceDefault(netService);
    }
}
