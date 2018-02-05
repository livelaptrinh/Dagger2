package laptrinh.live.dagger2.di.module;

import android.app.Activity;
import android.content.Context;


import dagger.Module;
import dagger.Provides;
import laptrinh.live.dagger2.di.ActivityContext;

/**
 * Created by MSI on 2/5/2018.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity(){
        return mActivity;
    }
}
