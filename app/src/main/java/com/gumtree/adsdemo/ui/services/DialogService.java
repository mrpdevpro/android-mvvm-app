package com.gumtree.adsdemo.ui.services;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by mprotogeiros on 2/5/2017.
 */

public class DialogService {
    private final Context context;

    public DialogService(Context context){

        this.context = context;
    }
    public void displaySimpleMessage(String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}
