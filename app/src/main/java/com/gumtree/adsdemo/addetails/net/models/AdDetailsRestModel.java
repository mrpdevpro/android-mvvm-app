package com.gumtree.adsdemo.addetails.net.models;

import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by marios on 4/2/2017.
 */
public class AdDetailsRestModel {
    private  String title;
    private  ArrayList<String> imageUrls;
    private  Double price;
    private ContactInformation contactInformation;
    private  AddressDetail addressDetail;
    private ArrayList<AdditionalInformation> additionalInformation;
    private String datePosted;
    public String getTitle() {
        return title;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public double getPrice() {
        return price;
    }

    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setAdditionalInformation(ArrayList<AdditionalInformation> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public ArrayList<AdditionalInformation> getAdditionalInformation() {
        if(additionalInformation == null)
            setAdditionalInformation(new ArrayList<AdditionalInformation>());

        return additionalInformation;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }
}
