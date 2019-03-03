package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ServiceDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsResponseDataModel;

public class GetServiceDetailsUseCase extends UseCase<String, ServiceDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final ServiceDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetServiceDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, ServiceDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<ServiceDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getServiceDetails(candidateId).map(mapper::mapToDataModel);
    }
}
