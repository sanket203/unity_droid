package unity.com.unityapp.unity.com.unityapp.base.view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

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
    private boolean isFromRegistration;
    final Calendar myCalendar = Calendar.getInstance();

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
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        personalDetailsViewModel = (PersonalDetailsViewModel) getIntent().getSerializableExtra("personalDetailsViewModel");
        setData();

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        birthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditPersonalDetailsActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        birthTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timepicker();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        birthDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void timepicker()
    {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(EditPersonalDetailsActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                birthTime.setText( selectedHour + ":" + selectedMinute);
            }
        }, hour, minute, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void setData() {
        if (personalDetailsViewModel != null) {
            aboutMe.setText(personalDetailsViewModel.getAboutMe());
            birthDate.setText(personalDetailsViewModel.getBirthDate());
            birthTime.setText(personalDetailsViewModel.getBirthTime());
            firstName.setText(personalDetailsViewModel.getFirstName());
            middleName.setText(personalDetailsViewModel.getMiddleName());
            surName.setText(personalDetailsViewModel.getLastName());
        }
    }

    private PersonalDetailsViewModel getData() {
        PersonalDetailsViewModel personalDetailsViewModel = new PersonalDetailsViewModel();
        personalDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (aboutMe.getText() != null)
            personalDetailsViewModel.setAboutMe(aboutMe.getText().toString());
        if (birthDate.getText() != null)
            personalDetailsViewModel.setBirthDate(birthDate.getText().toString());
        if (birthTime.getText() != null)
            personalDetailsViewModel.setBirthTime(birthTime.getText().toString());
        if (firstName.getText() != null)
            personalDetailsViewModel.setFirstName(firstName.getText().toString());
        if (middleName.getText() != null)
            personalDetailsViewModel.setMiddleName(middleName.getText().toString());
        if (surName.getText() != null)
            personalDetailsViewModel.setLastName(surName.getText().toString());
        personalDetailsViewModel.setMaritalStatus(marritalStatus.getSelectedItem().toString());
        personalDetailsViewModel.setGender(gender.getSelectedItem().toString());
        return personalDetailsViewModel;
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
    public void navigateToEditPhysicalDetailsActivity() {
        Intent intent = new Intent(this, EditPhysicalDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }
}

