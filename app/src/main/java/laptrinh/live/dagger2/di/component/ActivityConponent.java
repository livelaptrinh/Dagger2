package laptrinh.live.dagger2.di.component;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import laptrinh.live.dagger2.MainActivity;
import laptrinh.live.dagger2.di.PerActivity;
import laptrinh.live.dagger2.di.module.ActivityModule;

/**
 * Created by MSI on 2/5/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityConponent {
    void inject(MainActivity mainActivity);
}
