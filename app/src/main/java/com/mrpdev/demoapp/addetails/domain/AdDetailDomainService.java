package com.mrpdev.demoapp.addetails.domain;

import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public interface AdDetailDomainService {
    Observable<AdDetailModel> getDetail(String adId);
}
