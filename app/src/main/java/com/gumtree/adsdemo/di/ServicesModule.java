package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.domain.AdDetailDomainService;
import com.gumtree.adsdemo.addetails.domain.AdDetailDomainServiceDefault;
import com.gumtree.adsdemo.addetails.net.AdDetailNetService;

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
