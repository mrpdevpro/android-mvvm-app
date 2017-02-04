package com.gumtree.adsdemo.addetails.net.models;

/**
 * Created by marios on 4/2/2017.
 */

public class AddressDetail {
    private final String geoLat;
    private final String geoLng;
    private final String shortname;

    public AddressDetail(String geoLat, String geoLng, String shortname) {
        this.geoLat = geoLat;
        this.geoLng = geoLng;
        this.shortname = shortname;
    }

    public String getShortname() {
        return shortname;
    }

    public String getGeoLng() {
        return geoLng;
    }

    public String getGeoLat() {
        return geoLat;
    }
}
