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
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public class EditEducationDetailsActivity extends BaseActivity implements EditEducationDetailsView {

    @Inject
    EditEducationDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editDegree)
    EditText editDegree;

    @BindView(R.id.editPassingYear)
    EditText editPassingYear;

    @BindView(R.id.editCollege)
    EditText editCollege;

    @BindView(R.id.editUniversity)
    EditText editUniversity;

    @BindView(R.id.editStream)
    EditText editStream;

    @BindView(R.id.editRemark)
    EditText editRemark;

     @BindView(R.id.linearMain)
     LinearLayout linearMain;

    private int candidateId;

    private EducationalDetailsViewModel educationDetailsViewModel;
    private boolean isFromRegistration;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_educational_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Educational Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        educationDetailsViewModel = (EducationalDetailsViewModel) getIntent().getSerializableExtra("educationalDetailsViewModel");
        setData();
    }

    private void setData() {
        if (educationDetailsViewModel != null) {
            editDegree.setText(educationDetailsViewModel.getDegree());
            editPassingYear.setText(educationDetailsViewModel.getPassYear());
            editCollege.setText(educationDetailsViewModel.getCollege());
            editUniversity.setText(educationDetailsViewModel.getUniversity());
            editStream.setText(educationDetailsViewModel.getStream());
            editRemark.setText(educationDetailsViewModel.getRemarks());
        }

    }

    private EducationalDetailsViewModel getData() {
        EducationalDetailsViewModel educationDetailsViewModel = new EducationalDetailsViewModel();
        educationDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (editDegree.getText() != null) {
            educationDetailsViewModel.setDegree(editDegree.getText().toString());
        }
        if (editPassingYear.getText() != null) {
            educationDetailsViewModel.setDegree(editPassingYear.getText().toString());
        }
        if (editCollege.getText() != null) {
            educationDetailsViewModel.setDegree(editCollege.getText().toString());
        }
        if (editUniversity.getText() != null) {
            educationDetailsViewModel.setDegree(editUniversity.getText().toString());
        }
        if (editStream.getText() != null) {
            educationDetailsViewModel.setDegree(editStream.getText().toString());
        }
        if (editRemark.getText() != null) {
            educationDetailsViewModel.setDegree(editRemark.getText().toString());
        }
        return educationDetailsViewModel;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @OnClick(R.id.btn_save)
    void onSaveClick() {
        if(validation()==true)
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
        Intent intent = new Intent(this, EditServiceDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    private boolean validation() {
        if (editDegree.getText().toString().equalsIgnoreCase("") || editDegree.getText().toString().equalsIgnoreCase(null)) {
          //  Toast.makeText(EditEducationDetailsActivity.this, "Please mention degree", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please enter degree");
            return false;
        }
        if (editPassingYear.getText().toString().equalsIgnoreCase("") || editPassingYear.getText().toString().equalsIgnoreCase("null")) {
           // Toast.makeText(EditEducationDetailsActivity.this, "Please enter passing year", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please enter passing year");
            return false;
        }
        if (editCollege.getText().toString().equalsIgnoreCase("") || editCollege.getText().toString().equalsIgnoreCase("null")) {
           // Toast.makeText(EditEducationDetailsActivity.this, "Please enter college", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please enter college");
            return false;
        }
        if (editUniversity.getText().toString().equalsIgnoreCase("") || editUniversity.getText().toString().equalsIgnoreCase("null")) {
           // Toast.makeText(EditEducationDetailsActivity.this, "Please enter university", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please enter university");
            return false;
        }
        if (editStream.getText().toString().equalsIgnoreCase("") || editStream.getText().toString().equalsIgnoreCase("null")) {
           // Toast.makeText(EditEducationDetailsActivity.this, "Please enter Stream", Toast.LENGTH_SHORT);
            snackbar(linearMain,"Please enter Stream");
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

