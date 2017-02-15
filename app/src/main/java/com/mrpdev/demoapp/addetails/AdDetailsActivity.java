package com.mrpdev.demoapp.addetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mrpdev.demoapp.R;
import com.mrpdev.demoapp.addetails.viewmodel.AdDetailViewModel;
import com.mrpdev.demoapp.databinding.ActivityAdDetailsBinding;
import com.mrpdev.demoapp.ui.common.GumTreeActivity;

import javax.inject.Inject;

public class AdDetailsActivity extends GumTreeActivity {

    @Inject
    AdDetailViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);

        component = getComponent();
        component.inject(this);


        ActivityAdDetailsBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_ad_details);
        binding.setViewModel(viewModel);

        formatUI(binding);


    }

    private void formatUI(ActivityAdDetailsBinding binding) {
        ((RecyclerView)binding.getRoot().findViewById(R.id.listProperties)).setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ad_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            viewModel.sharePostCommand();
            return true;
        }

        if (id == R.id.action_bookmark) {
            viewModel.bookMarkPostCommand();
            return true;
        }
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.start(getIntent().getStringExtra("adId"));
    }

    @Override
    protected void onStop() {
        viewModel.stop();
        super.onStop();
    }
}
