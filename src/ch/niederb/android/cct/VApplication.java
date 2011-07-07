package ch.niederb.android.cct;

import android.app.Application;
import android.content.Context;

public class VApplication extends Application {

    private static Context context;

    public void onCreate(){
    	VApplication.context = getApplicationContext();
    	Speaker.init(context);
    }

    public static Context getAppContext() {
    	return context;
    }
}