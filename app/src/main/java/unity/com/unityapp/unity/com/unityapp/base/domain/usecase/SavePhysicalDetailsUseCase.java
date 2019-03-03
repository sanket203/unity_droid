package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.PhysicalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PhysicalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsResponseDataModel;

public class SavePhysicalDetailsUseCase extends UseCase<PhysicalDetailsDataModel, PhysicalDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final PhysicalDetailsResponseEntityToDataModelMapper physicalDetailsResponseEntityToDataModelMapper;

    private final PhysicalDetailsRequestDataModelToEntityMapper physicalDetailsRequestDataModelToEntityMapper;

    @Inject
    public SavePhysicalDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, PhysicalDetailsResponseEntityToDataModelMapper physicalDetailsResponseEntityToDataModelMapper, PhysicalDetailsRequestDataModelToEntityMapper physicalDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.physicalDetailsResponseEntityToDataModelMapper = physicalDetailsResponseEntityToDataModelMapper;
        this.physicalDetailsRequestDataModelToEntityMapper = physicalDetailsRequestDataModelToEntityMapper;
    }


    @Override
    protected Observable<PhysicalDetailsResponseDataModel> createUseCaseObservable(PhysicalDetailsDataModel physicalDetailsDataModel) {
        return repository.savePhysicalDetails(physicalDetailsRequestDataModelToEntityMapper.mapToEntity(physicalDetailsDataModel)).map(physicalDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
