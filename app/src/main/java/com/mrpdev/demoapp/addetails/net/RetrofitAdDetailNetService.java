package com.mrpdev.demoapp.addetails.net;

import com.mrpdev.demoapp.addetails.net.endpoint.DetailsApiEndPoint;
import com.mrpdev.demoapp.addetails.net.models.AdDetailsRestModel;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public class RetrofitAdDetailNetService implements AdDetailNetService {

    private final Retrofit retrofit;

    public RetrofitAdDetailNetService(Retrofit retrofit) {

        this.retrofit = retrofit;
    }

    @Override
    public Observable<AdDetailsRestModel> getAdDetails(String adId) {
        DetailsApiEndPoint service = retrofit.create(DetailsApiEndPoint.class);
        return service.getDetails(adId);
    }
}
