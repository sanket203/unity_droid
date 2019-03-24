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
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class EditFamilyDetailsActivity extends BaseActivity implements EditFamilyDetailsView {

    @Inject
    EditFamilyDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editFatherName)
    EditText editFatherName;

    @BindView(R.id.editFatherDetail)
    EditText editFatherDetail;

    @BindView(R.id.editMotherName)
    EditText editMotherName;

    @BindView(R.id.editMotherDetail)
    EditText editMotherDetail;

    @BindView(R.id.editBrother)
    EditText editBrother;

    @BindView(R.id.editSister)
    EditText editSister;

    @BindView(R.id.editBrotherDetail)
    EditText editBrotherDetail;

    @BindView(R.id.editSisterDetail)
    EditText editSisterDetail;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorFatherName)
    TextView textErrorFatherName;

    @BindView(R.id.textErrorFatherDetail)
    TextView textErrorFatherDetail;

    @BindView(R.id.textErrorMotherName)
    TextView textErrorMotherName;

    @BindView(R.id.textErrorMotherDetail)
    TextView textErrorMotherDetail;

    @BindView(R.id.textErrorBrother)
    TextView textErrorBrother;

    @BindView(R.id.textErrorSister)
    TextView textErrorSister;

    private int candidateId;
    int counter = 0;
    private FamilyDetailsViewModel familyDetailsViewModel;
    private boolean isFromRegistration;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_family_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Family Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        familyDetailsViewModel = (FamilyDetailsViewModel) getIntent().getSerializableExtra("familyDetailsViewModel");
        if (familyDetailsViewModel == null) {
            presenter.getFamilyDetails();
        } else {
            setData();
        }

    }

    private void setData() {
        if (familyDetailsViewModel != null) {
            editFatherName.setText(familyDetailsViewModel.getFather());
            editFatherDetail.setText(familyDetailsViewModel.getFatherDescription());
            editMotherName.setText(familyDetailsViewModel.getMother());
            editMotherDetail.setText(familyDetailsViewModel.getMotherDescription());
            editBrother.setText(familyDetailsViewModel.getBrothers());
            editSister.setText(familyDetailsViewModel.getSisters());
            editBrotherDetail.setText(familyDetailsViewModel.getBrotherDescription());
            editSisterDetail.setText(familyDetailsViewModel.getSisterDescription());
        }
    }

    private FamilyDetailsViewModel getData() {
        FamilyDetailsViewModel familyDetailsViewModel = new FamilyDetailsViewModel();
        familyDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (this.familyDetailsViewModel != null)
            familyDetailsViewModel.setId(this.familyDetailsViewModel.getId());
        if (editFatherName.getText() != null) {
            familyDetailsViewModel.setFather(editFatherName.getText().toString());
        }
        if (editFatherDetail.getText() != null) {
            familyDetailsViewModel.setFatherDescription(editFatherDetail.getText().toString());
        }
        if (editMotherName.getText() != null) {
            familyDetailsViewModel.setMother(editMotherName.getText().toString());
        }
        if (editMotherDetail.getText() != null) {
            familyDetailsViewModel.setMotherDescription(editMotherDetail.getText().toString());
        }
        if (editBrother.getText() != null) {
            familyDetailsViewModel.setBrothers(editBrother.getText().toString());
        }
        if (editBrotherDetail.getText() != null) {
            familyDetailsViewModel.setBrotherDescription(editBrotherDetail.getText().toString());
        }
        if (editSister.getText() != null) {
            familyDetailsViewModel.setSisters(editSister.getText().toString());
        }
        if (editSisterDetail.getText() != null) {
            familyDetailsViewModel.setSisterDescription(editSisterDetail.getText().toString());
        }
        return familyDetailsViewModel;
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
    public void showFamilyDetails(FamilyDetailsViewModel viewModel) {
        familyDetailsViewModel = viewModel;
        setData();
    }

    @Override
    public void navigateToContactDetails() {
        Intent intent = new Intent(this, EditContactDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    private boolean validation() {
        if (editFatherName.getText().toString().equalsIgnoreCase("") || editFatherName.getText().toString().equalsIgnoreCase("null")) {
            textErrorFatherName.setVisibility(View.VISIBLE);
            textErrorFatherName.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorFatherName.setVisibility(View.GONE);
        }
        if (editMotherName.getText().toString().equalsIgnoreCase("") || editMotherName.getText().toString().equalsIgnoreCase("null")) {
            textErrorMotherName.setVisibility(View.VISIBLE);
            textErrorMotherName.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMotherName.setVisibility(View.GONE);
        }
        if (editBrother.getText().toString().equalsIgnoreCase("") || editBrother.getText().toString().equalsIgnoreCase("null")) {
            textErrorBrother.setVisibility(View.VISIBLE);
            textErrorBrother.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBrother.setVisibility(View.GONE);
        }
        if (editSister.getText().toString().equalsIgnoreCase("") || editSister.getText().toString().equalsIgnoreCase("null")) {
            textErrorSister.setVisibility(View.VISIBLE);
            textErrorSister.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorSister.setVisibility(View.GONE);
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

