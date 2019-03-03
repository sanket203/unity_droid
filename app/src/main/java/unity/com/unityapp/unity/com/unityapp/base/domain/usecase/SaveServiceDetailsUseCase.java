package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ServiceDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.ServiceDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsResponseDataModel;

public class SaveServiceDetailsUseCase extends UseCase<ServiceDetailsDataModel, ServiceDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final ServiceDetailsResponseEntityToDataModelMapper serviceDetailsResponseEntityToDataModelMapper;

    private final ServiceDetailsRequestDataModelToEntityMapper serviceDetailsRequestDataModelToEntityMapper;

    @Inject

    public SaveServiceDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, ServiceDetailsResponseEntityToDataModelMapper serviceDetailsResponseEntityToDataModelMapper, ServiceDetailsRequestDataModelToEntityMapper serviceDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.serviceDetailsResponseEntityToDataModelMapper = serviceDetailsResponseEntityToDataModelMapper;
        this.serviceDetailsRequestDataModelToEntityMapper = serviceDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<ServiceDetailsResponseDataModel> createUseCaseObservable(ServiceDetailsDataModel serviceDetailsDataModel) {
        return repository.saveServiceDetails(serviceDetailsRequestDataModelToEntityMapper.mapToEntity(serviceDetailsDataModel)).map(serviceDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
