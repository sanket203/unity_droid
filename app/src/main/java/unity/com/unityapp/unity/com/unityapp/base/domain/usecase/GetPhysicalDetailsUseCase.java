package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.PhysicalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsResponseDataModel;

public class GetPhysicalDetailsUseCase extends UseCase<String, PhysicalDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final PhysicalDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetPhysicalDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, PhysicalDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<PhysicalDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getPhysicalDetails(candidateId).map(mapper::mapToDataModel);
    }
}
