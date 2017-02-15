package com.mrpdev.demoapp;

/**
 */
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

public class RxImmediateSchedulerRule implements TestRule {


    private void setupSchedulers() {
        RxJavaPlugins.getInstance().reset();
        RxJavaPlugins.getInstance().registerSchedulersHook(new RxJavaSchedulersHook() {
            @Override
            public Scheduler getComputationScheduler() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }

            @Override
            public Scheduler getNewThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {

            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                setupSchedulers();

                base.evaluate();

                resetSchedulers();
            }
        };
    }

    private void resetSchedulers() {
        RxJavaPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().reset();
    }
}