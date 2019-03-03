package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.EducationDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class SaveEducationDetailsUseCase extends UseCase<EducationalDetailsDataModel, EducationDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final EducationDetailsResponseEntityToDataModelMapper educationDetailsResponseEntityToDataModelMapper;

    private final EducationDetailsRequestDataModelToEntityMapper educationDetailsRequestDataModelToEntityMapper;

    @Inject
    public SaveEducationDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, EducationDetailsResponseEntityToDataModelMapper educationDetailsResponseEntityToDataModelMapper, EducationDetailsRequestDataModelToEntityMapper educationDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.educationDetailsResponseEntityToDataModelMapper = educationDetailsResponseEntityToDataModelMapper;
        this.educationDetailsRequestDataModelToEntityMapper = educationDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<EducationDetailsResponseDataModel> createUseCaseObservable(EducationalDetailsDataModel educationalDetailsDataModel) {
        return repository.saveEducationalDetails(educationDetailsRequestDataModelToEntityMapper.mapToEntity(educationalDetailsDataModel)).map(educationDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
