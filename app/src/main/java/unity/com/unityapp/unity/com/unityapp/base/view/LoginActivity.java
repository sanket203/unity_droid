package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 19/12/18.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.email)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.error_email)
    TextView emailError;

    @BindView(R.id.error_password)
    TextView passwordError;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.linearMain)
    RelativeLayout linearMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        presenter.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick() {
        if (validate()) {
            presenter.loginUser(email.getText().toString(), password.getText().toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @Override
    public void loginAndNavigateToHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressBar(boolean showProgress) {
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
    public void navigateToRegistration() {
        Intent intent = new Intent(this, EditPersonalDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    @OnClick(R.id.register_link)
    public void onRegisterLinkClicked() {
        navigateToRegistrationScreen();
    }

    void navigateToRegistrationScreen() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    private boolean validate() {
        if (email.getText().toString().equalsIgnoreCase("") || email.getText().toString().equalsIgnoreCase(null)) {
            emailError.setVisibility(View.VISIBLE);
            emailError.setText(getString(R.string.empty_field));
            return false;
        } else {
            emailError.setVisibility(View.GONE);
        }
        if (password.getText().toString().equalsIgnoreCase("") || password.getText().toString().equalsIgnoreCase(null)) {
            passwordError.setVisibility(View.VISIBLE);
            passwordError.setText(getString(R.string.empty_field));
            return false;
        } else {
            passwordError.setVisibility(View.GONE);
        }
        return true;
    }

    @Override
    public void showErrorMessage(String message) {
        snackbar(linearMain, message);
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
}
