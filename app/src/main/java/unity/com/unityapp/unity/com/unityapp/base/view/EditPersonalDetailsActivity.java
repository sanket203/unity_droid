package unity.com.unityapp.unity.com.unityapp.base.view;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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

    @BindView(R.id.birth_place)
    EditText birthPlace;

    @BindView(R.id.hobbies)
    EditText hobbies;

    @BindView(R.id.marrital_status)
    Spinner marritalStatus;

    @BindView(R.id.gender)
    Spinner gender;

    @BindView(R.id.about_me)
    EditText aboutMe;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.textErrorFirstName)
    TextView textErrorFirstName;

    @BindView(R.id.textErrorMiddleNAme)
    TextView textErrorMiddleNAme;

    @BindView(R.id.textErrorSurname)
    TextView textErrorSurname;

    @BindView(R.id.textErrorBirthdate)
    TextView textErrorBirthdate;

    @BindView(R.id.textErrorBirthTime)
    TextView textErrorBirthTime;

    @BindView(R.id.textErrorBirthGender)
    TextView textErrorBirthGender;

    @BindView(R.id.textErrorBirthMarritalStatus)
    TextView textErrorBirthMarritalStatus;

    @BindView(R.id.textErrorBirthPlace)
    TextView textErrorBirthPlace;

    @BindView(R.id.textErrorHobbies)
    TextView textErrorHobbies;

    @BindView(R.id.profile_image)
    CircleImageView profileImage;


    private int candidateId;
    int counter = 0;
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
        if (personalDetailsViewModel == null) {
            presenter.getPersonalDetails();
        } else {
            setData();
        }

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
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        birthDate.setText(sdf.format(myCalendar.getTime()));
    }

    private void timepicker() {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(EditPersonalDetailsActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                birthTime.setText(selectedHour + ":" + selectedMinute);
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
            hobbies.setText(personalDetailsViewModel.getHobbies());
            birthPlace.setText(personalDetailsViewModel.getBirthPlace());
            setmarritalStatus(personalDetailsViewModel.getMaritalStatus());
            setGender(personalDetailsViewModel.getGender());

            Picasso.get()
                    .load(UserInfo.getUserInfo().getImageUrl())
                    .fit()
                    .into(profileImage);
        }

    }

    private void setGender(String genderValue) {
        for (int i = 0; i < getResources().getStringArray(R.array.gender).length; i++) {
            if (genderValue == null || genderValue.equals("")) {
                gender.setSelection(0);
                break;
            } else if (getResources().getStringArray(R.array.gender)[i].equalsIgnoreCase(genderValue)) {
                gender.setSelection(i);
                break;
            }
        }
    }

    private void setmarritalStatus(String maritalStatus) {
        for (int i = 0; i < getResources().getStringArray(R.array.marital_status_list).length; i++) {
            if (maritalStatus == null || maritalStatus.equals("")) {
                marritalStatus.setSelection(0);
                break;
            } else if (getResources().getStringArray(R.array.marital_status_list)[i].equalsIgnoreCase(maritalStatus)) {
                marritalStatus.setSelection(i);
                break;
            }
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
        if (birthPlace.getText() != null)
            personalDetailsViewModel.setBirthPlace(birthPlace.getText().toString());
        if (hobbies.getText() != null)
            personalDetailsViewModel.setHobbies(hobbies.getText().toString());
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
        if (validation() == true)
            presenter.save(getData(), isFromRegistration);
    }

    @Override
    public void showProgress(boolean showProgress) {
        if (showProgress) {
            loader.setVisibility(View.VISIBLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } else {
            loader.setVisibility(View.GONE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        snackbar(linearMain, message);
    }

    @Override
    public void navigateToEditPhysicalDetailsActivity() {
        Intent intent = new Intent(this, EditPhysicalDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showPersonalDetails(PersonalDetailsViewModel viewModel) {
        this.personalDetailsViewModel = viewModel;
        setData();
    }

    private boolean validation() {
        if (firstName.getText().toString().equalsIgnoreCase("") || firstName.getText().toString().equalsIgnoreCase(null)) {
            textErrorFirstName.setVisibility(View.VISIBLE);
            textErrorFirstName.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorFirstName.setVisibility(View.GONE);
        }
        if (middleName.getText().toString().equalsIgnoreCase("") || middleName.getText().toString().equalsIgnoreCase(null)) {
            textErrorMiddleNAme.setVisibility(View.VISIBLE);
            textErrorMiddleNAme.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorMiddleNAme.setVisibility(View.GONE);
        }

        if (surName.getText().toString().equalsIgnoreCase("") || surName.getText().toString().equalsIgnoreCase(null)) {
            textErrorSurname.setVisibility(View.VISIBLE);
            textErrorSurname.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorSurname.setVisibility(View.GONE);
        }
        if (birthDate.getText().toString().equalsIgnoreCase("") || birthDate.getText().toString().equalsIgnoreCase(null)) {
            textErrorBirthdate.setVisibility(View.VISIBLE);
            textErrorBirthdate.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBirthdate.setVisibility(View.GONE);
        }
        if (birthTime.getText().toString().equalsIgnoreCase("") || birthTime.getText().toString().equalsIgnoreCase(null)) {
            textErrorBirthTime.setVisibility(View.VISIBLE);
            textErrorBirthTime.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBirthTime.setVisibility(View.GONE);
        }
        if (marritalStatus.getSelectedItem().toString().equalsIgnoreCase("") || marritalStatus.getSelectedItem().toString().equalsIgnoreCase("Select Marital Status")) {
            textErrorBirthMarritalStatus.setVisibility(View.VISIBLE);
            textErrorBirthMarritalStatus.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBirthMarritalStatus.setVisibility(View.GONE);
        }
        if (gender.getSelectedItem().toString().equalsIgnoreCase("") || gender.getSelectedItem().toString().equalsIgnoreCase("Select Gender")) {
            textErrorBirthGender.setVisibility(View.VISIBLE);
            textErrorBirthGender.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBirthGender.setVisibility(View.GONE);
        }

        if (birthPlace.getText().toString().equalsIgnoreCase("") || birthPlace.getText().toString().equalsIgnoreCase(null)) {
            textErrorBirthPlace.setVisibility(View.VISIBLE);
            textErrorBirthPlace.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorBirthPlace.setVisibility(View.GONE);
        }

        if (hobbies.getText().toString().equalsIgnoreCase("") || hobbies.getText().toString().equalsIgnoreCase(null)) {
            textErrorHobbies.setVisibility(View.VISIBLE);
            textErrorHobbies.setText(getString(R.string.empty_field));
            return false;
        } else {
            textErrorHobbies.setVisibility(View.GONE);
        }
        return true;
    }

    public void snackbar(View view, String errorMessage) {

        if (counter == 3) {
            Snackbar snackbar = Snackbar
                    .make(view, "Please Try After Some Time", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("DISMISS", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    snackbar.dismiss();
                }
            });
            snackbar.setActionTextColor(Color.BLACK);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.drawable.error_message);
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();

        } else {
            Snackbar snackbar = Snackbar
                    .make(view, errorMessage, Snackbar.LENGTH_INDEFINITE)
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

    @OnClick(R.id.profile_image)
    public void uploadImage() {
        requestAppPermissions();
        final Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
//to get image and videos, I used a */"
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, 1);


        //userinfo.getInfo.getUserInfo
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            MultipartBody.Part image = null;
            Uri selectedImageUri = data.getData();
            String imagepath = getPath(selectedImageUri);
            File imageFile = new File(imagepath);
            RequestBody requestFile =
                    RequestBody.create(
                            MediaType.parse(getContentResolver().getType(selectedImageUri)),
                            imageFile

                    );

            RequestBody body = RequestBody.create(MediaType.parse("text/plain"), "12");

            image = MultipartBody.Part.createFormData("files", imageFile.getName(), requestFile);
            presenter.uploadImage(image, body);
        }


    }

    public String getPath(Uri uri) {

        String realPath;
        // SDK < API11
        if (Build.VERSION.SDK_INT < 11) {
            realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(this, uri);
        }

        // SDK >= 11 && SDK < 19
        else if (Build.VERSION.SDK_INT < 19) {
            realPath = RealPathUtil.getRealPathFromURI_API11to18(this, uri);
        }

        // SDK > 19 (Android 4.4)
        else {
            realPath = RealPathUtil.getRealPathFromURI_API19(this, uri);
        }
        System.out.println("Image Path : " + realPath);


        return realPath;
    }

    private void requestAppPermissions() {
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return;
        }

        if (hasReadPermissions() && hasWritePermissions()) {
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, 0); // your request code
    }

    private boolean hasReadPermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    private boolean hasWritePermissions() {
        return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }
}

