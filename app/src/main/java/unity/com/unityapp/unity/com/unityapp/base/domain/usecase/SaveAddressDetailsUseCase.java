package unity.com.unityapp.unity.com.unityapp.base.domain.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.UseCase;
import unity.com.unityapp.unity.com.unityapp.base.UseCaseComposer;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.AddressDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.mapper.ContactDetailsResponseEntityToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.repository.BaseRepository;
import unity.com.unityapp.unity.com.unityapp.base.domain.mapper.AddressDetailsRequestDataModelToEntityMapper;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsResponseDataModel;

public class SaveAddressDetailsUseCase extends UseCase<AddressDataModel, AddressDetailsResponseDataModel> {

    private final BaseRepository repository;

    private final ContactDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper;

    private final AddressDetailsRequestDataModelToEntityMapper addressDetailsRequestDataModelToEntityMapper;


    @Inject
    public SaveAddressDetailsUseCase(UseCaseComposer useCaseComposer, BaseRepository repository, ContactDetailsResponseEntityToDataModelMapper addressDetailsResponseEntityToDataModelMapper, AddressDetailsRequestDataModelToEntityMapper addressDetailsRequestDataModelToEntityMapper) {
        super(useCaseComposer);
        this.repository = repository;
        this.addressDetailsResponseEntityToDataModelMapper = addressDetailsResponseEntityToDataModelMapper;
        this.addressDetailsRequestDataModelToEntityMapper = addressDetailsRequestDataModelToEntityMapper;
    }

    @Override
    protected Observable<AddressDetailsResponseDataModel> createUseCaseObservable(AddressDataModel addressDataModel) {
        return repository.saveAddressDetails(addressDetailsRequestDataModelToEntityMapper.mapToEntity(addressDataModel)).map(addressDetailsResponseEntityToDataModelMapper::mapToDataModel);
    }
}
