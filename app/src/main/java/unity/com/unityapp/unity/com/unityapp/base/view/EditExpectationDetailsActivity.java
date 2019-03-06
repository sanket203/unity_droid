package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

    private int candidateId;
    int pos;
    private ExpectationsViewModel expectationDetailsViewModel;
    String minFeet,minInches,maxFeet,maxInches;

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
        }
        setSpinnerValue();
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
        minFeet = parts[0]; // 004
        String inches_ = parts[1];
        String[] parts_ = inches_.split("''");
        minInches = parts_[0];

         String maxHeight = expectationDetailsViewModel.getMaxHeight();
       /* String[] parts = minHeight.split("'");
        maxFeet = parts[0]; // 004
        String inches_ = parts[1];
        String[] parts_ = inches_.split("''");
        maxInches = parts_[0];*/

        if(maxHeight.equals(""))
        {
            spinnerMaxFeet.setSelection(0);
            spinnerMaxInches.setSelection(0);
        }
        if(minHeight.equals(""))
        {
            spinnerMinFeet.setSelection(0);
            spinnerMinInches.setSelection(0);
        }
     

        for (int i = 0; i < getResources().getStringArray(R.array.feet_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.feet_spinner)[i].equals("5")) {
                pos = i;

            }
        }
        spinnerMaxFeet.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.feet_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.feet_spinner)[i].equals("6")) {
                pos = i;

            }
        }
        spinnerMinFeet.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.inches_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.inches_spinner)[i].equals("11")) {
                pos = i;

            }
        }
        spinnerMinInches.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.inches_spinner).length; i++) {
            //if(getResources().getStringArray(R.array.feet_spinner)[i].equals(physicalDetailsViewModel.getFeet()))
            if (getResources().getStringArray(R.array.inches_spinner)[i].equals("10")) {
                pos = i;

            }
        }
        spinnerMaxInches.setSelection(pos);
    }
}

