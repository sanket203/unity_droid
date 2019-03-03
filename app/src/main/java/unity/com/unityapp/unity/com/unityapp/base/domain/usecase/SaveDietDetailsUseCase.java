package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.DietDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.DietDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class SaveDietDetailsUseCase extends UseCase<DietDetailsDataModel, DietDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final DietDetailsResponseEntityToDataModelMapper dietDetailsResponseEntityToDataModelMapper;

    private final DietDetailsRequestDataModelToEntityMapper dietDetailsRequestDataModelToEntityMapper;

    @Inject

    public SaveDietDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, DietDetailsResponseEntityToDataModelMapper dietDetailsResponseEntityToDataModelMapper, DietDetailsRequestDataModelToEntityMapper dietDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.dietDetailsResponseEntityToDataModelMapper = dietDetailsResponseEntityToDataModelMapper;
        this.dietDetailsRequestDataModelToEntityMapper = dietDetailsRequestDataModelToEntityMapper;
    }


    @Override
    protected Observable<DietDetailsResponseDataModel> createUseCaseObservable(DietDetailsDataModel dietDetailsDataModel) {
        return repository.saveDietDetails(dietDetailsRequestDataModelToEntityMapper.mapToEntity(dietDetailsDataModel)).map(dietDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
