package com.gumtree.adsdemo.addetails.viewmodel;

import com.gumtree.adsdemo.RxImmediateSchedulerRule;
import com.gumtree.adsdemo.addetails.domain.AdDetailDomainService;
import com.gumtree.adsdemo.addetails.domain.AdDetailModel;
import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by marios on 5/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)

public class AdDetailViewModelTest {
    @Mock
    AdDetailDomainService service;
    @Rule
    public RxImmediateSchedulerRule rxSchedulersTestRule = new RxImmediateSchedulerRule();

    AdDetailViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new AdDetailViewModel(service);
    }

    @Test
    public void test_start_When_Return_Model_Loading_Stops() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setPrice(1000);

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());

        assertTrue(!viewModel.loading.get());
    }

    @Test
    public void test_start_When_Return_Model_With_Error_Loading_Stops() throws Exception {
        when(service.getDetail(anyString())).thenReturn(Observable.error(new Exception()));

        viewModel.start(anyString());

        assertTrue(!viewModel.loading.get());
    }
    @Test
    public void test_start_When_Return_Model_Populates_FormatedPrice() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setPrice(1000);

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());

        assertTrue(viewModel.price.get().equals("£ 1000,00"));
    }

    @Test
    public void stop() throws Exception {

    }

}