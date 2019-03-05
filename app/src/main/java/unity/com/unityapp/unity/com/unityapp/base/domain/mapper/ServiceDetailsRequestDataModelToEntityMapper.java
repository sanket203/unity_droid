package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class ServiceDetailsRequestDataModelToEntityMapper {

    @Inject
    public ServiceDetailsRequestDataModelToEntityMapper() {
    }

    public ServiceDetailsEntity mapToEntity(ServiceDetailsDataModel serviceDetailsDataModel) {
        ServiceDetailsEntity entity = new ServiceDetailsEntity();
        entity.setAddress(serviceDetailsDataModel.getAddress());
        entity.setAnnualIncome(serviceDetailsDataModel.getAnnualIncome());
        entity.setCandidateId(serviceDetailsDataModel.getCandidateId());
        entity.setDesignation(serviceDetailsDataModel.getDesignation());
        entity.setExperience(serviceDetailsDataModel.getExperience());
        entity.setOccupation(serviceDetailsDataModel.getOccupation());
        entity.setOrganization(serviceDetailsDataModel.getOrganization());
        entity.setSector(serviceDetailsDataModel.getSector());
        entity.setServiceStatus(serviceDetailsDataModel.getServiceStatus());
        entity.setOrganizationType(serviceDetailsDataModel.getOrganizationType());
        entity.setWorkingCity(serviceDetailsDataModel.getWorkingCity());
        return entity;
    }
}
