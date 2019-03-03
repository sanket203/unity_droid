package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ExpectationDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.ExpectationDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationsDataModel;

public class SaveExpectationDetailsUseCase extends UseCase<ExpectationsDataModel, ExpectationDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final ExpectationDetailsResponseEntityToDataModelMapper expectationDetailsResponseEntityToDataModelMapper;

    private final ExpectationDetailsRequestDataModelToEntityMapper expectationDetailsRequestDataModelToEntityMapper;

    @Inject
    public SaveExpectationDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, ExpectationDetailsResponseEntityToDataModelMapper expectationDetailsResponseEntityToDataModelMapper, ExpectationDetailsRequestDataModelToEntityMapper expectationDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.expectationDetailsResponseEntityToDataModelMapper = expectationDetailsResponseEntityToDataModelMapper;
        this.expectationDetailsRequestDataModelToEntityMapper = expectationDetailsRequestDataModelToEntityMapper;
    }


    @Override
    protected Observable<ExpectationDetailsResponseDataModel> createUseCaseObservable(ExpectationsDataModel expectationsDataModel) {
        return repository.saveExpectationDetails(expectationDetailsRequestDataModelToEntityMapper.mapToEntity(expectationsDataModel)).map(expectationDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
