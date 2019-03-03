package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ServiceDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ServiceDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class ServiceDetailsDataModelToViewModelMapper {

    @Inject
    public ServiceDetailsDataModelToViewModelMapper() {
    }

    public ServiceDetailsViewModel mapToViewModel(ServiceDetailsResponseDataModel serviceDetailsResponseDataModel) {


        ServiceDetailsViewModel serviceDetailsViewModel = new ServiceDetailsViewModel();
        serviceDetailsViewModel.setAddress(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getAddress());
        serviceDetailsViewModel.setAnnualIncome(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getAnnualIncome());
        serviceDetailsViewModel.setCandidateId(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getCandidateId());
        serviceDetailsViewModel.setDesignation(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getDesignation());
        serviceDetailsViewModel.setExperience(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getExperience());
        serviceDetailsViewModel.setOccupation(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getOccupation());
        serviceDetailsViewModel.setOrganization(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getOrganization());
        serviceDetailsViewModel.setSector(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getSector());
        serviceDetailsViewModel.setServiceStatus(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getServiceStatus());
        serviceDetailsViewModel.setOrganizationType(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getOrganizationType());
        serviceDetailsViewModel.setWorkingCity(serviceDetailsResponseDataModel.getServiceDetailsDataModel().getWorkingCity());
        return serviceDetailsViewModel;
    }
}


