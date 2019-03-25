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
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public class EditContactDetailsActivity extends BaseActivity implements EditContactDetailsView {

    @Inject
    EditContactDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editAddress)
    EditText editAddress;

    @BindView(R.id.editContactNo)
    EditText editContactNumber;

    @BindView(R.id.editAlternateNo)
    EditText editAlternateContact;

    private int candidateId;

    private AddressViewModel addressViewModel;
    private boolean isFromRegistration;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Contact Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        addressViewModel = (AddressViewModel) getIntent().getSerializableExtra("addressViewModel");
        if (addressViewModel == null) {
            presenter.getContactDetails();
        } else {
            setData();
        }
    }

    private void setData() {
        if (addressViewModel != null) {
            editAddress.setText(addressViewModel.getAddress());
            editContactNumber.setText(String.valueOf(addressViewModel.getContactNumber()));
            editAlternateContact.setText(String.valueOf(addressViewModel.getAlternateNumber()));
        }

    }

    private AddressViewModel getData() {
        AddressViewModel addressViewModel = new AddressViewModel();
        if (this.addressViewModel != null)
            addressViewModel.setId(this.addressViewModel.getId());
        addressViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (editAddress.getText() != null) {
            addressViewModel.setAddress(editAddress.getText().toString());
        }
        if (editContactNumber.getText() != null) {
            addressViewModel.setContactNumber(Long.parseLong(editContactNumber.getText().toString()));
        }
        if (editAlternateContact.getText() != null) {
            addressViewModel.setAlternateNumber(Long.parseLong(editAlternateContact.getText().toString()));
        }

        return addressViewModel;
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
    public void navigateToEditServiceDetails() {

    }


    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showContactDetails(AddressViewModel viewModel) {
        addressViewModel = viewModel;
        setData();
    }

    @Override
    public void navigateToRegistrationDone() {
        Intent intent = new Intent(this, RegistrationDoneActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);

    }

    private boolean validation() {

        return true;
    }

    public void snackbar(View view, String errorMessage) {
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

