package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.editWorkingCity)
    AutoCompleteTextView editWorkingCity;

    private int candidateId;

    private ServiceDetailsViewModel serviceDetailsViewModel;
    private boolean isFromRegistration;

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
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
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
        if(validation()==true)
        presenter.save(getData(), isFromRegistration);
    }

    @Override
    public void showProgress(boolean showProgress) {
        if (showProgress) {
            loader.setVisibility(View.VISIBLE);
        } else {
            loader.setVisibility(View.GONE);
        }
    }

    @Override
    public void navigateToEditHoroscopeDetails() {
        Intent intent = new Intent(this, EditHoroscopeDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain", "India", "Bangladesh", "Banglore"
    };

    private boolean validation() {
        if (editOccupation.getText().toString().equalsIgnoreCase("") || editOccupation.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention occupation", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention occupation");
            return false;
        }
        if (editOrganization.getText().toString().equalsIgnoreCase("") || editOrganization.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention organization", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention occupation");
            return false;
        }
        if (editWorkingCity.getText().toString().equalsIgnoreCase("") || editWorkingCity.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention working city", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention working city");
            return false;
        }
        if (editDesignation.getText().toString().equalsIgnoreCase("") || editDesignation.getText().toString().equalsIgnoreCase(null)) {
          //  Toast.makeText(EditServiceDetailsActivity.this, "Please mention designation", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention designation");
            return false;
        }
        if (editServiceStatus.getText().toString().equalsIgnoreCase("") || editServiceStatus.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention service status", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention service status");
            return false;
        }
        if (editExperience.getText().toString().equalsIgnoreCase("") || editExperience.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention experience", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention experience");
            return false;
        }
        if (editAnnualIncome.getText().toString().equalsIgnoreCase("") || editAnnualIncome.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditServiceDetailsActivity.this, "Please mention annual Income", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please mention annual Income");
            return false;
        }
        return true;
    }

    public void snackbar(View view,String errorMessage) {
        Snackbar snackbar = Snackbar
                .make(view, errorMessage, Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        snackbar.setActionTextColor(Color.BLACK);
        View sbView = snackbar.getView();
        sbView.setBackgroundResource(R.drawable.error_message);
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}

