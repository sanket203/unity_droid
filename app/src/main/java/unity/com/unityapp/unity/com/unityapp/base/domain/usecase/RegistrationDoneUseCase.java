package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.TwoArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.LoginUserResponseEntityModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserResponseDataModel;


public class RegistrationDoneUseCase extends TwoArgUseCase<String, String, LoginUserResponseDataModel> {

    private final BaseRepository baseRepository;


    private final LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper;

    @Inject
    public RegistrationDoneUseCase(UseCaseComposer composer, BaseRepository baseRepository, LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper) {
        super(composer);
        this.baseRepository = baseRepository;
        this.loginUserResponseEntityModelToDataModelMapper = loginUserResponseEntityModelToDataModelMapper;
    }

    @Override
    protected Observable<LoginUserResponseDataModel> createUseCaseObservable(String candidateId, String isRegistered) {
        return baseRepository.registerDone(candidateId, isRegistered).map(loginUserResponseEntityModelToDataModelMapper::mapToEntity);

    }
}
