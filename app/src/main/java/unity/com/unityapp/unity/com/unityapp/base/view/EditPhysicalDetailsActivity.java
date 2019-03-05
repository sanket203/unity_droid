package unity.com.unityapp.unity.com.unityapp.base.view;

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

    @BindView(R.id.editfeet)
    EditText editFeet;

    @BindView(R.id.editInches)
    EditText editInches;

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

    @BindView(R.id.spinnerFeet)
    Spinner spinnerFeet;

    private int candidateId;

    private PhysicalDetailsViewModel physicalDetailsViewModel;
    String feet="5";
    int pos;

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
        physicalDetailsViewModel = (PhysicalDetailsViewModel) getIntent().getSerializableExtra("physicalDetailsViewModel");

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.feet_spinner));
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinnerFeet.setAdapter(aa);

        spinnerFeet.setSelection(pos);
        setData();
    }

    private void setData() {
        if (physicalDetailsViewModel != null) {
            editFeet.setText(physicalDetailsViewModel.getFeet());
            editInches.setText(physicalDetailsViewModel.getInches());
            editWeight.setText(physicalDetailsViewModel.getWeight());
            editComplexion.setText(physicalDetailsViewModel.getComplexion());
            editBodyForm.setText(physicalDetailsViewModel.getBodyform());
            editOtherRemark.setText(physicalDetailsViewModel.getOtherRemarks());
            for(int i = 0;i<getResources().getStringArray(R.array.feet_spinner).length;i++)
            {
                if(getResources().getStringArray(R.array.feet_spinner)[i].equals(feet))
                {
                    pos = i;
                }
            }
        }
    }

    private PhysicalDetailsViewModel getData() {
        PhysicalDetailsViewModel physicalDetailsViewModel = new PhysicalDetailsViewModel();
        physicalDetailsViewModel.setCandidateId(candidateId);
        if (editFeet.getText() != null){
            physicalDetailsViewModel.setFeet(editFeet.getText().toString());
        }
        if (editInches.getText() != null){
            physicalDetailsViewModel.setFeet(editInches.getText().toString());
        }
        if (editWeight.getText() != null){
            physicalDetailsViewModel.setFeet(editWeight.getText().toString());
        }
        if (editComplexion.getText() != null){
            physicalDetailsViewModel.setFeet(editComplexion.getText().toString());
        }
        if (editBodyForm.getText() != null){
            physicalDetailsViewModel.setFeet(editBodyForm.getText().toString());
        }
        if (editOtherRemark.getText() != null){
            physicalDetailsViewModel.setFeet(editOtherRemark.getText().toString());
        }
        if (editFeet.getText() != null && editInches.getText()!=null){
            physicalDetailsViewModel.setHeight(editFeet.getText().toString()+editInches.getText().toString());
        }
        physicalDetailsViewModel.setSpects(spinnerSpectacle.getSelectedItem().toString());
        physicalDetailsViewModel.setDisability(spinnerDisability.getSelectedItem().toString());
        physicalDetailsViewModel.setMedicalSurgary(spinnerMedicalSurgery.getSelectedItem().toString());
        physicalDetailsViewModel.setBloodGroup(editBloodGroup.getSelectedItem().toString());

        return physicalDetailsViewModel;
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

}

