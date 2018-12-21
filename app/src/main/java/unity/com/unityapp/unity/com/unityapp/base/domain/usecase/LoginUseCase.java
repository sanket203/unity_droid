package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.LoginUserResponseEntityModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.LoginUserRequestDataModelToEntitymapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserRequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserResponseDataModel;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUseCase extends UseCase<LoginUserRequestDataModel, LoginUserResponseDataModel> {

    private final BaseRepository baseRepository;

    private final LoginUserRequestDataModelToEntitymapper loginUserRequestDataModelToEntitymapper;

    private final LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper;

    @Inject
    protected LoginUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository, LoginUserRequestDataModelToEntitymapper loginUserRequestDataModelToEntitymapper, LoginUserResponseEntityModelToDataModelMapper loginUserResponseEntityModelToDataModelMapper) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
        this.loginUserRequestDataModelToEntitymapper = loginUserRequestDataModelToEntitymapper;
        this.loginUserResponseEntityModelToDataModelMapper = loginUserResponseEntityModelToDataModelMapper;
    }

    @Override
    protected Observable<LoginUserResponseDataModel> createUseCaseObservable(LoginUserRequestDataModel param) {
        return baseRepository.loginUser(loginUserRequestDataModelToEntitymapper.mapToEntity(param)).map(loginUserResponseEntityModelToDataModelMapper::mapToEntity);
    }
}
