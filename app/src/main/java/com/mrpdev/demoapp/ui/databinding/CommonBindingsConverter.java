package com.mrpdev.demoapp.ui.databinding;

import android.databinding.BindingConversion;
import android.view.View;


public class CommonBindingsConverter {
    @BindingConversion
    public static int toVisibility(boolean isVisible){
        return isVisible? View.VISIBLE:View.GONE;
    }
}
