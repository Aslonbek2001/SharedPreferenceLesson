package com.aslon.sharedpreferencelesson;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreference {
    private SharedPreferences shp = null;
    private static MyPreference myPref;

    private MyPreference(Context context) {
        if (myPref == null){
            shp = context.getSharedPreferences("setting", Context.MODE_PRIVATE);
        }
    }

    public static void init(Context context){
        myPref = new MyPreference(context);
    }

    public static MyPreference getShp(){
        return myPref;
    }

    public void changeSoundState(boolean isEnable){
        shp.edit().putBoolean("buttonSound",isEnable).apply();
    }

    public Boolean getSoundState(){
        return shp.getBoolean("buttonSound",true);
    }
}
