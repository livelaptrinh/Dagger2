package laptrinh.live.dagger2;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import laptrinh.live.dagger2.data.DataManager;
import laptrinh.live.dagger2.di.component.ApplicationComponent;
import laptrinh.live.dagger2.di.component.DaggerApplicationComponent;
import laptrinh.live.dagger2.di.module.ApplicationModule;

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

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
