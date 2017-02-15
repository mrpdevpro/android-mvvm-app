package com.mrpdev.demoapp.addetails.net.models;

/**
 * Created by marios on 4/2/2017.
 */
public class ContactInformation {
    private final String telephone;
    private final String name;
    private final String email;

    public ContactInformation(String telephone, String name,String email) {
        this.telephone = telephone;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
