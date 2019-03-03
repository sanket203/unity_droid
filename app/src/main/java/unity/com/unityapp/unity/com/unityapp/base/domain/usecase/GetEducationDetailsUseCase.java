package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class GetEducationDetailsUseCase extends UseCase<String, EducationDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final EducationDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetEducationDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, EducationDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<EducationDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getEducationDetails(candidateId).map(mapper::mapToDataModel);
    }
}
