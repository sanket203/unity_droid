package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import unity.com.unityapp.unity.com.unityapp.base.TwoArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.PersonalDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class UploadImageUseCase extends TwoArgUseCase<MultipartBody.Part, RequestBody, PersonalDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final PersonalDetailsResponseEntityToDataModelMapper personalDetailsResponseEntityToDataModelMapper;

    private final PersonalDetailsRequestDataModelToEntityMapper personalDetailsRequestDataModelToEntityMapper;

    @Inject
    public UploadImageUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, PersonalDetailsResponseEntityToDataModelMapper personalDetailsResponseEntityToDataModelMapper, PersonalDetailsRequestDataModelToEntityMapper personalDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.personalDetailsResponseEntityToDataModelMapper = personalDetailsResponseEntityToDataModelMapper;
        this.personalDetailsRequestDataModelToEntityMapper = personalDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<PersonalDetailsResponseDataModel> createUseCaseObservable(MultipartBody.Part file, RequestBody candidateId) {
        return repository.uploadImage(file, candidateId).map(personalDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
