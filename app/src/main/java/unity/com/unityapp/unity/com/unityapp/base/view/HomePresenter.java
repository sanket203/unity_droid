package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.RecentProfilesUseCase;

/**
 * Created by admin on 10/12/18.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private final RecentProfilesUseCase useCase;

    @Inject
    public HomePresenter(RecentProfilesUseCase useCase) {
        this.useCase = useCase;
    }

    void getData(int model) {
        useCase.execute("").compose(bindToLifecycle()).subscribe(responseDataModel -> {
            if (view != null) {
                view.sowData();
            }
        });
    }
}
