package laptrinh.live.dagger2.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import dagger.Module;
import dagger.Provides;
import laptrinh.live.dagger2.di.ApplicationContext;
import laptrinh.live.dagger2.di.DatabaseInfo;

/**
 * Created by MSI on 2/5/2018.
 */

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext(){
        return mApplication;
    }

    @Provides
    Application provideApplication () { return mApplication;}

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {return "demo-dagger.db";}

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {return 2;}

    @Provides
    SharedPreferences provideSharedPrefs(){
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
