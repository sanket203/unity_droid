package unity.com.unityapp.unity.com.unityapp.base.networking;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
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

public interface BaseApi {

    @GET("latestProfile/{gender}/{pageId}")
    Observable<RecentProfileResponseEntity> getRecentProfiles(@Path("gender") String gender, @Path("pageId") String pageId);

    @GET("addressTakenProfiles/{candidateId}/{pageId}")
    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(@Path("candidateId") String candidateId, @Path("pageId") String pageId);

    @GET("addressTakenProfiles/{candidateId}/{pageId}")
    Observable<StartupDataEntity> getStartupData(String token);

    @POST("matrimony/login")
    Observable<LoginUserResponseEntity> loginUser(@Body LoginUserRequestEntity loginUserRequestEntity);

    @GET("getPersonalDetails/{candidateId}")
    Observable<PersonalDetailsResponseEntity> getPersonalDetails(@Path("candidateId") String candidateId);

    @GET("getQualificationDetails/{candidateId}")
    Observable<EducationDetailsResponseEntity> getEducationDetails(@Path("candidateId") String candidateId);

    @GET("getDietDetails/{candidateId}")
    Observable<DietDetailsResponseEntity> getDietDetails(@Path("candidateId") String candidateId);

    @GET("getExpectationDetails/{candidateId}")
    Observable<ExpectationDetailsResponseEntity> getExpectationDetails(@Path("candidateId") String candidateId);

    @GET("getFamilyDetails/{candidateId}")
    Observable<FamilyDetailsResponseEntity> getFamilyDetails(@Path("candidateId") String candidateId);

    @GET("getHoroscopeDetails/{candidateId}")
    Observable<HoroscopeDetailsResponseEntity> getHoroscopeDetails(@Path("candidateId") String candidateId);

    @GET("getPhysicalDetails/{candidateId}")
    Observable<PhysicalDetailsResponseEntity> getPhysicalDetails(@Path("candidateId") String candidateId);

    @GET("getServiceDetails/{candidateId}")
    Observable<ServiceDetailsResponseEntity> getServiceDetails(@Path("candidateId") String candidateId);

    @POST("savePersonalDetails")
    Observable<PersonalDetailsResponseEntity> savePersonalDetails(@Body PersonalDetailsEntity personalDetailsEntity);

    @POST("saveQualification")
    Observable<EducationDetailsResponseEntity> saveEducationalDetails(@Body EducationDetailsEntity educationDetailsEntity);

    @POST("savePhysicalDetails")
    Observable<PhysicalDetailsResponseEntity> savePhysicalDetails(@Body PhysicalDetailsEntity physicalDetailsEntity);

    @POST("saveDietDetails")
    Observable<DietDetailsResponseEntity> saveDietDetails(@Body DietDetailsEntity dietDetailsEntity);

    @POST("saveFamilyDetails")
    Observable<FamilyDetailsResponseEntity> saveFamilyDetails(@Body FamilyDetailsEntity familyDetailsEntity);

    @POST("saveExpectationDetails")
    Observable<ExpectationDetailsResponseEntity> saveExpectationDetail(@Body ExpectationsEntity expectationsEntity);

    @POST("saveHoroscopeDetails")
    Observable<HoroscopeDetailsResponseEntity> saveHorosopeDetails(@Body HoroscopeDetailsEntity horoscopeDetailsEntity);

    @POST("saveServiceDetails")
    Observable<ServiceDetailsResponseEntity> saveServiceDetails(@Body ServiceDetailsEntity serviceDetailsEntity);

    @POST("checkUser")
    Observable<LoginUserResponseEntity> registerUser(@Body RegisterUserEntity registerUserEntity);

    @GET("getProfileAddress/{candidateId}/{profileId}/{isAddressTaken}")
    Observable<ContactDetailsResponseEntity> checkAndGetContact(@Path("candidateId") String candidateId, @Path("profileId") String profileId, @Path("isAddressTaken") Boolean isAddressExist);

    @Multipart
    @POST("uploadFiles/{candidateId}")
    Observable<PersonalDetailsResponseEntity> uploadImage(@Part MultipartBody.Part part, @Part("candidateId") RequestBody candidateId);


    @POST("saveAddressDetails")
    Observable<AddressDetailsResponseEntity> saveAddress(@Body AddressEntity entity);

    @GET("getAddressDetails/{candidateId}")
    Observable<AddressDetailsResponseEntity> GetContactDetails(@Path("candidateId") String candidateId);

    @POST("register/{candidateId}/{isRegistered}")
    Observable<LoginUserResponseEntity> registerDone(@Path("candidateId") String candidateId, @Path("isRegistered") String isRegistered);

    @GET("getImages/{candidateId}")
    Observable<ImageResponseEntity> getImages(@Path("candidateId") String candidateId);
}
