package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.AbroadDetailsResponseEntityToDatModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AbroadDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;

public class GetAbroadDetailsUseCase extends UseCase<String, AbroadDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final AbroadDetailsResponseEntityToDatModelMapper mapper;

    @Inject
    protected GetAbroadDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, AbroadDetailsResponseEntityToDatModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<AbroadDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getAbroadDetails(candidateId).map(mapper::mapToDataModel);
    }
}
