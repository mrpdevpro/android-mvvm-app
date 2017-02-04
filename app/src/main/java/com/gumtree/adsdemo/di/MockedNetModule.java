package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.net.AdDetailNetService;
import com.gumtree.adsdemo.addetails.net.MockAdDetailNetService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class MockedNetModule {
    @Provides
    public AdDetailNetService providesAdDetailService(){
        return new MockAdDetailNetService();
    }
}
