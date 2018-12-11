package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileDetailsActivity extends BaseActivity implements RecentProfileDetailsView {

    @Inject
    RecentProfileDetailsPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbind();
    }
}
