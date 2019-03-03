package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.EducationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.HoroscopeDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsResponseDataModel;

public class GetHoroscopeDetailsUseCase extends UseCase<String, HoroscopeDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final HoroscopeDetailsResponseEntityToDataModelMapper mapper;

    @Inject
    protected GetHoroscopeDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, HoroscopeDetailsResponseEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<HoroscopeDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return repository.getHoroscopeDetails(candidateId).map(mapper::mapToDataModel);
    }
}
