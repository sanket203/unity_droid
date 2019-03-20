package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.LoginUserResponseEntityModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.RegisterUserDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.request.RegisterUserDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RegisterUserViewModel;

public class RegisterUserUseCase extends UseCase<RegisterUserDataModel, LoginUserResponseDataModel> {

    private final BaseRepository baseRepository;

    private final RegisterUserDataModelToEntityMapper registerUserDataModelToEntityMapper;

    private final LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper;

    @Inject
    protected RegisterUserUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository, RegisterUserDataModelToEntityMapper registerUserDataModelToEntityMapper, LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
        this.registerUserDataModelToEntityMapper = registerUserDataModelToEntityMapper;
        this.loginUserResponseEntityModelToDataModelMapper = loginUserResponseEntityModelToDataModelMapper;
    }

    @Override
    protected Observable<LoginUserResponseDataModel> createUseCaseObservable(RegisterUserDataModel registerUserDataModel) {
        return baseRepository.registerUser(registerUserDataModelToEntityMapper.mapToEntity(registerUserDataModel)).map(loginUserResponseEntityModelToDataModelMapper::mapToEntity);
    }
}
