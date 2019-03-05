package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
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

    @BindView(R.id.editComplexion)
    EditText editComplexion;

    @BindView(R.id.editBodyForm)
    EditText editBodyForm;

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


    private int candidateId;

    private PhysicalDetailsViewModel physicalDetailsViewModel;
    String feet="5";
    String inch="11";
    int pos;
    int pos_;
    private boolean isFromRegistration;

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
        setData();
        setSpinnerValue();
    }

    private void setData() {
        if (physicalDetailsViewModel != null) {

            editWeight.setText(physicalDetailsViewModel.getWeight());
            editComplexion.setText(physicalDetailsViewModel.getComplexion());
            editBodyForm.setText(physicalDetailsViewModel.getBodyform());
            editOtherRemark.setText(physicalDetailsViewModel.getOtherRemarks());
        }
    }

    private PhysicalDetailsViewModel getData() {
        PhysicalDetailsViewModel physicalDetailsViewModel = new PhysicalDetailsViewModel();
        physicalDetailsViewModel.setCandidateId(candidateId);

        if (editWeight.getText() != null) {
            physicalDetailsViewModel.setFeet(editWeight.getText().toString());
        }
        if (editComplexion.getText() != null) {
            physicalDetailsViewModel.setFeet(editComplexion.getText().toString());
        }
        if (editBodyForm.getText() != null) {
            physicalDetailsViewModel.setFeet(editBodyForm.getText().toString());
        }
        if (editOtherRemark.getText() != null) {
            physicalDetailsViewModel.setFeet(editOtherRemark.getText().toString());
        }

        physicalDetailsViewModel.setSpects(spinnerSpectacle.getSelectedItem().toString());
        physicalDetailsViewModel.setDisability(spinnerDisability.getSelectedItem().toString());
        physicalDetailsViewModel.setMedicalSurgary(spinnerMedicalSurgery.getSelectedItem().toString());
        physicalDetailsViewModel.setBloodGroup(editBloodGroup.getSelectedItem().toString());
        physicalDetailsViewModel.setHeight(spinnerFeet.getSelectedItem().toString()+"'"+spinnerInches.getSelectedItem()+"''");

        return physicalDetailsViewModel;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @OnClick(R.id.btn_save)
    void onSaveClick() {
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
    public void navigateToEditEducationalDetails() {
        Intent intent = new Intent(this, EditEducationDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    public void setSpinnerValue()
    {
        for(int i = 0;i<getResources().getStringArray(R.array.feet_spinner).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if(getResources().getStringArray(R.array.feet_spinner)[i].equals("5"))
            {
                pos = i;

            }
        }
        spinnerFeet.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.inches_spinner).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if(getResources().getStringArray(R.array.inches_spinner)[i].equals("11"))
            {
                pos = i;

            }
        }
        spinnerInches.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.spectacle_spinner).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if(getResources().getStringArray(R.array.spectacle_spinner)[i].equals("No"))
            {
                pos = i;

            }
        }
        spinnerSpectacle.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.blood_group).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if(getResources().getStringArray(R.array.blood_group)[i].equals("O(+ve)"))
            {
                pos = i;

            }
        }
        editBloodGroup.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.medical_surgery_spinner).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if(getResources().getStringArray(R.array.medical_surgery_spinner)[i].equals("No"))
            {
                pos = i;

            }
        }
        spinnerMedicalSurgery.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.disability_spinner).length;i++)
        {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if(getResources().getStringArray(R.array.disability_spinner)[i].equals("No"))
            {
                pos = i;

            }
        }
        spinnerDisability.setSelection(pos);
    }

}

