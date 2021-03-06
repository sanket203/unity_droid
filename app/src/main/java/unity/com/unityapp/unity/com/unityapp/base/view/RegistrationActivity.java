package unity.com.unityapp.unity.com.unityapp.base.view;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RegisterUserViewModel;

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    @Inject
    RegistrationPresenter presenter;

    @BindView(R.id.first_name)
    EditText firstName;

    @BindView(R.id.middle_name)
    EditText middleName;

    @BindView(R.id.surname)
    EditText surName;

    @BindView(R.id.mobile_number)
    EditText mobileNumber;

    @BindView(R.id.birth_date)
    EditText birthDate;


    @BindView(R.id.password)
    EditText password;

    final Calendar myCalendar = Calendar.getInstance();

    private RegisterUserViewModel registerUserViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        presenter.bind(this);

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
                new DatePickerDialog(RegistrationActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        birthDate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @OnClick(R.id.btn_register)
    public void onRegisterClicked() {
        registerUserViewModel = new RegisterUserViewModel();
        registerUserViewModel.setBirthDate(birthDate.getText().toString());
        registerUserViewModel.setFirstName(firstName.getText().toString());
        registerUserViewModel.setMiddleName(middleName.getText().toString());
        registerUserViewModel.setLastName(surName.getText().toString());
        registerUserViewModel.setContact(Long.parseLong(mobileNumber.getText().toString()));
        registerUserViewModel.setPassword(password.getText().toString());
        presenter.register(registerUserViewModel);
    }

    @OnClick(R.id.login_link)
    public void onLoginLinkClicked() {

    }

    void navigateToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void navigateToWelcomeScreen() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }


}
