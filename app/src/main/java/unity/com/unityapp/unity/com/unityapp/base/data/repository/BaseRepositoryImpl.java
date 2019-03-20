package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RegisterUserEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ContactDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.EducationDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.EducationDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ExpectationDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ExpectationsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;
import unity.com.unityapp.unity.com.unityapp.base.networking.BaseApi;
import unity.com.unityapp.unity.com.unityapp.base.networking.NetworkClient;

/**
 * Created by admin on 10/12/18.
 */

public class BaseRepositoryImpl implements BaseRepository {

    private final NetworkClient networkClient;

    public BaseRepositoryImpl(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    @Override
    public Observable<RecentProfileResponseEntity> getRecentProfiles(String gender, String pageId) {
        return networkClient.create(BaseApi.class).getRecentProfiles(gender.toLowerCase(), pageId);
    }

    @Override
    public Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String candidateId, String pageId) {
        return networkClient.create(BaseApi.class).getAddresstakenProfiles(candidateId, pageId);
    }

    @Override
    public Observable<StartupDataEntity> getStartupData(String token) {
        return networkClient.create(BaseApi.class).getStartupData(token);
    }

    @Override
    public Observable<LoginUserResponseEntity> loginUser(LoginUserRequestEntity loginUserRequestEntity) {
        return networkClient.create(BaseApi.class).loginUser(loginUserRequestEntity);
    }

    @Override
    public Observable<PersonalDetailsResponseEntity> getPersonalDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getPersonalDetails(candidateId);
    }

    @Override
    public Observable<EducationDetailsResponseEntity> getEducationDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getEducationDetails(candidateId);
    }

    @Override
    public Observable<DietDetailsResponseEntity> getDietDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getDietDetails(candidateId);
    }

    @Override
    public Observable<ExpectationDetailsResponseEntity> getExpectationDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getExpectationDetails(candidateId);
    }

    @Override
    public Observable<FamilyDetailsResponseEntity> getFamilyDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getFamilyDetails(candidateId);
    }

    @Override
    public Observable<HoroscopeDetailsResponseEntity> getHoroscopeDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getHoroscopeDetails(candidateId);
    }


    @Override
    public Observable<PhysicalDetailsResponseEntity> getPhysicalDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getPhysicalDetails(candidateId);
    }

    @Override
    public Observable<ServiceDetailsResponseEntity> getServiceDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getServiceDetails(candidateId);
    }

    @Override
    public Observable<PersonalDetailsResponseEntity> savePersonalDetails(PersonalDetailsEntity personalDetailsEntity) {
        return networkClient.create(BaseApi.class).savePersonalDetails(personalDetailsEntity);
    }

    @Override
    public Observable<EducationDetailsResponseEntity> saveEducationalDetails(EducationDetailsEntity educationDetailsEntity) {
        return networkClient.create(BaseApi.class).saveEducationalDetails(educationDetailsEntity);
    }

    @Override
    public Observable<PhysicalDetailsResponseEntity> savePhysicalDetails(PhysicalDetailsEntity physicalDetailsEntity) {
        return networkClient.create(BaseApi.class).savePhysicalDetails(physicalDetailsEntity);
    }

    @Override
    public Observable<DietDetailsResponseEntity> saveDietDetails(DietDetailsEntity dietDetailsEntity) {
        return networkClient.create(BaseApi.class).saveDietDetails(dietDetailsEntity);
    }

    @Override
    public Observable<FamilyDetailsResponseEntity> saveFamilyDetails(FamilyDetailsEntity familyDetailsEntity) {
        return networkClient.create(BaseApi.class).saveFamilyDetails(familyDetailsEntity);
    }

    @Override
    public Observable<ExpectationDetailsResponseEntity> saveExpectationDetails(ExpectationsEntity expectationsEntity) {
        return networkClient.create(BaseApi.class).saveExpectationDetail(expectationsEntity);
    }

    @Override
    public Observable<HoroscopeDetailsResponseEntity> saveHoroscopeDetails(HoroscopeDetailsEntity horoscopeDetailsEntity) {
        return networkClient.create(BaseApi.class).saveHorosopeDetails(horoscopeDetailsEntity);
    }

    @Override
    public Observable<ServiceDetailsResponseEntity> saveServiceDetails(ServiceDetailsEntity serviceDetailsEntity) {
        return networkClient.create(BaseApi.class).saveServiceDetails(serviceDetailsEntity);
    }

    @Override
    public Observable<LoginUserResponseEntity> registerUser(RegisterUserEntity registerUserEntity) {
        return networkClient.create(BaseApi.class).registerUser(registerUserEntity);

    }

    @Override
    public Observable<ContactDetailsResponseEntity> checkAndGetContactDetails(String candidateId, String profileId, Boolean isAddressExist) {
        return networkClient.create(BaseApi.class).checkAndGetContact(candidateId, profileId, isAddressExist);
    }
}
