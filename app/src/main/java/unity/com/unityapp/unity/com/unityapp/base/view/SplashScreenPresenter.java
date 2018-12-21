package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.BuildConfig;
import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.AnonymousTokenUseCase;

/**
 * Created by admin on 19/12/18.
 */

public class SplashScreenPresenter extends BasePresenter<SplashScreenView> {

    private final AnonymousTokenUseCase anonymousTokenUseCase;

    @Inject

    public SplashScreenPresenter(AnonymousTokenUseCase anonymousTokenUseCase) {
        this.anonymousTokenUseCase = anonymousTokenUseCase;
    }

    void getStartupData() {
        anonymousTokenUseCase.execute(BuildConfig.API_KEY)
                .compose(bindToLifecycle())
                .subscribe(startupDataModel -> {
                    UserInfo.getUserInfo().setAnonyMousToken(startupDataModel.getAnonymousToken());
                    if (view != null) {
                        view.completeStartup();
                    }
                });
    }
}
