package com.gumtree.adsdemo.ui.services;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;

import com.gumtree.adsdemo.R;

/**
 * Created by mprotogeiros on 2/5/2017.
 */
public class CommunicationService {
    private final Context context;

    public CommunicationService(Context context) {
        this.context = context;
    }

    public void call(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+Uri.encode(phoneNumber)));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callIntent);
    }

    public void sendSMS(String phoneNumber) {
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", context.getString(R.string.sms));
        context.startActivity(it);
    }

    public void sendEmail(String email, String subject, String text) {
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        String[] recipients = new String[]{email};
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, recipients);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
        emailIntent.setType("text/plain");
        context.startActivity(Intent.createChooser(emailIntent, context.getString(R.string.email)));
    }

    public void shareContent(String body, String subject) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, body);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, subject);
        context.startActivity(Intent.createChooser(sharingIntent, context.getString(R.string.share)));
    }

    public void openMap(String geoLat, String geoLng) {
        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(String.format("geo:%s,%s",geoLat,geoLng)));
        i.setClassName("com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity");
        context.startActivity(i);
    }
}
