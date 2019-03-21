package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class ServiceDetailsViewModelToDataModelMapper {

    @Inject
    public ServiceDetailsViewModelToDataModelMapper() {
    }

    public ServiceDetailsDataModel mapToDataModel(ServiceDetailsViewModel serviceDetailsViewModel) {
        ServiceDetailsDataModel dataModel = new ServiceDetailsDataModel();
        dataModel.setAddress(serviceDetailsViewModel.getAddress());
        dataModel.setAnnualIncome(serviceDetailsViewModel.getAnnualIncome());
        dataModel.setCandidateId(serviceDetailsViewModel.getCandidateId());
        dataModel.setDesignation(serviceDetailsViewModel.getDesignation());
        dataModel.setExperience(serviceDetailsViewModel.getExperience());
        dataModel.setOccupation(serviceDetailsViewModel.getOccupation());
        dataModel.setOrganization(serviceDetailsViewModel.getOrganization());
        dataModel.setSector(serviceDetailsViewModel.getSector());
        dataModel.setServiceStatus(serviceDetailsViewModel.getServiceStatus());
        dataModel.setOrganizationType(serviceDetailsViewModel.getOrganizationType());
        dataModel.setWorkingCity(serviceDetailsViewModel.getWorkingCity());
        dataModel.setId(serviceDetailsViewModel.getId());
        return dataModel;
    }
}
