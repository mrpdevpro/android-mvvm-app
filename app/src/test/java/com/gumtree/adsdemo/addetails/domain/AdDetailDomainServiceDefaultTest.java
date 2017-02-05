package com.gumtree.adsdemo.addetails.domain;

import com.gumtree.adsdemo.RxImmediateSchedulerRule;
import com.gumtree.adsdemo.addetails.net.AdDetailNetService;
import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by marios on 5/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class AdDetailDomainServiceDefaultTest {
    AdDetailDomainService service;

    @Rule
    public RxImmediateSchedulerRule rxSchedulersTestRule = new RxImmediateSchedulerRule();

    @Mock
    private AdDetailNetService netService;

    @Before
    public void setUp() throws Exception{
        service = new AdDetailDomainServiceDefault(netService);
    }
    @Test
    public void test_getDetail_Completes() throws Exception {
        AdDetailsRestModel restModel = new AdDetailsRestModel();
        restModel.setTitle("test");
        when(netService.getAdDetails(anyString())).thenReturn(Observable.just(restModel));
        TestSubscriber testSubscriber = new TestSubscriber();

        service.getDetail(anyString()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(testSubscriber);

        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();

        List<AdDetailModel> mode = testSubscriber.getOnNextEvents();
        assertTrue(mode.get(0).getValue().getTitle().equals("test"));
    }

    @Test
    public void test_getDetail_NetError() throws Exception {

        Exception e = new Exception("error.net");
        when(netService.getAdDetails(anyString())).thenReturn(Observable.error(e));
        TestSubscriber testSubscriber = new TestSubscriber();

        service.getDetail(anyString()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(testSubscriber);

        testSubscriber.assertNotCompleted();
        testSubscriber.assertError(e);

    }

}