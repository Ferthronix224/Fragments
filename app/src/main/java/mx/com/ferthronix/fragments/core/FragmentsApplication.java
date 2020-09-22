package mx.com.ferthronix.fragments.core;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class FragmentsApplication extends Application {

    public static  FragmentsApplication instance;
    private static Context appContext;

    public static FragmentsApplication getInstance(){return instance;}

    public static Context getAppContext(){return appContext;}

    public static void setAppContext(Context context){appContext = context;}

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
