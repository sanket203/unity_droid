package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class EditPhysicalDetailsActivity extends BaseActivity implements EditPhysicalDetailsView {

    @Inject
    EditPhysicalDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.spinnerFeet)
    Spinner spinnerFeet;

    @BindView(R.id.spinnerInches)
    Spinner spinnerInches;

    @BindView(R.id.editWeight)
    EditText editWeight;

    @BindView(R.id.spinnerComplexion)
    Spinner spinnerComplexion;

    @BindView(R.id.spinnerBodyForm)
    Spinner spinnerBodyForm;

    @BindView(R.id.spinnerSpectacle)
    Spinner spinnerSpectacle;

    @BindView(R.id.editBloodGroup)
    Spinner editBloodGroup;

    @BindView(R.id.spinnerMedicalSurgery)
    Spinner spinnerMedicalSurgery;

    @BindView(R.id.spinnerDisability)
    Spinner spinnerDisability;

    @BindView(R.id.editOtherRemark)
    EditText editOtherRemark;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorHeight)
    TextView textErrorHeight;

    @BindView(R.id.textErrorWeight)
    TextView textErrorWeight;

    @BindView(R.id.textErrorComplexion)
    TextView textErrorComplexion;

    @BindView(R.id.textErrorBodyform)
    TextView textErrorBodyform;

    @BindView(R.id.textErrorSpectacles)
    TextView textErrorSpectacles;

    @BindView(R.id.textErrorBloodGroup)
    TextView textErrorBloodGroup;

    @BindView(R.id.textErrorMedicalSurgery)
    TextView textErrorMedicalSurgery;

    @BindView(R.id.textErrorDisability)
    TextView textErrorDisability;

    private int candidateId;

    private PhysicalDetailsViewModel physicalDetailsViewModel;
    // String feet="5";
    //  String inch="11";
    int pos;
    String feet = "", inches = "";
    private boolean isFromRegistration;
    int counter = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_physical_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Physical Details");
        candidateId = getIntent().getIntExtra("candidateId", 0);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        physicalDetailsViewModel = (PhysicalDetailsViewModel) getIntent().getSerializableExtra("physicalDetailsViewModel");
        if (physicalDetailsViewModel == null) {
            presenter.getPhysicalDetails();
        } else {
            setData();
        }

    }

    private void setData() {
        if (physicalDetailsViewModel != null) {
            editWeight.setText(physicalDetailsViewModel.getWeight());
           // editComplexion.setText(physicalDetailsViewModel.getComplexion());
          //  editBodyForm.setText(physicalDetailsViewModel.getBodyform());
            editOtherRemark.setText(physicalDetailsViewModel.getOtherRemarks());
            setSpinnerValue();
        }
    }

    private PhysicalDetailsViewModel getData() {
        PhysicalDetailsViewModel physicalDetailsViewModel = new PhysicalDetailsViewModel();
        if (this.physicalDetailsViewModel != null)
            physicalDetailsViewModel.setId(this.physicalDetailsViewModel.getId());
        physicalDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());

        if (editWeight.getText() != null) {
            physicalDetailsViewModel.setWeight(editWeight.getText().toString());
        }

        if (editOtherRemark.getText() != null) {
            physicalDetailsViewModel.setOtherRemarks(editOtherRemark.getText().toString());
        }

        physicalDetailsViewModel.setComplexion(spinnerComplexion.getSelectedItem().toString());
        physicalDetailsViewModel.setSpects(spinnerSpectacle.getSelectedItem().toString());
        physicalDetailsViewModel.setDisability(spinnerDisability.getSelectedItem().toString());
        physicalDetailsViewModel.setMedicalSurgary(spinnerMedicalSurgery.getSelectedItem().toString());
        physicalDetailsViewModel.setBloodGroup(editBloodGroup.getSelectedItem().toString());
        physicalDetailsViewModel.setHeight(spinnerFeet.getSelectedItem().toString() + "'" + spinnerInches.getSelectedItem() + "''");
        physicalDetailsViewModel.setBodyform(spinnerBodyForm.getSelectedItem().toString());

        return physicalDetailsViewModel;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @OnClick(R.id.btn_save)
    void onSaveClick() {
        if (validation() == true)
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
    public void showErrorMessage(String message) {
        snackbar(linearMain, message);
    }

    @Override
    public void navigateToEditEducationalDetails() {
        Intent intent = new Intent(this, EditEducationDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void showPhysicalDetails(PhysicalDetailsViewModel viewModel) {
        physicalDetailsViewModel = viewModel;
        setData();
    }

    public void setSpinnerValue() {

        String height = physicalDetailsViewModel.getHeight();
        String[] parts = height.split("'");
        feet = parts[0]; // 004
        String inches_ = parts[1];
        String[] parts_ = inches_.split("''");
        inches = parts_[0];

        if (height.equals("")) {
            spinnerFeet.setSelection(0);
            spinnerInches.setSelection(0);
        }
        for (int i = 0; i < getResources().getStringArray(R.array.feet_spinner).length; i++) {

            if (getResources().getStringArray(R.array.feet_spinner)[i].equals(feet)) {
                pos = i;

            }
        }
        spinnerFeet.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.inches_spinner).length; i++) {
            if (getResources().getStringArray(R.array.inches_spinner)[i].equals(inches)) {
                pos = i;

            }
        }
        spinnerInches.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.spectacle_spinner).length; i++) {
            if (physicalDetailsViewModel.getSpects() == null || physicalDetailsViewModel.getSpects().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.spectacle_spinner)[i].equals(physicalDetailsViewModel.getSpects())) {
                pos = i;


            }
        }
        spinnerSpectacle.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.blood_group).length; i++) {
            if (physicalDetailsViewModel.getSpects() == null || physicalDetailsViewModel.getBloodGroup().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.blood_group)[i].equals(physicalDetailsViewModel.getBloodGroup())) {
                pos = i;

            }
        }
        editBloodGroup.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.bodyform_spinner).length; i++) {
            if (physicalDetailsViewModel.getBodyform() == null || physicalDetailsViewModel.getBodyform().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.bodyform_spinner)[i].equals(physicalDetailsViewModel.getBodyform())) {
                pos = i;

            }
        }
        spinnerBodyForm.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.complexion_spinner).length; i++) {
            if (physicalDetailsViewModel.getComplexion()== null || physicalDetailsViewModel.getComplexion().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.complexion_spinner)[i].equals(physicalDetailsViewModel.getComplexion())) {
                pos = i;

            }
        }
        spinnerComplexion.setSelection(pos);


        for (int i = 0; i < getResources().getStringArray(R.array.medical_surgery_spinner).length; i++) {
            if (physicalDetailsViewModel.getSpects() == null || physicalDetailsViewModel.getMedicalSurgary().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.medical_surgery_spinner)[i].equals(physicalDetailsViewModel.getMedicalSurgary())) {
                pos = i;

            }
        }
        spinnerMedicalSurgery.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.disability_spinner).length; i++) {
            if (physicalDetailsViewModel.getSpects() == null || physicalDetailsViewModel.getDisability().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.disability_spinner)[i].equals(physicalDetailsViewModel.getDisability())) {
                pos = i;

            }
        }
        spinnerDisability.setSelection(pos);
    }

    private boolean validation() {
        if (spinnerFeet.getSelectedItem().toString().equalsIgnoreCase("") || spinnerFeet.getSelectedItem().toString().equalsIgnoreCase("Feet")) {
            textErrorHeight.setVisibility(View.VISIBLE);
            textErrorHeight.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorHeight.setVisibility(View.GONE);
        }

        if (spinnerInches.getSelectedItem().toString().equalsIgnoreCase("") || spinnerInches.getSelectedItem().toString().equalsIgnoreCase("Inches")) {
            textErrorHeight.setVisibility(View.VISIBLE);
            textErrorHeight.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorHeight.setVisibility(View.GONE);
        }

        if (editWeight.getText().toString().equalsIgnoreCase("") || editWeight.getText().toString().equalsIgnoreCase(null)) {
            textErrorWeight.setVisibility(View.VISIBLE);
            textErrorWeight.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorWeight.setVisibility(View.GONE);
        }

        if (spinnerComplexion.getSelectedItem().toString().equalsIgnoreCase("") || spinnerComplexion.getSelectedItem().toString().equalsIgnoreCase(null)|| spinnerComplexion.getSelectedItem().toString().equalsIgnoreCase("Select Complexion") ){
            textErrorComplexion.setVisibility(View.VISIBLE);
            textErrorComplexion.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorComplexion.setVisibility(View.GONE);
        }

        if (spinnerBodyForm.getSelectedItem().toString().equalsIgnoreCase("") || spinnerBodyForm.getSelectedItem().toString().equalsIgnoreCase(null)|| spinnerBodyForm.getSelectedItem().toString().equalsIgnoreCase("Select Body Form")) {
            textErrorBodyform.setVisibility(View.VISIBLE);
            textErrorBodyform.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBodyform.setVisibility(View.GONE);
        }

        if (editBloodGroup.getSelectedItem().toString().equalsIgnoreCase("") || editBloodGroup.getSelectedItem().toString().equalsIgnoreCase("Select Blood Group")) {
            textErrorBloodGroup.setVisibility(View.VISIBLE);
            textErrorBloodGroup.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBloodGroup.setVisibility(View.GONE);
        }

        if (spinnerMedicalSurgery.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMedicalSurgery.getSelectedItem().toString().equalsIgnoreCase("Medical Surgery")) {
            textErrorMedicalSurgery.setVisibility(View.VISIBLE);
            textErrorMedicalSurgery.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMedicalSurgery.setVisibility(View.GONE);
        }

        if (spinnerDisability.getSelectedItem().toString().equalsIgnoreCase("") || spinnerDisability.getSelectedItem().toString().equalsIgnoreCase("Disability")) {
            textErrorDisability.setVisibility(View.VISIBLE);
            textErrorDisability.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorDisability.setVisibility(View.GONE);
        }
        return true;
    }

    public void snackbar(View view, String errorMessage) {

        if (counter == 3) {
            Snackbar snackbar = Snackbar
                    .make(view, "Please Try After Some Time", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.BLACK);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.drawable.error_message);
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();

        } else {
            Snackbar snackbar = Snackbar
                    .make(view, errorMessage, Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            counter = counter + 1;
                            presenter.save(getData(), isFromRegistration);
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

}

