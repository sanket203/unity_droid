package unity.com.unityapp.unity.com.unityapp.base.view;

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
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class EditPersonalDetailsActivity extends BaseActivity implements EditPersonalDetailsView {

    @Inject
    EditPersonalDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.first_name)
    EditText firstName;

    @BindView(R.id.middle_name)
    EditText middleName;

    @BindView(R.id.surname)
    EditText surName;

    @BindView(R.id.birth_date)
    EditText birthDate;

    @BindView(R.id.birth_time)
    EditText birthTime;

    @BindView(R.id.marrital_status)
    Spinner marritalStatus;

    @BindView(R.id.gender)
    Spinner gender;

    @BindView(R.id.about_me)
    EditText aboutMe;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    private int candidateId;

    private PersonalDetailsViewModel personalDetailsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Personal Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        personalDetailsViewModel = (PersonalDetailsViewModel) getIntent().getSerializableExtra("personalDetailsViewModel");
        setData();
    }

    private void setData() {
        aboutMe.setText(personalDetailsViewModel.getAboutMe());
        birthDate.setText(personalDetailsViewModel.getBirthDate());
        birthTime.setText(personalDetailsViewModel.getBirthTime());
        firstName.setText(personalDetailsViewModel.getFirstName());
        middleName.setText(personalDetailsViewModel.getMiddleName());
        surName.setText(personalDetailsViewModel.getLastName());
    }

    private PersonalDetailsViewModel getData() {
        PersonalDetailsViewModel personalDetailsViewModel = new PersonalDetailsViewModel();
        personalDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        personalDetailsViewModel.setAboutMe(aboutMe.getText().toString());
        personalDetailsViewModel.setBirthDate(birthDate.getText().toString());
        personalDetailsViewModel.setBirthTime(birthTime.getText().toString());
        personalDetailsViewModel.setFirstName(firstName.getText().toString());
        personalDetailsViewModel.setMiddleName(middleName.getText().toString());
        personalDetailsViewModel.setLastName(surName.getText().toString());
        personalDetailsViewModel.setMaritalStatus(marritalStatus.toString());
        personalDetailsViewModel.setGender(gender.toString());
        return personalDetailsViewModel;
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

