package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetImageUrlUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ImageResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

/**
 * Created by admin on 17/12/18.
 */

public class MyProfilePresenter extends BasePresenter<MyProfileView> {

    private final GetImageUrlUseCase getImageUrlUseCase;
    private final ImageResponseDataModelToViewModelMapper imageResponseDataModelToViewModelMapper;

    @Inject
    public MyProfilePresenter(GetImageUrlUseCase getImageUrlUseCase, ImageResponseDataModelToViewModelMapper imageResponseDataModelToViewModelMapper) {
        this.getImageUrlUseCase = getImageUrlUseCase;
        this.imageResponseDataModelToViewModelMapper = imageResponseDataModelToViewModelMapper;
    }

    public void getImages(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getImageUrlUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                if (view != null) {
                    view.showProgressBar(false);
                    ImageResponseViewModel viewModel = imageResponseDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                    view.showImages(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgressBar(false);
                }
                Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgressBar(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}
