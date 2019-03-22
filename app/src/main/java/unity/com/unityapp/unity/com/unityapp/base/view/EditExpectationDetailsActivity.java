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
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public class EditExpectationDetailsActivity extends BaseActivity implements EditExpectationDetailsView {

    @Inject
    EditExpectationDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editMinAge)
    EditText editMinAge;

    @BindView(R.id.editMaxAge)
    EditText editMaxAge;

    @BindView(R.id.editEducation)
    EditText editEducation;

    @BindView(R.id.editIncome)
    EditText editIncome;

    @BindView(R.id.editWorkingLocation)
    AutoCompleteTextView editWorkingLocation;

    @BindView(R.id.editOtherExp)
    EditText editOtherExp;

    @BindView(R.id.spinnerMinFeet)
    Spinner spinnerMinFeet;

    @BindView(R.id.spinnerMaxFeet)
    Spinner spinnerMaxFeet;

    @BindView(R.id.spinnerMinInches)
    Spinner spinnerMinInches;

    @BindView(R.id.spinnerMaxInches)
    Spinner spinnerMaxInches;

    @BindView(R.id.spinnerSubcaste)
    Spinner spinnerSubcaste;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorMinHeight)
    TextView textErrorMinHeight;

    @BindView(R.id.textErrorMaxHeight)
    TextView textErrorMaxHeight;

    @BindView(R.id.textErrorMinAge)
    TextView textErrorMinAge;

    @BindView(R.id.textErrorMaxAge)
    TextView textErrorMaxAge;

    @BindView(R.id.textErrorSubcaste)
    TextView textErrorSubcaste;

    @BindView(R.id.textErrorEducation)
    TextView textErrorEducation;

    @BindView(R.id.textErrorIncome)
    TextView textErrorIncome;

    @BindView(R.id.textErrorLocation)
    TextView textErrorLocation;

    @BindView(R.id.textErrorOtherExp)
    TextView textErrorOtherExp;

    private int candidateId;
    int pos;
    int counter = 0;
    private ExpectationsViewModel expectationDetailsViewModel;
    String minFeet, minInches, maxFeet, maxInches;
    private boolean isFromRegistration;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_expectation);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Expectation Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
        expectationDetailsViewModel = (ExpectationsViewModel) getIntent().getSerializableExtra("expectationDetailsViewModel");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        editWorkingLocation.setAdapter(adapter);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        if (expectationDetailsViewModel == null) {
            presenter.getExpectationDetails();
        } else {
            setData();
        }

    }

    private void setData() {
        if (expectationDetailsViewModel != null) {
            editMinAge.setText(expectationDetailsViewModel.getMinAge());
            editMaxAge.setText(expectationDetailsViewModel.getMaxAge());
            editIncome.setText(expectationDetailsViewModel.getPackageLimit());
            editEducation.setText(expectationDetailsViewModel.getDegree());
            editWorkingLocation.setText(expectationDetailsViewModel.getWorkingLocation());
            editOtherExp.setText(expectationDetailsViewModel.getOther());
            setSpinnerValue();
        }

    }

    private ExpectationsViewModel getData() {
        ExpectationsViewModel expectationDetailsViewModel = new ExpectationsViewModel();
        expectationDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (this.expectationDetailsViewModel != null)
            expectationDetailsViewModel.setId(this.expectationDetailsViewModel.getId());
        if (editEducation.getText() != null) {
            expectationDetailsViewModel.setDegree(editEducation.getText().toString());
        }
        if (editIncome.getText() != null) {
            expectationDetailsViewModel.setPackageLimit(editIncome.getText().toString());
        }
        if (editWorkingLocation.getText() != null) {
            expectationDetailsViewModel.setWorkingLocation(editWorkingLocation.getText().toString());
        }
        if (editOtherExp.getText() != null) {
            expectationDetailsViewModel.setOther(editOtherExp.getText().toString());
        }
        if (spinnerMaxFeet.getSelectedItem() != null) {
            expectationDetailsViewModel.setMaxFeet(spinnerMaxFeet.getSelectedItem().toString());
        }
        if (spinnerMinFeet.getSelectedItem() != null) {
            expectationDetailsViewModel.setMinFeet(spinnerMinFeet.getSelectedItem().toString());
        }
        if (spinnerMinInches.getSelectedItem() != null) {
            expectationDetailsViewModel.setMinInch(spinnerMinInches.getSelectedItem().toString());
        }
        if (spinnerMaxInches.getSelectedItem() != null) {
            expectationDetailsViewModel.setMaxInch(spinnerMaxInches.getSelectedItem().toString());
        }
        return expectationDetailsViewModel;
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
    public void navigateToFamilyDetails() {
        Intent intent = new Intent(this, EditFamilyDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void showExpectationDetails(ExpectationsViewModel viewModel) {
        expectationDetailsViewModel = viewModel;
        setData();
    }

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain"
    };

    public void setSpinnerValue() {


        String minHeight = expectationDetailsViewModel.getMinHeight();
        String[] parts = minHeight.split("'");
        minFeet = parts[0];
        String inches_ = parts[1];
        String[] parts_ = inches_.split("''");
        minInches = parts_[0];

        String maxHeight = expectationDetailsViewModel.getMaxHeight();
        String[] partsMax = minHeight.split("'");
        maxFeet = partsMax[0];
        String inchesMax_ = partsMax[1];
        String[] partsMax_ = inchesMax_.split("''");
        maxInches = partsMax_[0];

        if (maxHeight.equals("")) {
            spinnerMaxFeet.setSelection(0);
            spinnerMaxInches.setSelection(0);
        }
        if (minHeight.equals("")) {
            spinnerMinFeet.setSelection(0);
            spinnerMinInches.setSelection(0);
        }


        for (int i = 0; i < getResources().getStringArray(R.array.feet_spinner).length; i++) {
            if (getResources().getStringArray(R.array.feet_spinner)[i].equals(maxFeet)) {
                pos = i;

            }
        }
        spinnerMaxFeet.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.feet_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.feet_spinner)[i].equals(minFeet)) {
                pos = i;

            }
        }
        spinnerMinFeet.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.inches_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.inches_spinner)[i].equals(minInches)) {
                pos = i;

            }
        }
        spinnerMinInches.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.inches_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.inches_spinner)[i].equals(maxInches)) {
                pos = i;

            }
        }
        spinnerMaxInches.setSelection(pos);
    }

    private boolean validation() {
        if (spinnerMinFeet.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMinFeet.getSelectedItem().toString().equalsIgnoreCase("Feet")) {
            textErrorMinHeight.setVisibility(View.VISIBLE);
            textErrorMinHeight.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMinHeight.setVisibility(View.GONE);
        }
        if (spinnerMaxFeet.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMaxFeet.getSelectedItem().toString().equalsIgnoreCase("Feet")) {
            textErrorMaxHeight.setVisibility(View.VISIBLE);
            textErrorMaxHeight.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorMaxHeight.setVisibility(View.GONE);
        }
        if (spinnerMinInches.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMinInches.getSelectedItem().toString().equalsIgnoreCase("Inches")) {
            textErrorMinHeight.setVisibility(View.VISIBLE);
            textErrorMinHeight.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMinHeight.setVisibility(View.GONE);
        }
        if (spinnerMaxInches.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMaxInches.getSelectedItem().toString().equalsIgnoreCase("Inches")) {
            textErrorMaxHeight.setVisibility(View.VISIBLE);
            textErrorMaxHeight.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorMaxHeight.setVisibility(View.GONE);
        }
        if (spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("") || spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("Select Subcaste")) {
            textErrorSubcaste.setVisibility(View.VISIBLE);
            textErrorSubcaste.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorSubcaste.setVisibility(View.GONE);
        }
        if (editMinAge.getText().toString().equalsIgnoreCase("") || editMinAge.getText().toString().equalsIgnoreCase(null)) {
            textErrorMinAge.setVisibility(View.VISIBLE);
            textErrorMinAge.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorMinAge.setVisibility(View.GONE);
        }
        if (editMaxAge.getText().toString().equalsIgnoreCase("") || editMaxAge.getText().toString().equalsIgnoreCase(null)) {
            textErrorMaxAge.setVisibility(View.VISIBLE);
            textErrorMaxAge.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorMaxAge.setVisibility(View.GONE);
        }
        if (editEducation.getText().toString().equalsIgnoreCase("") || editEducation.getText().toString().equalsIgnoreCase(null)) {
            textErrorEducation.setVisibility(View.VISIBLE);
            textErrorEducation.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorEducation.setVisibility(View.GONE);
        }
        if (editIncome.getText().toString().equalsIgnoreCase("") || editIncome.getText().toString().equalsIgnoreCase(null)) {
            textErrorIncome.setVisibility(View.VISIBLE);
            textErrorIncome.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorIncome.setVisibility(View.GONE);
        }
        if (editWorkingLocation.getText().toString().equalsIgnoreCase("") || editWorkingLocation.getText().toString().equalsIgnoreCase(null)) {
            textErrorLocation.setVisibility(View.VISIBLE);
            textErrorLocation.setText(getString(R.string.empty_field));
            return false;
        }
        {
            textErrorLocation.setVisibility(View.GONE);
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

