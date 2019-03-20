package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsResponseDataModel;

public class ServiceDetailsResponseEntityToDataModelMapper {

    @Inject
    public ServiceDetailsResponseEntityToDataModelMapper() {
    }

    public ServiceDetailsResponseDataModel mapToDataModel(ServiceDetailsResponseEntity serviceDetailsResponseEntity) {

        ServiceDetailsResponseDataModel serviceDetailsResponseDataModel = new ServiceDetailsResponseDataModel();
        serviceDetailsResponseDataModel.setMessage(serviceDetailsResponseEntity.getMessage());
        serviceDetailsResponseDataModel.setStatus(serviceDetailsResponseEntity.getStatus());
        ServiceDetailsDataModel serviceDetailsDataModel = new ServiceDetailsDataModel();
        if (serviceDetailsResponseEntity.getServiceDetailsEntity() != null) {
            serviceDetailsDataModel.setAddress(serviceDetailsResponseEntity.getServiceDetailsEntity().getAddress());
            serviceDetailsDataModel.setAnnualIncome(serviceDetailsResponseEntity.getServiceDetailsEntity().getAnnualIncome());
            serviceDetailsDataModel.setCandidateId(serviceDetailsResponseEntity.getServiceDetailsEntity().getCandidateId());
            serviceDetailsDataModel.setDesignation(serviceDetailsResponseEntity.getServiceDetailsEntity().getDesignation());
            serviceDetailsDataModel.setExperience(serviceDetailsResponseEntity.getServiceDetailsEntity().getExperience());
            serviceDetailsDataModel.setOccupation(serviceDetailsResponseEntity.getServiceDetailsEntity().getOccupation());
            serviceDetailsDataModel.setOrganization(serviceDetailsResponseEntity.getServiceDetailsEntity().getOrganization());
            serviceDetailsDataModel.setSector(serviceDetailsResponseEntity.getServiceDetailsEntity().getSector());
            serviceDetailsDataModel.setServiceStatus(serviceDetailsResponseEntity.getServiceDetailsEntity().getServiceStatus());
            serviceDetailsDataModel.setOrganizationType(serviceDetailsResponseEntity.getServiceDetailsEntity().getOrganizationType());
            serviceDetailsDataModel.setWorkingCity(serviceDetailsResponseEntity.getServiceDetailsEntity().getWorkingCity());
        }
        serviceDetailsResponseDataModel.setServiceDetailsDataModel(serviceDetailsDataModel);
        return serviceDetailsResponseDataModel;
    }
}


