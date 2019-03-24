package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.ImageResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

public class ImageResponseDataModelToViewModelMapper {

    @Inject
    public ImageResponseDataModelToViewModelMapper() {
    }

    public ImageResponseViewModel mapToViewModel(ImageResponseDataModel dataModel) {
        ImageResponseViewModel viewModel = new ImageResponseViewModel();
        viewModel.setImageUrls(dataModel.getImageUrls());
        return viewModel;
    }
}
