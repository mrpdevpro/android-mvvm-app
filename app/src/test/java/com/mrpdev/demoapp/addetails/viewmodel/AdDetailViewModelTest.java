package com.mrpdev.demoapp.addetails.viewmodel;

import com.mrpdev.demoapp.R;
import com.mrpdev.demoapp.RxImmediateSchedulerRule;
import com.mrpdev.demoapp.addetails.domain.AdDetailDomainService;
import com.mrpdev.demoapp.addetails.domain.AdDetailModel;
import com.mrpdev.demoapp.addetails.net.models.AdDetailsRestModel;
import com.mrpdev.demoapp.addetails.net.models.AddressDetail;
import com.mrpdev.demoapp.addetails.net.models.ContactInformation;
import com.mrpdev.demoapp.ui.services.CommunicationService;
import com.mrpdev.demoapp.ui.services.DialogService;
import com.mrpdev.demoapp.ui.services.TextProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by marios on 5/2/2017.
 */
@RunWith(MockitoJUnitRunner.class)

public class AdDetailViewModelTest {
    @Mock
    AdDetailDomainService service;

    @Mock
    CommunicationService communicationService;

    @Mock
    TextProvider textProvider;

    @Mock
    DialogService dialogService;
    @Rule
    public RxImmediateSchedulerRule rxSchedulersTestRule = new RxImmediateSchedulerRule();

    AdDetailViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        viewModel = new AdDetailViewModel(service,communicationService,textProvider,dialogService);
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

        assertTrue(viewModel.price.get().startsWith("£ 1000") );
    }
    @Test
    public void test_smsCommand_Invokes_CommunicationService() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setPrice(1000);
        detailModel.getValue().setContactInformation(new ContactInformation("123","test","test@mail.com"));
        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());
        viewModel.sendSMSCommand();

        verify(communicationService).sendSMS("123");
    }

    @Test
    public void test_phoneCallCommand_Invokes_CommunicationService() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setPrice(1000);
        detailModel.getValue().setContactInformation(new ContactInformation("123","test","test@mail.com"));
        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());
        viewModel.makePhoneCallCommand();

        verify(communicationService).call("123");
    }

    @Test
    public void test_emailCommand_Invokes_CommunicationService() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setTitle("test");
        detailModel.getValue().setPrice(1000);
        detailModel.getValue().setContactInformation(new ContactInformation("123","test","test@mail.com"));

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());
        viewModel.sendEmailCommand();

        verify(communicationService).sendEmail(eq("test@mail.com"),eq("test"),any());
    }

    @Test
    public void test_shareCommand_Invokes_CommunicationService() throws Exception {
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setTitle("test");
        detailModel.getValue().setPrice(1000);
        detailModel.getValue().setContactInformation(new ContactInformation("123","test","test@mail.com"));

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));
        when(textProvider.getString(R.string.share_subject)).thenReturn(anyString());

        viewModel.start("");
        viewModel.sharePostCommand();

        verify(communicationService).shareContent(anyString(),anyString());
    }

    @Test
    public void test_bookmarkpostCommand_Invokes_DialogService() throws Exception {
        when(textProvider.getString(R.string.bookmark_sent)).thenReturn(anyString());

        viewModel.bookMarkPostCommand();

        verify(dialogService).displaySimpleMessage(anyString());
    }
    @Test
    public void test_openMapCommand_With_Correct_Information_Invokes_Map() throws Exception {
        //when(textProvider.getString(R.string.map_location_invalid)).thenReturn(anyString());
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setTitle("test");
        detailModel.getValue().setAddressDetail(new AddressDetail("0.0","0.0","Place 1"));

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());
        viewModel.openMapCommand();

        verifyZeroInteractions(dialogService);
        verify(communicationService).openMap(anyString(),anyString());

    }
    @Test
    public void test_openMapCommand_With_Invalid_Information_Invokes_Dialog() throws Exception {
        when(textProvider.getString(R.string.map_location_invalid)).thenReturn("");
        AdDetailModel detailModel = new AdDetailModel(new AdDetailsRestModel());
        detailModel.getValue().setTitle("test");
        detailModel.getValue().setAddressDetail(new AddressDetail(null,null,"Place 1"));

        when(service.getDetail(anyString())).thenReturn(Observable.just(detailModel));

        viewModel.start(anyString());
        viewModel.openMapCommand();

        verifyZeroInteractions(communicationService);
        verify(dialogService).displaySimpleMessage(anyString());
    }
    @Test
    public void stop() throws Exception {

    }

}