package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.ThreeArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.AddressDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ContactDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsResponseDataModel;

public class GetContactDetailsUseCase extends UseCase<String , AddressDetailsResponseDataModel> {

    private final BaseRepository baseRepository;

    private final ContactDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper;

    @Inject
    public GetContactDetailsUseCase(UseCaseComposer composer, BaseRepository baseRepository, ContactDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper) {
        super(composer);
        this.baseRepository = baseRepository;
        this.addressDetailsResponseEntityToDataModelMapper = addressDetailsResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<AddressDetailsResponseDataModel> createUseCaseObservable(String candidateId) {
        return baseRepository.GetContactDetails(candidateId).map(addressDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}

