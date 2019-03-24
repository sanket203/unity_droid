package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

public class RegistrationDoneActivity extends BaseActivity implements RegistrationDoneView {


    @Inject
    RegistrationDonePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        presenter.bind(this);
    }

    @OnClick(R.id.btn_go)
    public void navigateToPersonalDetailsActivity() {
        presenter.registerDone(String.valueOf(UserInfo.getUserInfo().getCandidateId()), "registered");
    }

    @Override
    public void navigateToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();

    }
}
