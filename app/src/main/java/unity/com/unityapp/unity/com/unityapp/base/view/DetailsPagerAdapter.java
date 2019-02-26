package unity.com.unityapp.unity.com.unityapp.base.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DetailsPagerAdapter extends FragmentPagerAdapter {

    private String candidateId;

    public DetailsPagerAdapter(FragmentManager fm, String candidateId) {
        super(fm);
        this.candidateId = candidateId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return PersonalDetailsPagerFragment.newInstance("FirstFragment, Instance 1");
            case 1:
                return PhysicalDetailsPagerFragment.newInstance("SecondFragment, Instance 1");
            case 2:
                return EducationalDetailsPagerFragment.newInstance("ThirdFragment, Instance 1");
            case 3:
                return ServiceDetailsPagerFragment.newInstance("ThirdFragment, Instance 2");
            case 4:
                return DietDetailsPagerFragment.newInstance("ThirdFragment, Instance 3");
            case 5:
                return FamilyDetailsPagerFragment.newInstance("ThirdFragment, Instance 3");

            case 6:
                return HoroscopeDetailsPagerFragment.newInstance("ThirdFragment, Instance 3");
            case 7:
                return ExpectationsDetailsPagerFragment.newInstance("ThirdFragment, Instance 3");

            case 8:
                return AddressDetailsPagerFragment.newInstance("ThirdFragment, Instance 3");
            default:
                return PersonalDetailsPagerFragment.newInstance("ThirdFragment, Default");
        }
    }

    @Override
    public int getCount() {
        return 9;
    }
}
