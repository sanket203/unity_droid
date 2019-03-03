package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;

import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class GetPersonalDetailsUseCase extends UseCase<String, PersonalDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final PersonalDetailsResponseEntityToDataModelMapper mapper;


    @Inject
    protected GetPersonalDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, PersonalDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<PersonalDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getPersonalDetails(candidateId).map(mapper::mapToDataModel);
    }
}
