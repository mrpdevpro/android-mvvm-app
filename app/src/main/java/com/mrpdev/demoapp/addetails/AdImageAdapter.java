package com.mrpdev.demoapp.addetails;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mrpdev.demoapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mprotogeiros on 2/5/2017.
 */

public class AdImageAdapter extends PagerAdapter {
    private final ArrayList<String> imageList;

    public AdImageAdapter(ArrayList<String> imageList){

        this.imageList = imageList;
    }
    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
         View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.ad_image_item,container,false);
        ImageView imageView = (ImageView)rootView.findViewById(R.id.image_display);
        Picasso.with(container.getContext()).
                load(imageList.get(position)).
                error(R.drawable.ic_launcher).
                into(imageView);
        container.addView(rootView,0);
        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
