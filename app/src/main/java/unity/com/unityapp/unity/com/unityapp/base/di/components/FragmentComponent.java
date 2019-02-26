package unity.com.unityapp.unity.com.unityapp.base.di.components;

import dagger.Subcomponent;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.FragmentModule;
import unity.com.unityapp.unity.com.unityapp.base.view.AddressDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.AddressTakenFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.DietDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.EducationalDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.ExpectationsDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.FamilyDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.HoroscopeDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.PersonalDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.MyProfileFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.PhysicalDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.PhysicalDetailsPagerPresenter;
import unity.com.unityapp.unity.com.unityapp.base.view.RecentProfileFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.ServiceDetailsPagerFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.SettingsFragment;

/**
 * Created by admin on 11/12/18.
 */

@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(RecentProfileFragment fragment);

    void inject(AddressTakenFragment fragment);

    void inject(SettingsFragment fragment);

    void inject(MyProfileFragment fragment);

    void inject(PersonalDetailsPagerFragment fragment);

    void inject(PhysicalDetailsPagerFragment fragment);

    void inject(EducationalDetailsPagerFragment fragment);

    void inject(DietDetailsPagerFragment fragment);

    void inject(ServiceDetailsPagerFragment fragment);

    void inject(FamilyDetailsPagerFragment fragment);

    void inject(HoroscopeDetailsPagerFragment fragment);

    void inject(ExpectationsDetailsPagerFragment fragment);

    void inject(AddressDetailsPagerFragment fragment);
}
