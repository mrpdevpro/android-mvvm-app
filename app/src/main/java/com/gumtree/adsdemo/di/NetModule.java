package com.gumtree.adsdemo.di;

import com.gumtree.adsdemo.addetails.net.AdDetailNetService;
import com.gumtree.adsdemo.addetails.net.RetrofitAdDetailNetService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marios on 4/2/2017.
 */
@Module
public class NetModule {
    @Provides
    @Singleton
    public Retrofit providesRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.ebayclassifiedsgroup.com/schema/reply/v1/")
                .build();
        return retrofit;
    }
    @Provides
    public AdDetailNetService providesRealService(Retrofit retrofit){
        return new RetrofitAdDetailNetService(retrofit);
    }
}
