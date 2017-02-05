package com.gumtree.adsdemo.addetails.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import com.gumtree.adsdemo.R;
import com.gumtree.adsdemo.addetails.domain.AdDetailDomainService;
import com.gumtree.adsdemo.addetails.domain.AdDetailModel;
import com.gumtree.adsdemo.addetails.net.models.AdditionalInformation;
import com.gumtree.adsdemo.addetails.net.models.AddressDetail;
import com.gumtree.adsdemo.ui.services.CommunicationService;
import com.gumtree.adsdemo.ui.services.DialogService;
import com.gumtree.adsdemo.ui.services.TextProvider;

import java.util.ArrayList;

import rx.Subscription;

/**
 * Created by marios on 4/2/2017.
 */

public class AdDetailViewModel extends BaseObservable {
    private AdDetailDomainService adDetailNetService;
    private final CommunicationService communicationService;
    private final TextProvider textProvider;
    private final DialogService dialogService;
    private Subscription subscription;

    public AdDetailViewModel(AdDetailDomainService adDetailNetService,
                             CommunicationService communicationService,
                             TextProvider textProvider,
                             DialogService dialogService) {
        this.adDetailNetService = adDetailNetService;
        this.communicationService = communicationService;
        this.textProvider = textProvider;
        this.dialogService = dialogService;
    }

    public ObservableField<String> contactName = new ObservableField<>();

    public ObservableField<String> contactTel = new ObservableField<>();

    public ObservableField<String> contactEmail = new ObservableField<>();

    public ObservableField<String> title = new ObservableField<>();

    public ObservableField<String> datePosted = new ObservableField<>();

    public ObservableField<AddressDetail> addressDetail = new ObservableField<>();

    public ObservableField<ArrayList<String>> imageUrls = new ObservableField<>();

    public ObservableField<String> price = new ObservableField<>();

    public ObservableField<Boolean> loading = new ObservableField<>(false);

    public ObservableArrayList<AdditionalInformation> additionalInformationList = new ObservableArrayList<>();

    public void start(String adId) {
        loading.set(true);
        subscription = adDetailNetService.getDetail(adId)
                .subscribe(this::bindModel,this::onError,this::finishedLoading);
    }

    private void finishedLoading() {
        loading.set(false);
    }

    private void onError(Throwable throwable) {
        Log.e("ad details",throwable.getLocalizedMessage());
        loading.set(false);
    }

    void bindModel(AdDetailModel model) {

        title.set(model.getValue().getTitle());
        datePosted.set(model.getValue().getDatePosted());
        contactName.set(model.getValue().getContactInformation().getName());
        contactTel.set(model.getValue().getContactInformation().getTelephone());
        contactEmail.set(model.getValue().getContactInformation().getEmail());
        addressDetail.set(model.getValue().getAddressDetail());
        imageUrls.set(model.getValue().getImageUrls());
        price.set(String.format("£ %5.2f", model.getValue().getPrice()));
        additionalInformationList.addAll( model.getValue().getAdditionalInformation());


    }

    public void stop() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    public void sendSMSCommand(){
        communicationService.sendSMS( contactTel.get());
    }

    public void sendEmailCommand(){
        communicationService.sendEmail(contactEmail.get(),title.get(),textProvider.getString(R.string.email_template));
    }

    public void makePhoneCallCommand(){
        communicationService.call(contactTel.get());
    }

    public void sharePostCommand() {
        communicationService.shareContent(title.get(),textProvider.getString(R.string.share_subject));
    }

    public void bookMarkPostCommand() {
        //just notifying the user with a simple toast
        dialogService.displaySimpleMessage(textProvider.getString(R.string.bookmark_sent));
    }

    public void openMapCommand(){
        if(addressDetail.get().getGeoLng() == null || addressDetail.get().getGeoLat() == null){
            dialogService.displaySimpleMessage(textProvider.getString(R.string.map_location_invalid));
        }else {
            communicationService.openMap(addressDetail.get().getGeoLat(), addressDetail.get().getGeoLng());
        }
    }
}
