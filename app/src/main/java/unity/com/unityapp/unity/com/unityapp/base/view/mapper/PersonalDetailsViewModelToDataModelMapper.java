package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class PersonalDetailsViewModelToDataModelMapper {

    @Inject
    public PersonalDetailsViewModelToDataModelMapper() {
    }

    public PersonalDetailsDataModel mapToDataModel(PersonalDetailsViewModel viewModel) {
        PersonalDetailsDataModel dataModel = new PersonalDetailsDataModel();

        dataModel.setAboutMe(viewModel.getAboutMe());
        dataModel.setBirthDate(viewModel.getBirthDate());
        dataModel.setBirthPlace(viewModel.getBirthPlace());
        dataModel.setBirthTime(viewModel.getBirthTime());
        dataModel.setFirstName(viewModel.getFirstName());
        dataModel.setGender(viewModel.getGender());
        dataModel.setHobbies(viewModel.getHobbies());
        dataModel.setLastName(viewModel.getLastName());
        dataModel.setMailId(viewModel.getMailId());
        dataModel.setMaritalStatus(dataModel.getMaritalStatus());
        dataModel.setMiddleName(viewModel.getMiddleName());
        dataModel.setCandidateId(viewModel.getCandidateId());
        return dataModel;
    }
}
