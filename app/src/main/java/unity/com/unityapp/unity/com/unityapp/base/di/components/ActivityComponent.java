package unity.com.unityapp.unity.com.unityapp.base.di.components;

/**
 * Created by admin on 10/12/18.
 */

import dagger.Subcomponent;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ActivityModule;
import unity.com.unityapp.unity.com.unityapp.base.view.EditPersonalDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.HomeActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.LoginActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.RecentProfileDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.RegistrationActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.SplashScreenActivity;

@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(RecentProfileDetailsActivity activity);

    void inject(SplashScreenActivity activity);

    void inject(LoginActivity activity);

    void inject(RegistrationActivity activity);

    void inject(EditPersonalDetailsActivity activity);
}
