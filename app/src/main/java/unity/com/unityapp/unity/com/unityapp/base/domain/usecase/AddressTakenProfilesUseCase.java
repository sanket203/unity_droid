package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.TwoArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.RecentProfileResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 10/12/18.
 */

public class AddressTakenProfilesUseCase extends TwoArgUseCase<String, String, RecentProfileResponseDataModel> {

    private final BaseRepository baseRepository;
    private final RecentProfileResponseEntityToDataModelMapper recentProfileResponseEntityToDataModelMapper;

    @Inject
    public AddressTakenProfilesUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository, RecentProfileResponseEntityToDataModelMapper recentProfileResponseEntityToDataModelMapper) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
        this.recentProfileResponseEntityToDataModelMapper = recentProfileResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<RecentProfileResponseDataModel> createUseCaseObservable(String candidateId, String pageId) {
        return baseRepository.getAddresstakenProfiles(candidateId, pageId)
                .map(recentProfileResponseEntityToDataModelMapper::mapToDataModel);
    }
}
