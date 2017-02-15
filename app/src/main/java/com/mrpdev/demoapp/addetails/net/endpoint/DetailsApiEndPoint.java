package com.mrpdev.demoapp.addetails.net.endpoint;

import com.mrpdev.demoapp.addetails.net.models.AdDetailsRestModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by mprotogeiros on 2/5/2017.
 */


public interface DetailsApiEndPoint {
    @GET("ads/{id}")
    Observable<AdDetailsRestModel> getDetails(@Path("id") String adId);
}
