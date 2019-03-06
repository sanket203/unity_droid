package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
   // String feet="5";
  //  String inch="11";
    int pos;
    String feet = "",inches="";
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
    }

    private void setData() {
        if (physicalDetailsViewModel != null) {

            editWeight.setText(physicalDetailsViewModel.getWeight());
            editComplexion.setText(physicalDetailsViewModel.getComplexion());
            editBodyForm.setText(physicalDetailsViewModel.getBodyform());
            editOtherRemark.setText(physicalDetailsViewModel.getOtherRemarks());
            setSpinnerValue();
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

        String height = physicalDetailsViewModel.getHeight();
        String[] parts = height.split("'");
        feet = parts[0]; // 004
        String inches_ = parts[1];
        String[] parts_ = inches_.split("''");
        inches = parts_[0];

        if(height.equals(""))
        {
            spinnerFeet.setSelection(0);
            spinnerInches.setSelection(0);
        }
        for(int i = 0;i<getResources().getStringArray(R.array.feet_spinner).length;i++)
        {

            if(getResources().getStringArray(R.array.feet_spinner)[i].equals(feet))
            {
                pos = i;

            }
        }
        spinnerFeet.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.inches_spinner).length;i++)
        {
            if(getResources().getStringArray(R.array.inches_spinner)[i].equals(inches))
            {
                pos = i;

            }
        }
        spinnerInches.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.spectacle_spinner).length;i++)
        {
            if(physicalDetailsViewModel.getSpects().equals(""))
            {
                pos = 0;
            }
            else if(getResources().getStringArray(R.array.spectacle_spinner)[i].equals(physicalDetailsViewModel.getSpects()))
            {
                pos = i;


            }
        }
        spinnerSpectacle.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.blood_group).length;i++)
        {
            if(physicalDetailsViewModel.getBloodGroup().equals(""))
            {
                pos = 0;
            }
            else if(getResources().getStringArray(R.array.blood_group)[i].equals(physicalDetailsViewModel.getBloodGroup()))
            {
                pos = i;

            }
        }
        editBloodGroup.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.medical_surgery_spinner).length;i++)
        {
            if(physicalDetailsViewModel.getMedicalSurgary().equals(""))
            {
                pos = 0;
            }
            else if(getResources().getStringArray(R.array.medical_surgery_spinner)[i].equals(physicalDetailsViewModel.getMedicalSurgary()))
            {
                pos = i;

            }
        }
        spinnerMedicalSurgery.setSelection(pos);

        for(int i = 0;i<getResources().getStringArray(R.array.disability_spinner).length;i++)
        {
            if(physicalDetailsViewModel.getDisability().equals(""))
            {
                pos = 0;
            }
            else if(getResources().getStringArray(R.array.disability_spinner)[i].equals(physicalDetailsViewModel.getDisability()))
            {
                pos = i;

            }
        }
        spinnerDisability.setSelection(pos);
    }

}

