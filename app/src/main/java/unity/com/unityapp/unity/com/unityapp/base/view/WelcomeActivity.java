package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

public class WelcomeActivity extends BaseActivity implements WelcomeView {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);

    }

    @OnClick(R.id.btn_go)
    public void navigateToPersonalDetailsActivity(){
        Intent intent = new Intent(this, EditPersonalDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }
}
