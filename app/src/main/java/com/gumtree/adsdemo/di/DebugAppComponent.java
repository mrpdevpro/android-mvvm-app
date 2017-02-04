package com.gumtree.adsdemo.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by marios on 4/2/2017.
 */


@Singleton
@Component(modules={AppModule.class, MockedNetModule.class,ServicesModule.class})
public interface DebugAppComponent extends GumtreeAppComponent {
}