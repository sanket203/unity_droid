package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveExpectationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ExpectationDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ExpectationDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public class EditExpectationDetailsPresenter extends BasePresenter<EditExpectationDetailsView> {

    private final SaveExpectationDetailsUseCase saveExpectationDetailsUseCase;

    private final ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper;

    private final ExpectationDetailsViewModelToDataModelMapper expectationDetailsViewModelToDataModelMapper;

    @Inject
    public EditExpectationDetailsPresenter(SaveExpectationDetailsUseCase saveExpectationDetailsUseCase, ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper, ExpectationDetailsViewModelToDataModelMapper expectationDetailsViewModelToDataModelMapper) {
        this.saveExpectationDetailsUseCase = saveExpectationDetailsUseCase;
        this.expectationDetailsDataModelToViewModelMapper = expectationDetailsDataModelToViewModelMapper;
        this.expectationDetailsViewModelToDataModelMapper = expectationDetailsViewModelToDataModelMapper;
    }

    public void save(ExpectationsViewModel expectationDetailsViewModel) {
        if (view != null) {
            view.showProgress(true);
        }
        saveExpectationDetailsUseCase.execute(expectationDetailsViewModelToDataModelMapper.mapToDataModel(expectationDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(expectationDetailsResponseDataModel -> {
            if (expectationDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ExpectationsViewModel viewModel = expectationDetailsDataModelToViewModelMapper.mapToViewModel(expectationDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.close();
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", expectationDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}
