package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.util.List;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseViewModel {

    List<ProfileResponseViewModel> profileResponseViewModelList;

    public List<ProfileResponseViewModel> getProfileResponseViewModelList() {
        return profileResponseViewModelList;
    }

    public void setProfileResponseViewModelList(List<ProfileResponseViewModel> profileResponseViewModelList) {
        this.profileResponseViewModelList = profileResponseViewModelList;
    }
}
