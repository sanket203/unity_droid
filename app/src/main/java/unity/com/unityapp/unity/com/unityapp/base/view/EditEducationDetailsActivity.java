package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

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

    private int candidateId;

    private EducationalDetailsViewModel educationDetailsViewModel;

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
        candidateId = getIntent().getIntExtra("candidateId", 0);
        educationDetailsViewModel = (EducationalDetailsViewModel) getIntent().getSerializableExtra("educationDetailsViewModel");
        setData();
    }

    private void setData() {
        if(educationDetailsViewModel!=null)
        {
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
        educationDetailsViewModel.setCandidateId(candidateId);
        if(editDegree.getText()!=null)
        {
            educationDetailsViewModel.setDegree(editDegree.getText().toString());
        }
        if(editPassingYear.getText()!=null)
        {
            educationDetailsViewModel.setDegree(editPassingYear.getText().toString());
        }
        if(editCollege.getText()!=null)
        {
            educationDetailsViewModel.setDegree(editCollege.getText().toString());
        }
        if(editUniversity.getText()!=null)
        {
            educationDetailsViewModel.setDegree(editUniversity.getText().toString());
        }
        if(editStream.getText()!=null)
        {
            educationDetailsViewModel.setDegree(editStream.getText().toString());
        }
        if(editRemark.getText()!=null)
        {
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

