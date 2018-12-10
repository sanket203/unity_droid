package unity.com.unityapp.unity.com.unityapp.base.di.modules;

import android.app.Activity;

import dagger.Module;

/**
 * Created by admin on 10/12/18.
 */

@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(final Activity activity) {
        this.activity = activity;
    }
}
