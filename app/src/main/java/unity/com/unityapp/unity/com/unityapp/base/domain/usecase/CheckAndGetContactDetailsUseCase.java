package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.ThreeArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.TwoArgUseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.AddressDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class CheckAndGetContactDetailsUseCase extends ThreeArgUseCase<String, String, Boolean, ContactDetailsResponseDataModel> {

    private final BaseRepository baseRepository;

    private final AddressDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper;

    @Inject
    public CheckAndGetContactDetailsUseCase(UseCaseComposer composer, BaseRepository baseRepository, AddressDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper) {
        super(composer);
        this.baseRepository = baseRepository;
        this.addressDetailsResponseEntityToDataModelMapper = addressDetailsResponseEntityToDataModelMapper;
    }

    @Override
    protected Observable<ContactDetailsResponseDataModel> createUseCaseObservable(String candidateId, String profileId, Boolean isAddressTaken) {
        return baseRepository.checkAndGetContactDetails(candidateId, profileId, isAddressTaken).map(addressDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}

