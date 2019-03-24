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

    @BindView(R.id.spinnerSubcaste)
    Spinner spinnerSubcaste;

    @BindView(R.id.spinnerShakha)
    Spinner spinnerShakha;

    @BindView(R.id.editUpshakha)
    EditText editUpshakha;

    @BindView(R.id.editGotra)
    EditText editGotra;

    @BindView(R.id.spinnerRashi)
    Spinner spinnerRashi;

    @BindView(R.id.spinnerGana)
    Spinner spinnerGana;

    @BindView(R.id.spinnerNakshatra)
    Spinner spinnerNakshatra;

    @BindView(R.id.spinnerMangal)
    Spinner spinnerMangal;

    @BindView(R.id.spinnerNadi)
    Spinner spinnerNaadi;

    @BindView(R.id.spinnerCharan)
    Spinner spinnerCharan;

    @BindView(R.id.editRemark)
    EditText editRemark;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorSubCaste)
    TextView textErrorSubCaste;

    @BindView(R.id.textErrorShakha)
    TextView textErrorShakha;

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

    @BindView(R.id.textErrorMangal)
    TextView textErrorMangal;

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
            editUpshakha.setText(horoscopeDetailsViewModel.getUpshakha());
            editRemark.setText(horoscopeDetailsViewModel.getRemarks());
            editGotra.setText(horoscopeDetailsViewModel.getGotra());
            setSpinnerValue();
        }

    }

    private HoroscopeDetailsViewModel getData() {
        HoroscopeDetailsViewModel horoscopeDetailsViewModel = new HoroscopeDetailsViewModel();
        if (this.horoscopeDetailsViewModel != null)
            horoscopeDetailsViewModel.setId(this.horoscopeDetailsViewModel.getId());
        horoscopeDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (spinnerNaadi.getSelectedItem() != null) {
            horoscopeDetailsViewModel.setNaadi(spinnerNaadi.getSelectedItem().toString().split("\\(")[0]);
        }
        if (spinnerCharan.getSelectedItem() != null) {
            horoscopeDetailsViewModel.setCharan(spinnerCharan.getSelectedItem().toString());
        }
        if (editRemark.getText() != null) {
            horoscopeDetailsViewModel.setRemarks(editRemark.getText().toString());
        }
        if (spinnerSubcaste.getSelectedItem() != null)
            horoscopeDetailsViewModel.setSubCaste(spinnerSubcaste.getSelectedItem().toString());

        if (spinnerShakha.getSelectedItem() != null)
            horoscopeDetailsViewModel.setShakha(spinnerShakha.getSelectedItem().toString());

        if (editUpshakha.getText() != null)
            horoscopeDetailsViewModel.setUpshakha(editUpshakha.getText().toString());

        if (editGotra.getText() != null)
            horoscopeDetailsViewModel.setGotra(editGotra.getText().toString());

        if (spinnerRashi.getSelectedItem() != null)
            horoscopeDetailsViewModel.setRashi(spinnerRashi.getSelectedItem().toString().split("\\(")[0]);

        if (spinnerGana.getSelectedItem() != null)
            horoscopeDetailsViewModel.setGana(spinnerGana.getSelectedItem().toString());

        if (spinnerNakshatra.getSelectedItem() != null)
            horoscopeDetailsViewModel.setNakshatra(spinnerNakshatra.getSelectedItem().toString().split("\\(")[0]);

        if (spinnerMangal.getSelectedItem() != null)
            horoscopeDetailsViewModel.setMangal(spinnerMangal.getSelectedItem().toString().split("\\(")[0]);

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
            if (getResources().getStringArray(R.array.nakshatra_spinner)[i].contains(horoscopeDetailsViewModel.getNakshatra())) {
                pos = i;

            }
        }
        spinnerNakshatra.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.rashi_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getRashi().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.rashi_spinner)[i].contains(horoscopeDetailsViewModel.getRashi())) {
                pos = i;

            }
        }
        spinnerRashi.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.mangal_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getRashi().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.mangal_spinner)[i].contains(horoscopeDetailsViewModel.getMangal())) {
                pos = i;

            }
        }
        spinnerMangal.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.spinner_naadi).length; i++) {
            if (horoscopeDetailsViewModel.getRashi().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.spinner_naadi)[i].contains(horoscopeDetailsViewModel.getNaadi())) {
                pos = i;

            }
        }
        spinnerNaadi.setSelection(pos);

        for (int i = 0; i < getResources().getStringArray(R.array.charan_spinner).length; i++) {
            if (horoscopeDetailsViewModel.getRashi().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.charan_spinner)[i].equals(horoscopeDetailsViewModel.getCharan())) {
                pos = i;

            }
        }
        spinnerCharan.setSelection(pos);


    }

    private boolean validation() {
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

        if (editGotra.getText().toString().equalsIgnoreCase("")) {
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
        if (spinnerNaadi.getSelectedItem().toString().equalsIgnoreCase("") || spinnerNaadi.getSelectedItem().toString().equalsIgnoreCase("Select Naadi")) {
            textErrorNaadi.setVisibility(View.VISIBLE);
            textErrorNaadi.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorNaadi.setVisibility(View.GONE);
        }
        if (spinnerCharan.getSelectedItem().toString().equalsIgnoreCase("") || spinnerCharan.getSelectedItem().toString().equalsIgnoreCase("Select Charan")) {
            textErrorCharan.setVisibility(View.VISIBLE);
            textErrorCharan.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorCharan.setVisibility(View.GONE);
        }

        if (spinnerMangal.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMangal.getSelectedItem().toString().equalsIgnoreCase("Select Mangal")) {
            textErrorMangal.setVisibility(View.VISIBLE);
            textErrorMangal.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMangal.setVisibility(View.GONE);
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

