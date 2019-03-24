package unity.com.unityapp.unity.com.unityapp.base.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class ShowContactDetailsActivity extends BaseActivity implements ShowContactDetailsView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    ShowContactDetailsPresenter presenter;

    @BindView(R.id.mainLayout)
    View mainLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_contact_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        presenter.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Contact Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        presenter.getContactDetails(String.valueOf(UserInfo.getUserInfo().getCandidateId()), getIntent().getStringExtra("candidateId"), getIntent().getBooleanExtra("isAddressExist", false));
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showContactDetails(AddressViewModel addressViewModel) {

    }

    @Override
    public void showError(String message) {
        snackbar(mainLayout, message);
    }

    @Override
    public void showUpgradeMessage(String message) {

        snackbar(mainLayout, message);

    }

    public void snackbar(View view, String errorMessage) {


        Snackbar snackbar = Snackbar
                .make(view, errorMessage, Snackbar.LENGTH_INDEFINITE);
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
    }


    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
