package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ResponseDataModel;

/**
 * Created by admin on 10/12/18.
 */

public class HomeUseCase extends UseCase<RequestDataModel, ResponseDataModel> {

    private final BaseRepository baseRepository;

    @Inject
    public HomeUseCase(UseCaseComposer useCaseComposer, BaseRepository baseRepository) {
        super(useCaseComposer);
        this.baseRepository = baseRepository;
    }

    @Override
    protected Observable<ResponseDataModel> createUseCaseObservable(RequestDataModel param) {
        return null;
    }
}
