package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class SavePersonalDetailsUseCase extends UseCase<PersonalDetailsDataModel, PersonalDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final PersonalDetailsResponseEntityToDataModelMapper personalDetailsResponseEntityToDataModelMapper;

    private final PersonalDetailsRequestDataModelToEntityMapper personalDetailsRequestDataModelToEntityMapper;

    @Inject
    public SavePersonalDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, PersonalDetailsResponseEntityToDataModelMapper personalDetailsResponseEntityToDataModelMapper, PersonalDetailsRequestDataModelToEntityMapper personalDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.personalDetailsResponseEntityToDataModelMapper = personalDetailsResponseEntityToDataModelMapper;
        this.personalDetailsRequestDataModelToEntityMapper = personalDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<PersonalDetailsResponseDataModel> createUseCaseObservable(PersonalDetailsDataModel personalDetailsDataModel) {
        return repository.savePersonalDetails(personalDetailsRequestDataModelToEntityMapper.mapToEntity(personalDetailsDataModel)).map(personalDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
