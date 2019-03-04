package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class EditServiceDetailsActivity extends BaseActivity implements EditServiceDetailsView {

    @Inject
    EditServiceDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editOccupation)
    EditText editOccupation;

    @BindView(R.id.editOrganization)
    EditText editOrganization;

    @BindView(R.id.editOrganizationType)
    EditText editOrganizationType;

    @BindView(R.id.editSector)
    EditText editSector;

    @BindView(R.id.editDesignation)
    EditText editDesignation;

    @BindView(R.id.editServiceStatus)
    EditText editServiceStatus;

    @BindView(R.id.editExperience)
    EditText editExperience;

    @BindView(R.id.editAnnualIncome)
    EditText editAnnualIncome;

    @BindView(R.id.editWorkingCity)
    AutoCompleteTextView editWorkingCity;

    private int candidateId;

    private ServiceDetailsViewModel serviceDetailsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_service_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Service Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        editWorkingCity.setAdapter(adapter);
        serviceDetailsViewModel = (ServiceDetailsViewModel) getIntent().getSerializableExtra("serviceDetailsViewModel");
        setData();
    }


    private void setData() {
        if (serviceDetailsViewModel != null) {
            editOccupation.setText(serviceDetailsViewModel.getOccupation());
            editOrganization.setText(serviceDetailsViewModel.getOrganization());
            editOrganizationType.setText(serviceDetailsViewModel.getOrganizationType());
            editSector.setText(serviceDetailsViewModel.getSector());
            editWorkingCity.setText(serviceDetailsViewModel.getWorkingCity());
            editDesignation.setText(serviceDetailsViewModel.getDesignation());
            editServiceStatus.setText(serviceDetailsViewModel.getServiceStatus());
            editExperience.setText(serviceDetailsViewModel.getExperience());
            editAnnualIncome.setText(serviceDetailsViewModel.getAnnualIncome());
        }
    }

    private ServiceDetailsViewModel getData() {
        ServiceDetailsViewModel serviceDetailsViewModel = new ServiceDetailsViewModel();
        serviceDetailsViewModel.setCandidateId(candidateId);
        if (editOccupation.getText() != null) {
            serviceDetailsViewModel.setOccupation(editOccupation.getText().toString());
        }
        if (editOrganization.getText() != null) {
            serviceDetailsViewModel.setOrganization(editOrganization.getText().toString());
        }
        if (editOrganizationType.getText() != null) {
            serviceDetailsViewModel.setOrganizationType(editOrganizationType.getText().toString());
        }
        if (editSector.getText() != null) {
            serviceDetailsViewModel.setSector(editSector.getText().toString());
        }
        if (editWorkingCity.getText() != null) {
            serviceDetailsViewModel.setWorkingCity(editWorkingCity.getText().toString());
        }
        if (editDesignation.getText() != null) {
            serviceDetailsViewModel.setDesignation(editDesignation.getText().toString());
        }
        if (editServiceStatus.getText() != null) {
            serviceDetailsViewModel.setServiceStatus(editServiceStatus.getText().toString());
        }
        if (editExperience.getText() != null) {
            serviceDetailsViewModel.setExperience(editExperience.getText().toString());
        }
        if (editAnnualIncome.getText() != null) {
            serviceDetailsViewModel.setAnnualIncome(Integer.parseInt(editAnnualIncome.getText().toString()));
        }
        return serviceDetailsViewModel;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @OnClick(R.id.btn_save)
    void onSaveClick() {
        presenter.save(getData());
    }

    @Override
    public void showProgress(boolean showProgress) {
        if (showProgress) {
            loader.setVisibility(View.VISIBLE);
        } else {
            loader.setVisibility(View.GONE);
        }
    }

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain", "India", "Bangladesh", "Banglore"
    };
}
