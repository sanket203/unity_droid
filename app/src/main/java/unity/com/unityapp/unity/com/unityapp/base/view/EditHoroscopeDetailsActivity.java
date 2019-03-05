package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public class EditHoroscopeDetailsActivity extends BaseActivity implements EditHoroscopeDetailsView {

    @Inject
    EditHoroscopeDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.spinnerCaste)
    Spinner spinnerCaste;

    @BindView(R.id.spinnerSubcaste)
    Spinner spinnerSubcaste;

    @BindView(R.id.spinnerShakha)
    Spinner spinnerShakha;

    @BindView(R.id.spinnerUpshakha)
    Spinner spinnerUpshakha;

    @BindView(R.id.spinnerGotra)
    Spinner spinnerGotra;

    @BindView(R.id.spinnerRashi)
    Spinner spinnerRashi;

    @BindView(R.id.spinnerGana)
    Spinner spinnerGana;

    @BindView(R.id.spinnerNakshatra)
    Spinner spinnerNakshatra;

    @BindView(R.id.spinnerSpectacle)
    Spinner spinnerSpectacle;

    @BindView(R.id.editNaadi)
    EditText editNaadi;

    @BindView(R.id.editCharan)
    EditText editCharan;

    @BindView(R.id.editRemark)
    EditText editRemark;

    private int candidateId;

    private HoroscopeDetailsViewModel horoscopeDetailsViewModel;
    private boolean isFromRegistration;
    int pos;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_horoscope_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Personal Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        horoscopeDetailsViewModel = (HoroscopeDetailsViewModel) getIntent().getSerializableExtra("horoscopeDetailsViewModel");
        setData();
    }

    private void setData() {
        if(horoscopeDetailsViewModel!=null)
        {
            editCharan.setText(horoscopeDetailsViewModel.getCharan());
            editNaadi.setText(horoscopeDetailsViewModel.getNaadi());
            editRemark.setText(horoscopeDetailsViewModel.getRemarks());
        }
        setSpinnerValue();
    }

    private HoroscopeDetailsViewModel getData() {
        HoroscopeDetailsViewModel horoscopeDetailsViewModel = new HoroscopeDetailsViewModel();
        horoscopeDetailsViewModel.setCandidateId(candidateId);
        if (editNaadi.getText() != null) {
            horoscopeDetailsViewModel.setNaadi(editNaadi.getText().toString());
        }
        if (editCharan.getText() != null) {
            horoscopeDetailsViewModel.setCharan(editCharan.getText().toString());
        }
        if (editRemark.getText() != null) {
            horoscopeDetailsViewModel.setCharan(editRemark.getText().toString());
        }
        /*if (spinnerSpectacle.getSelectedItem() != null)
            horoscopeDetailsViewModel.setSpects(spinnerSpectacle.getSelectedItem().toString());*/
        if (spinnerCaste.getSelectedItem() != null)
            horoscopeDetailsViewModel.setCaste(spinnerSpectacle.getSelectedItem().toString());

        if (spinnerSubcaste.getSelectedItem() != null)
            horoscopeDetailsViewModel.setSubCaste(spinnerSubcaste.getSelectedItem().toString());

        if (spinnerShakha.getSelectedItem() != null)
            horoscopeDetailsViewModel.setShakha(spinnerShakha.getSelectedItem().toString());

        if (spinnerUpshakha.getSelectedItem() != null)
            horoscopeDetailsViewModel.setUpshakha(spinnerUpshakha.getSelectedItem().toString());

        if (spinnerGotra.getSelectedItem() != null)
            horoscopeDetailsViewModel.setGotra(spinnerGotra.getSelectedItem().toString());

        if (spinnerRashi.getSelectedItem() != null)
            horoscopeDetailsViewModel.setRashi(spinnerRashi.getSelectedItem().toString());

        if (spinnerGana.getSelectedItem() != null)
            horoscopeDetailsViewModel.setGana(spinnerGana.getSelectedItem().toString());

         if (spinnerNakshatra.getSelectedItem() != null)
            horoscopeDetailsViewModel.setNakshatra(spinnerNakshatra.getSelectedItem().toString());

        return horoscopeDetailsViewModel;
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
    public void navigateToEditDietDetails() {
        Intent intent = new Intent(this, EditDietDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    public void setSpinnerValue() {
        for (int i = 0; i < getResources().getStringArray(R.array.caste_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.caste_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerCaste.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.subcaste_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.subcaste_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerSubcaste.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.shakha_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.shakha_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerShakha.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.upshakha_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.upshakha_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerUpshakha.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.gotra_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.gotra_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerGotra.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.gana_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.gana_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerGana.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.nakshatra_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.nakshatra_spinner)[i].equals("Deshsta")) {
                pos = i;

            }
        }
        spinnerNakshatra.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.rashi_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.rashi_spinner)[i].equals("Leo")) {
                pos = i;

            }
        }
        spinnerRashi.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.spectacle_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getInches()))
            if (getResources().getStringArray(R.array.spectacle_spinner)[i].equals("Yes")) {
                pos = i;

            }
        }
        spinnerSpectacle.setSelection(pos);

    }
}

