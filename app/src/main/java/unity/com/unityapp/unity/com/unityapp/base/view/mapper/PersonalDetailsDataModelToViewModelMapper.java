package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class PersonalDetailsDataModelToViewModelMapper {

    @Inject
    public PersonalDetailsDataModelToViewModelMapper() {
    }

    public PersonalDetailsViewModel mapToViewModel(PersonalDetailsResponseDataModel dataModel) {
        PersonalDetailsViewModel viewModel = new PersonalDetailsViewModel();

        viewModel.setAboutMe(dataModel.getPersonalDetailsDataModel().getAboutMe());
        viewModel.setBirthDate(dataModel.getPersonalDetailsDataModel().getBirthDate());
        viewModel.setBirthPlace(dataModel.getPersonalDetailsDataModel().getBirthPlace());
        viewModel.setBirthTime(dataModel.getPersonalDetailsDataModel().getBirthTime());
        viewModel.setFirstName(dataModel.getPersonalDetailsDataModel().getFirstName());
        viewModel.setGender(dataModel.getPersonalDetailsDataModel().getGender());
        viewModel.setHobbies(dataModel.getPersonalDetailsDataModel().getHobbies());
        viewModel.setLastName(dataModel.getPersonalDetailsDataModel().getLastName());
        viewModel.setMailId(dataModel.getPersonalDetailsDataModel().getMailId());
        viewModel.setMaritalStatus(dataModel.getPersonalDetailsDataModel().getMaritalStatus());
        viewModel.setMiddleName(dataModel.getPersonalDetailsDataModel().getMiddleName());
        viewModel.setMotherTongue(dataModel.getPersonalDetailsDataModel().getMotherTongue());

        return viewModel;
    }
}
