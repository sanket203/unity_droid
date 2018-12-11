package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.RecentProfileResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.RecentProfileRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileRequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 10/12/18.
 */

public class RecentProfilesUseCase extends UseCase<RecentProfileRequestDataModel, RecentProfileResponseDataModel> {

    private final BaseRepository baseRepository;
    private final RecentProfileRequestDataModelToEntityMapper recentProfileRequestDataModelToEntityMapper;
    private final RecentProfileResponseEntityToDataModelMapper recentProfileResponseEntityToDataModelMapper;

    @Inject
    public RecentProfilesUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository, RecentProfileRequestDataModelToEntityMapper recentProfileRequestDataModelToEntityMapper, RecentProfileResponseEntityToDataModelMapper recentProfileResponseEntityToDataModelMapper) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
        this.recentProfileRequestDataModelToEntityMapper = recentProfileRequestDataModelToEntityMapper;
        this.recentProfileResponseEntityToDataModelMapper = recentProfileResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<RecentProfileResponseDataModel> createUseCaseObservable(RecentProfileRequestDataModel recentProfileRequestDataModel) {
        return baseRepository.getData(recentProfileRequestDataModelToEntityMapper.mapToEntity(recentProfileRequestDataModel))
                .map(recentProfileResponseEntityToDataModelMapper::mapToDataModel);
    }
}
