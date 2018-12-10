package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.HomeUseCase;

/**
 * Created by admin on 10/12/18.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private final HomeUseCase useCase;

    @Inject
    public HomePresenter(HomeUseCase useCase) {
        this.useCase = useCase;
    }

    void getData(RequestDataModel model) {
        useCase.execute(model).compose(bindToLifecycle()).subscribe(responseDataModel -> {
            if (view != null) {

            }
        });
    }
}
