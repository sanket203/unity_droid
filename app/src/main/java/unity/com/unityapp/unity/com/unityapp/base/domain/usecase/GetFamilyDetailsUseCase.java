package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.FamilyDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsResponseDataModel;

public class GetFamilyDetailsUseCase extends UseCase<String, FamilyDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final FamilyDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetFamilyDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, FamilyDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<FamilyDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getFamilyDetails(candidateId).map(mapper::mapToDataModel);
    }
}
