package unity.com.unityapp.unity.com.unityapp.base.view;

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
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
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

    private int candidateId;
    int pos;
    private ExpectationsViewModel expectationDetailsViewModel;
    String minFeet, minInches, maxFeet, maxInches;

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
        setData();
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
        expectationDetailsViewModel.setCandidateId(candidateId);
        if (editEducation.getText() != null) {
            expectationDetailsViewModel.setDegree(editEducation.getText().toString());
            expectationDetailsViewModel.setPackageLimit(editIncome.getText().toString());
            expectationDetailsViewModel.setWorkingLocation(editWorkingLocation.getText().toString());
            expectationDetailsViewModel.setOther(editOtherExp.getText().toString());
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
        if(validation()==true)
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
         //   Toast.makeText(EditExpectationDetailsActivity.this, "Please select Minimum Height in Feet", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please select Minimum Height in Feet");
            return false;
        }
        if (spinnerMaxFeet.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMaxFeet.getSelectedItem().toString().equalsIgnoreCase("Feet")) {
           // Toast.makeText(EditExpectationDetailsActivity.this, "Please select Maximum Height in Feet", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please select Maximum Height in Feet");
            return false;
        }
        if (spinnerMinInches.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMinInches.getSelectedItem().toString().equalsIgnoreCase("Inches")) {
          //  Toast.makeText(EditExpectationDetailsActivity.this, "Please select Minimum Height in Inches", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please select Minimum Height in Inches");
            return false;
        }
        if (spinnerMaxInches.getSelectedItem().toString().equalsIgnoreCase("") || spinnerMaxInches.getSelectedItem().toString().equalsIgnoreCase("Inches")) {
            //Toast.makeText(EditExpectationDetailsActivity.this, "Please select Maximum Height in Inches", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please select Minimum Height in Inches");
            return false;
        }
        if (spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("") || spinnerSubcaste.getSelectedItem().toString().equalsIgnoreCase("Select Subcaste")) {
          //  Toast.makeText(EditExpectationDetailsActivity.this, "Please select Subcaste", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please select Subcaste");
            return false;
        }
        if (editMinAge.getText().toString().equalsIgnoreCase("") || editMinAge.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditExpectationDetailsActivity.this, "Please mention Minimum age", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please mention Minimum age");
            return false;
        }
        if (editMaxAge.getText().toString().equalsIgnoreCase("") || editMaxAge.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditExpectationDetailsActivity.this, "Please mention Maximum age", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please mention Maximum age");
            return false;
        }
        if (editEducation.getText().toString().equalsIgnoreCase("") || editEducation.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditExpectationDetailsActivity.this, "Please mention Education", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please mention Education");
            return false;
        }
        if (editIncome.getText().toString().equalsIgnoreCase("") || editIncome.getText().toString().equalsIgnoreCase(null)) {
          //  Toast.makeText(EditExpectationDetailsActivity.this, "Please mention Income", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please mention Income");
            return false;
        }
        if (editWorkingLocation.getText().toString().equalsIgnoreCase("") || editWorkingLocation.getText().toString().equalsIgnoreCase(null)) {
           // Toast.makeText(EditExpectationDetailsActivity.this, "Please mention Income", Toast.LENGTH_SHORT).show();
            snackbar(linearMain,"Please mention Income");
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

