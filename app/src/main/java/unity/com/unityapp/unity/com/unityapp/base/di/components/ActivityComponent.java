package unity.com.unityapp.unity.com.unityapp.base.di.components;

/**
 * Created by admin on 10/12/18.
 */

import dagger.Subcomponent;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.ActivityModule;
import unity.com.unityapp.unity.com.unityapp.base.view.EditContactDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditDietDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditEducationDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditExpectationDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditFamilyDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditHoroscopeDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditPersonalDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditPhysicalDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.EditServiceDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.HomeActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.LoginActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.RecentProfileDetailsActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.RegistrationActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.RegistrationDoneActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.SplashScreenActivity;
import unity.com.unityapp.unity.com.unityapp.base.view.WelcomeActivity;

@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(HomeActivity activity);

    void inject(RecentProfileDetailsActivity activity);

    void inject(SplashScreenActivity activity);

    void inject(LoginActivity activity);

    void inject(RegistrationActivity activity);

    void inject(EditPersonalDetailsActivity activity);

    void inject(EditPhysicalDetailsActivity activity);

    void inject(EditDietDetailsActivity activity);

    void inject(EditFamilyDetailsActivity activity);

    void inject(EditExpectationDetailsActivity activity);

    void inject(EditEducationDetailsActivity activity);

    void inject(EditHoroscopeDetailsActivity activity);

    void inject(EditServiceDetailsActivity activity);

    void inject(EditContactDetailsActivity activity);

    void inject(WelcomeActivity activity);

    void inject(RegistrationDoneActivity activity);
}
