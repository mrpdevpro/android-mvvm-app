package com.gumtree.adsdemo.addetails;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.gumtree.adsdemo.R;
import com.gumtree.adsdemo.addetails.viewmodel.AdDetailViewModel;
import com.gumtree.adsdemo.databinding.ActivityAdDetailsBinding;
import com.gumtree.adsdemo.ui.common.GumTreeActivity;

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

        ((RecyclerView)binding.getRoot().findViewById(R.id.listProperties)).setLayoutManager(new LinearLayoutManager(this));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        viewModel.start(getIntent().getStringExtra("adId"));
        super.onStart();
    }

    @Override
    protected void onStop() {
        viewModel.stop();
        super.onStop();
    }
}
