package com.gumtree.adsdemo.addetails.net;

import android.support.annotation.NonNull;

import com.gumtree.adsdemo.addetails.net.models.AdDetailsRestModel;
import com.gumtree.adsdemo.addetails.net.models.AdditionalInformation;
import com.gumtree.adsdemo.addetails.net.models.AddressDetail;
import com.gumtree.adsdemo.addetails.net.models.ContactInformation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by marios on 4/2/2017.
 */

public class MockAdDetailNetService implements AdDetailNetService {
    @Override
    public Observable<AdDetailsRestModel> getAdDetails(String adId) {
        AdDetailsRestModel restModel = createMock();
        return Observable.just(restModel).delay(2, TimeUnit.SECONDS);
    }

    private AdDetailsRestModel createMock() {
        AdDetailsRestModel result = new AdDetailsRestModel();
        result.setPrice(100);
        result.setAddressDetail(new AddressDetail("51.4589136","-0.3062386","A random place"));
        result.setContactInformation(new ContactInformation("323232323","Test","test@mail.com"));
        result.setTitle("Test ad for demo");
        result.setImageUrls(new ArrayList<String>(Arrays.asList("https://dummyimage.com/600x400/6e4a6e/ffffff&text=Image+1",
                "https://dummyimage.com/600x400/6e4a6e/ffffff&text=Image+2","https://dummyimage.com/600x400/6e4a6e/ffffff&text=Image+3")));
        result.setDatePosted("Yesterday");
        ArrayList<AdditionalInformation> additionalInformations = getAdditionalInformations();

        result.setAdditionalInformation(additionalInformations);
        return result;
    }

    @NonNull
    private ArrayList<AdditionalInformation> getAdditionalInformations() {
        ArrayList<AdditionalInformation> additionalInformations = new ArrayList<>();
        for(int i=0;i<10;i++) {
            AdditionalInformation information = new AdditionalInformation();
            information.setName("Data Name " + i);
            information.setValue("Data Value " + i);
            additionalInformations.add(information);
        }
        return additionalInformations;
    }
}
