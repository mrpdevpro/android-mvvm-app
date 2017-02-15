package com.mrpdev.demoapp.ui.services;

import android.content.Context;

/**
 * Created by mprotogeiros on 2/5/2017.
 */
public class TextProvider {
    private final Context context;

    public TextProvider(Context context){

        this.context = context;
    }
    public String getString(int resourceId){
        return context.getString(resourceId);
    }
}
