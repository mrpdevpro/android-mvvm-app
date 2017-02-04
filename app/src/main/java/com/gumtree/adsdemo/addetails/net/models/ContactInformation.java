package com.gumtree.adsdemo.addetails.net.models;

/**
 * Created by marios on 4/2/2017.
 */
public class ContactInformation {
    private final String telephone;
    private final String name;

    public ContactInformation(String telephone, String name) {
        this.telephone = telephone;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }
}
