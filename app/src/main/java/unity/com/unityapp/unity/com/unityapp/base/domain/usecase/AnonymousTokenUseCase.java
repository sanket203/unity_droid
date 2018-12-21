package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.StartupDataEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataModel;

/**
 * Created by admin on 19/12/18.
 */

public class AnonymousTokenUseCase extends UseCase<String, StartupDataModel> {

    private final BaseRepository baseRepository;
    private final StartupDataEntityToDataModelMapper mapper;

    @Inject
    protected AnonymousTokenUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository, StartupDataEntityToDataModelMapper mapper) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
        this.mapper = mapper;
    }

    @Override
    protected Observable<StartupDataModel> createUseCaseObservable(String param) {
        return baseRepository.getStartupData(param).map(mapper::mapToDataModel);
    }
}
