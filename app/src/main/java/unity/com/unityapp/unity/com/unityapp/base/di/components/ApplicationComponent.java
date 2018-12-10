package unity.com.unityapp.unity.com.unityapp.base.di.components;

import javax.inject.Singleton;

import dagger.Component;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ActivityModule;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ApplicationModule;

/**
 * Created by admin on 10/12/18.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    ActivityComponent plus(ActivityModule activityModule);

}