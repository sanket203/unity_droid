package unity.com.unityapp.unity.com.unityapp.base.di;

import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.components.ActivityComponent;

import unity.com.unityapp.unity.com.unityapp.base.di.components.ApplicationComponent;
import unity.com.unityapp.unity.com.unityapp.base.di.components.DaggerApplicationComponent;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ActivityModule;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ApplicationModule;

/**
 * Created by admin on 10/12/18.
 */

public class AppDi {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent(BaseActivity activity) {
        if (applicationComponent == null) {
            applicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(activity.getApplication()))
                    .build();
        }
        return applicationComponent;
    }

    public static ActivityComponent getActivityComponent(BaseActivity activity) {
        return getApplicationComponent(activity).plus(new ActivityModule(activity));
    }
}
