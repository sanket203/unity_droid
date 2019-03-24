package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ContactDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ImageResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ImageResponseDataModel;

public class GetImageUrlUseCase extends UseCase<String, ImageResponseDataModel> {

    private final BaseRepository baseRepository;

    private final ImageResponseEntityToDataModelMapper imageResponseEntityToDataModelMapper;

    @Inject
    public GetImageUrlUseCase(UseCaseComposer composer, BaseRepository baseRepository, ImageResponseEntityToDataModelMapper imageResponseEntityToDataModelMapper) {
        super(composer);
        this.baseRepository = baseRepository;
        this.imageResponseEntityToDataModelMapper = imageResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<ImageResponseDataModel> createUseCaseObservable(String candidateId) {
        return baseRepository.getImageIrls(candidateId).map(imageResponseEntityToDataModelMapper::mapToDataModel);
    }
}

