package laptrinh.live.dagger2;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;
import laptrinh.live.dagger2.data.DataManager;
import laptrinh.live.dagger2.di.component.ApplicationComponent;

/**
 * Created by MSI on 2/5/2018.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context){
        return (DemoApplication)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
