package com.gumtree.adsdemo.addetails.net;

import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;

import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public class RetrofitAdDetailNetService implements AdDetailNetService {
    @Override
    public Observable<AdDetailsRestModel> getAdDetails(String adId) {
        return null;
    }
}