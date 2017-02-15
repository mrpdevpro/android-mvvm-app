package com.mrpdev.demoapp.addetails.domain;

import com.mrpdev.demoapp.addetails.net.AdDetailNetService;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by marios on 4/2/2017.
 */

public class AdDetailDomainServiceDefault implements AdDetailDomainService {
    private AdDetailNetService adDetailNetService;

    public AdDetailDomainServiceDefault(AdDetailNetService adDetailNetService){

        this.adDetailNetService = adDetailNetService;
    }
    @Override
    public Observable<AdDetailModel> getDetail(String adId) {
        return adDetailNetService.getAdDetails(adId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError(Throwable::printStackTrace)
                .map(adDetailsRestModel -> new AdDetailModel(adDetailsRestModel));
    }
}
