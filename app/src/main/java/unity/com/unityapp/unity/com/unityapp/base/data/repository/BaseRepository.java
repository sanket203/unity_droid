package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RegisterUserEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;
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
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ImageResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseRepository {

    Observable<RecentProfileResponseEntity> getRecentProfiles(String gender, String pageId);

    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String candidateId, String pageId);

    Observable<StartupDataEntity> getStartupData(String token);

    Observable<LoginUserResponseEntity> loginUser(LoginUserRequestEntity loginUserRequestEntity);

    Observable<PersonalDetailsResponseEntity> getPersonalDetails(String candidateId);

    Observable<EducationDetailsResponseEntity> getEducationDetails(String candidateId);

    Observable<DietDetailsResponseEntity> getDietDetails(String candidateId);

    Observable<ExpectationDetailsResponseEntity> getExpectationDetails(String candidateId);

    Observable<FamilyDetailsResponseEntity> getFamilyDetails(String candidateId);

    Observable<HoroscopeDetailsResponseEntity> getHoroscopeDetails(String candidateId);

    Observable<PhysicalDetailsResponseEntity> getPhysicalDetails(String candidateId);

    Observable<ServiceDetailsResponseEntity> getServiceDetails(String candidateId);

    Observable<PersonalDetailsResponseEntity> savePersonalDetails(PersonalDetailsEntity personalDetailsEntity);

    Observable<EducationDetailsResponseEntity> saveEducationalDetails(EducationDetailsEntity educationDetailsEntity);

    Observable<PhysicalDetailsResponseEntity> savePhysicalDetails(PhysicalDetailsEntity mapToEntity);

    Observable<DietDetailsResponseEntity> saveDietDetails(DietDetailsEntity dietDetailsEntity);

    Observable<FamilyDetailsResponseEntity> saveFamilyDetails(FamilyDetailsEntity familyDetailsEntity);

    Observable<ExpectationDetailsResponseEntity> saveExpectationDetails(ExpectationsEntity expectationsEntity);

    Observable<HoroscopeDetailsResponseEntity> saveHoroscopeDetails(HoroscopeDetailsEntity horoscopeDetailsEntity);

    Observable<ServiceDetailsResponseEntity> saveServiceDetails(ServiceDetailsEntity serviceDetailsEntity);

    Observable<LoginUserResponseEntity> registerUser(RegisterUserEntity registerUserEntity);

    Observable<ContactDetailsResponseEntity> checkAndGetContactDetails(String candidateId, String profileId, Boolean isAddressExist);

    Observable<PersonalDetailsResponseEntity> uploadImage(MultipartBody.Part part, RequestBody candidateId);

    Observable<AddressDetailsResponseEntity> saveAddressDetails(AddressEntity entity);

    Observable<AddressDetailsResponseEntity> GetContactDetails(String candidateId);

    Observable<LoginUserResponseEntity> registerDone(String candidateId, String isRegistered);

    Observable<ImageResponseEntity> getImageIrls(String candidateId);
}

