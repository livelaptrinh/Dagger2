package laptrinh.live.dagger2.di.component;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import laptrinh.live.dagger2.DemoApplication;
import laptrinh.live.dagger2.data.DataManager;
import laptrinh.live.dagger2.data.DbHelper;
import laptrinh.live.dagger2.di.ApplicationContext;
import laptrinh.live.dagger2.di.module.ApplicationModule;

/**
 * Created by MSI on 2/5/2018.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPreferences getSharedPreferencesHelper();

    DbHelper getDeHelper();
}
