package com.gumtree.adsdemo.addetails.domain;

import com.gumtree.adsdemo.addetails.net.AdDetailNetService;
import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;

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
