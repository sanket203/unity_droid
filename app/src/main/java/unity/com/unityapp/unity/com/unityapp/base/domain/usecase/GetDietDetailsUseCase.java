package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.DietDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;

public class GetDietDetailsUseCase extends UseCase<String, DietDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final DietDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetDietDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, DietDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<DietDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getDietDetails(candidateId).map(mapper::mapToDataModel);
    }
}
