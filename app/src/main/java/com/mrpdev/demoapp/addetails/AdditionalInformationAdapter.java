package com.mrpdev.demoapp.addetails;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrpdev.demoapp.R;
import com.mrpdev.demoapp.addetails.net.models.AdditionalInformation;
import com.mrpdev.demoapp.databinding.AdDetailPropertyBinding;

/**
 * Created by marios on 5/2/2017.
 */
public class AdditionalInformationAdapter extends RecyclerView.Adapter <AdditionalInformationAdapter.AdditionalInformationHolder>{
    private ObservableArrayList<AdditionalInformation> properties;

    public AdditionalInformationAdapter(ObservableArrayList<AdditionalInformation> properties) {
        this.properties = properties;
    }

    @Override
    public AdditionalInformationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.ad_detail_property, parent, false);
        return new AdditionalInformationHolder(view);
    }

    @Override
    public void onBindViewHolder(AdditionalInformationHolder holder, int position) {
        holder.binding.setModel(properties.get(position));
        holder.binding.executePendingBindings();
    }



    @Override
    public int getItemCount() {
        return properties.size();
    }

    public static class AdditionalInformationHolder extends RecyclerView.ViewHolder {
        private AdDetailPropertyBinding binding;
        public AdditionalInformationHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
