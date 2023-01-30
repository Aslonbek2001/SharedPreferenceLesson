package com.aslon.sharedpreferencelesson;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyPreference.init(this);
    }
}
