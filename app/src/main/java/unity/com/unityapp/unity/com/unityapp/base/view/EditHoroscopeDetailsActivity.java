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
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
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

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorCaste)
    TextView textErrorCaste;

    @BindView(R.id.textErrorSubCaste)
    TextView textErrorSubCaste;

    @BindView(R.id.textErrorShakha)
    TextView textErrorShakha;

    @BindView(R.id.textErrorUpshakha)
    TextView textErrorUpshakha;

    @BindView(R.id.textErrorGotra)
    TextView textErrorGotra;

    @BindView(R.id.textErrorRashi)
    TextView textErrorRashi;

    @BindView(R.id.textErrorGana)
    TextView textErrorGana;

    @BindView(R.id.textErrorNakshatra)
    TextView textErrorNakshatra;

    @BindView(R.id.textErrorNaadi)
    TextView textErrorNaadi;

    @BindView(R.id.textErrorCharan)
    TextView textErrorCharan;

    @BindView(R.id.textErrorSpectacles)
    TextView textErrorSpectacles;

    private int candidateId;
    int counter = 0;
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
        actionbar.setTitle("Edit Horoscope Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        horoscopeDetailsViewModel = (HoroscopeDetailsViewModel) getIntent().getSerializableExtra("horoscopeDetailsViewModel");
        if (horoscopeDetailsViewModel == null) {
            presenter.getHoroscopeDetails();
        } else {
            setData();
        }
    }

    private void setData() {
        if (horoscopeDetailsViewModel != null) {
            editCharan.setText(horoscopeDetailsViewModel.getCharan());
            editNaadi.setText(horoscopeDetailsViewModel.getNaadi());
            editRemark.setText(horoscopeDetailsViewModel.getRemarks());
            setSpinnerValue();
        }

    }

    private HoroscopeDetailsViewModel getData() {
        HoroscopeDetailsViewModel horoscopeDetailsViewModel = new HoroscopeDetailsViewModel();
        horoscopeDetailsViewModel.setId(this.horoscopeDetailsViewModel.getId());
        horoscopeDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
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
    public void navigateToEditDietDetails() {
        Intent intent = new Intent(this, EditDietDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void showHoroscopeDetails(HoroscopeDetailsViewModel viewModel) {
        horoscopeDetailsViewModel = viewModel;
        setData();
    }

    public void setSpinnerValue() {
        for (int i = 0; i < getResources().getStringArray(R.array.caste_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getCaste().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.caste_spinner)[i].equals(horoscopeDetailsViewModel.getCaste())) {
                pos = i;
            }
        }
        spinnerCaste.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.subcaste_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getSubCaste().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.subcaste_spinner)[i].equals(horoscopeDetailsViewModel.getSubCaste())) {
                pos = i;

            }
        }
        spinnerSubcaste.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.shakha_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getShakha().equals("")) {
                pos = 0;
            }
            if (getResources().getStringArray(R.array.shakha_spinner)[i].equals(horoscopeDetailsViewModel.getShakha())) {
                pos = i;

            }
        }
        spinnerShakha.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.upshakha_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getUpshakha().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.upshakha_spinner)[i].equals(horoscopeDetailsViewModel.getUpshakha())) {
                pos = i;

            }
        }
        spinnerUpshakha.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.gotra_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getGotra().equals("")) {
                pos = 0;
            }
            if (getResources().getStringArray(R.array.gotra_spinner)[i].equals(horoscopeDetailsViewModel.getGotra())) {
                pos = i;

            }
        }
        spinnerGotra.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.gana_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getGana().equals("")) {
                pos = 0;
            }
            if (getResources().getStringArray(R.array.gana_spinner)[i].equals(horoscopeDetailsViewModel.getGana())) {
                pos = i;

            }
        }
        spinnerGana.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.nakshatra_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getNakshatra().equals("")) {
                pos = 0;
            }
            if (getResources().getStringArray(R.array.nakshatra_spinner)[i].equals(horoscopeDetailsViewModel.getNakshatra())) {
                pos = i;

            }
        }
        spinnerNakshatra.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.rashi_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getRashi().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.rashi_spinner)[i].equals(horoscopeDetailsViewModel.getRashi())) {
                pos = i;

            }
        }
        spinnerRashi.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.spectacle_spinner).length; i++) {

            if (getResources().getStringArray(R.array.spectacle_spinner)[i].equals("Yes")) {
                pos = i;

            }
        }
        spinnerSpectacle.setSelection(pos);

    }

    private boolean validation() {
        if (spinnerCaste.getSelectedItem().toString().equalsIgnoreCase("") || spinnerCaste.getSelectedItem().toString().equalsIgnoreCase("Select Caste")) {
            textErrorCaste.setVisibility(View.VISIBLE);
            textErrorCaste.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorCaste.setVisibility(View.GONE);
        }
        if (spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("") || spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("Select Subcaste")) {
            textErrorSubCaste.setVisibility(View.VISIBLE);
            textErrorSubCaste.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorSubCaste.setVisibility(View.GONE);
        }
        if (spinnerShakha.getSelectedItem().toString().equalsIgnoreCase("") || spinnerShakha.getSelectedItem().toString().equalsIgnoreCase("Select Shakha")) {
            textErrorShakha.setVisibility(View.VISIBLE);
            textErrorShakha.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorShakha.setVisibility(View.GONE);
        }
        if (spinnerUpshakha.getSelectedItem().toString().equalsIgnoreCase("") || spinnerUpshakha.getSelectedItem().toString().equalsIgnoreCase("Select Upshakha")) {
            textErrorUpshakha.setVisibility(View.VISIBLE);
            textErrorUpshakha.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorUpshakha.setVisibility(View.GONE);
        }
        if (spinnerGotra.getSelectedItem().toString().equalsIgnoreCase("") || spinnerGotra.getSelectedItem().toString().equalsIgnoreCase("Select Gotra")) {
            textErrorGotra.setVisibility(View.VISIBLE);
            textErrorGotra.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorGotra.setVisibility(View.GONE);
        }
        if (spinnerRashi.getSelectedItem().toString().equalsIgnoreCase("") || spinnerRashi.getSelectedItem().toString().equalsIgnoreCase("Select Rashi")) {
            textErrorRashi.setVisibility(View.VISIBLE);
            textErrorRashi.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorRashi.setVisibility(View.GONE);
        }
        if (spinnerGana.getSelectedItem().toString().equalsIgnoreCase("") || spinnerGana.getSelectedItem().toString().equalsIgnoreCase("Select Gana")) {
            textErrorGana.setVisibility(View.VISIBLE);
            textErrorGana.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorGana.setVisibility(View.GONE);
        }
        if (spinnerNakshatra.getSelectedItem().toString().equalsIgnoreCase("") || spinnerNakshatra.getSelectedItem().toString().equalsIgnoreCase("Select Nakshatra")) {
            textErrorNakshatra.setVisibility(View.VISIBLE);
            textErrorNakshatra.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorNakshatra.setVisibility(View.GONE);
        }
        if (editNaadi.getText().toString().equalsIgnoreCase("") || editNaadi.getText().toString().equalsIgnoreCase(null)) {
            textErrorNaadi.setVisibility(View.VISIBLE);
            textErrorNaadi.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorNaadi.setVisibility(View.GONE);
        }
        if (editCharan.getText().toString().equalsIgnoreCase("") || editCharan.getText().toString().equalsIgnoreCase(null)) {
            textErrorCharan.setVisibility(View.VISIBLE);
            textErrorCharan.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorCharan.setVisibility(View.GONE);
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

