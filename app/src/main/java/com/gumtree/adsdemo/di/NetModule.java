package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.net.AdDetailNetService;
import com.gumtree.adsdemo.addetails.net.RetrofitAdDetailNetService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class NetModule {
    @Provides
    public AdDetailNetService providesRealService(){
        return new RetrofitAdDetailNetService();
    }
}
