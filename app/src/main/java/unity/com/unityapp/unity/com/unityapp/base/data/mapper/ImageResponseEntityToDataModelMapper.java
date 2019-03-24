package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ImageResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ImageResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

public class ImageResponseEntityToDataModelMapper {

    @Inject
    public ImageResponseEntityToDataModelMapper() {
    }

    public ImageResponseDataModel mapToDataModel(ImageResponseEntity entity) {
        ImageResponseDataModel dataModel = new ImageResponseDataModel();
        dataModel.setImageUrls(entity.getImageUrls());
        dataModel.setMessage(entity.getMessage());
        dataModel.setStatus(entity.getStatus());
        return dataModel;
    }
}
