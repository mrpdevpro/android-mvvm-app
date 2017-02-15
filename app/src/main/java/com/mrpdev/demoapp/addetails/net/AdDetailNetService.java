package com.mrpdev.demoapp.addetails.net;

import com.mrpdev.demoapp.addetails.net.models.AdDetailsRestModel;

import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public interface AdDetailNetService {
    Observable<AdDetailsRestModel> getAdDetails(String adId);
}
