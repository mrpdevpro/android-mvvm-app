package com.mrpdev.demoapp.addetails.domain;

import com.mrpdev.demoapp.addetails.net.models.AdDetailsRestModel;
import com.mrpdev.demoapp.addetails.net.models.AddressDetail;
import com.mrpdev.demoapp.addetails.net.models.ContactInformation;

import java.util.ArrayList;

/**
 * Here won't change anything from the Rest Model.
 * But in real life transformations would be certain to apply,
 * and would provide an immune to REST Api changes model
 */

public class AdDetailModel   {
    private final AdDetailsRestModel model;

    public AdDetailModel(AdDetailsRestModel model){
        this.model = model;
        transform(model);

    }

    private void transform(AdDetailsRestModel model) {
        //some validations
        if(this.model.getContactInformation() == null)
            model.setContactInformation(new ContactInformation("","",""));
        if(this.model.getAdditionalInformation() == null)
            model.setAdditionalInformation(new ArrayList<>());
        if(model.getAddressDetail() == null)
            model.setAddressDetail(new AddressDetail("","",""));
    }

    public AdDetailsRestModel getValue() {
        return model;
    }
}
