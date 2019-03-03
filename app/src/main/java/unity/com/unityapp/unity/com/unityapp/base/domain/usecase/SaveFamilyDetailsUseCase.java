package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.DietDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.FamilyDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.DietDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.FamilyDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsResponseDataModel;

public class SaveFamilyDetailsUseCase extends UseCase<FamilyDetailsDataModel, FamilyDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final FamilyDetailsResponseEntityToDataModelMapper familyDetailsResponseEntityToDataModelMapper;

    private final FamilyDetailsRequestDataModelToEntityMapper familyDetailsRequestDataModelToEntityMapper;

    @Inject
    public SaveFamilyDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, FamilyDetailsResponseEntityToDataModelMapper familyDetailsResponseEntityToDataModelMapper, FamilyDetailsRequestDataModelToEntityMapper familyDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.familyDetailsResponseEntityToDataModelMapper = familyDetailsResponseEntityToDataModelMapper;
        this.familyDetailsRequestDataModelToEntityMapper = familyDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<FamilyDetailsResponseDataModel> createUseCaseObservable(FamilyDetailsDataModel familyDetailsDataModel) {
        return repository.saveFamilyDetails(familyDetailsRequestDataModelToEntityMapper.mapToEntity(familyDetailsDataModel)).map(familyDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
