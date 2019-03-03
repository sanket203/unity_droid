package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ExpectationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationDetailsResponseDataModel;

public class GetExpectationDetailsUseCase extends UseCase<String, ExpectationDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final ExpectationDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetExpectationDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, ExpectationDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<ExpectationDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getExpectationDetails(candidateId).map(mapper::mapToDataModel);
    }
}
