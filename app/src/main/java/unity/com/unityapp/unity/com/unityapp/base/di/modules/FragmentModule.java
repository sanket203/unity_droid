package unity.com.unityapp.unity.com.unityapp.base.di.modules;

import android.support.v4.app.Fragment;

import dagger.Module;

/**
 * Created by admin on 11/12/18.
 */
@Module
public class FragmentModule {

    private final Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }
}
