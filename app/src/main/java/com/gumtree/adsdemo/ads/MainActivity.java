package com.gumtree.adsdemo.ads;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.gumtree.adsdemo.GumtreeApplication;
import com.gumtree.adsdemo.R;
import com.gumtree.adsdemo.ads.viewmodel.MainViewModel;
import com.gumtree.adsdemo.di.ActivityComponent;
import com.gumtree.adsdemo.di.ActivityModule;
import com.gumtree.adsdemo.di.AppComponent;
import com.gumtree.adsdemo.di.GumtreeAppComponent;
import com.gumtree.adsdemo.ui.common.GumTreeActivity;

import javax.inject.Inject;

public class MainActivity extends GumTreeActivity {

    @Inject
    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inject();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mainViewModel.gotoDetailsCommand("1234343");
            }
        });
    }

    @Override
    protected void onDestroy() {
        component =null;
        super.onDestroy();
    }

    private void inject() {
        component = getComponent();
        component.inject(this);
    }

}
