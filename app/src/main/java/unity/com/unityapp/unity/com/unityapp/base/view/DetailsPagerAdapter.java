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
                return PersonalDetailsPagerFragment.newInstance(candidateId);
            case 1:
                return PhysicalDetailsPagerFragment.newInstance(candidateId);
            case 2:
                return EducationalDetailsPagerFragment.newInstance(candidateId);
            case 3:
                return ServiceDetailsPagerFragment.newInstance(candidateId);
            case 4:
                return DietDetailsPagerFragment.newInstance(candidateId);
            case 5:
                return FamilyDetailsPagerFragment.newInstance(candidateId);

            case 6:
                return HoroscopeDetailsPagerFragment.newInstance(candidateId);
            case 7:
                return ExpectationsDetailsPagerFragment.newInstance(candidateId);

            case 8:
                return AddressDetailsPagerFragment.newInstance(candidateId);
            default:
                return PersonalDetailsPagerFragment.newInstance(candidateId);
        }
    }

    @Override
    public int getCount() {
        return 9;
    }
}
