package com.gumtree.adsdemo.addetails.domain;

import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;

import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public interface AdDetailDomainService {
    Observable<AdDetailModel> getDetail(String adId);
}
