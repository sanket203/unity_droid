package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.HoroscopeDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.HoroscopeDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsResponseDataModel;

public class SaveHoroscopeDetailsUseCase extends UseCase<HoroscopeDetailsDataModel, HoroscopeDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final HoroscopeDetailsResponseEntityToDataModelMapper horoscopeDetailsResponseEntityToDataModelMapper;

    private final HoroscopeDetailsRequestDataModelToEntityMapper horoscopeDetailsRequestDataModelToEntityMapper;


    @Inject
    public SaveHoroscopeDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, HoroscopeDetailsResponseEntityToDataModelMapper horoscopeDetailsResponseEntityToDataModelMapper, HoroscopeDetailsRequestDataModelToEntityMapper horoscopeDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.horoscopeDetailsResponseEntityToDataModelMapper = horoscopeDetailsResponseEntityToDataModelMapper;
        this.horoscopeDetailsRequestDataModelToEntityMapper = horoscopeDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<HoroscopeDetailsResponseDataModel> createUseCaseObservable(HoroscopeDetailsDataModel horoscopeDetailsDataModel) {
        return repository.saveHoroscopeDetails(horoscopeDetailsRequestDataModelToEntityMapper.mapToEntity(horoscopeDetailsDataModel)).map(horoscopeDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
