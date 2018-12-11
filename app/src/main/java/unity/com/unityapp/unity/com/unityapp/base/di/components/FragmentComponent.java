package unity.com.unityapp.unity.com.unityapp.base.di.components;

import dagger.Subcomponent;
import unity.com.unityapp.unity.com.unityapp.base.di.modules.FragmentModule;
import unity.com.unityapp.unity.com.unityapp.base.view.AddressTakenFragment;
import unity.com.unityapp.unity.com.unityapp.base.view.RecentProfileFragment;

/**
 * Created by admin on 11/12/18.
 */

@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(RecentProfileFragment recentProfileFragment);

    void inject(AddressTakenFragment addressTakenFragment);
}
