package unity.com.unityapp.unity.com.unityapp.base.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

    @BindView(R.id.btn_call1)
    ImageView imageCall1;

    @BindView(R.id.btn_call2)
    ImageView imageCall2;

    @BindView(R.id.address)
    TextView address;

    @BindView(R.id.contact1)
    TextView contact1;

    @BindView(R.id.contact2)
    TextView contact2;

    AddressViewModel addressViewModel;

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
        imageCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPermissionGranted("1");
            }
        });

        imageCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPermissionGranted("2");
            }
        });

    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showContactDetails(AddressViewModel viewModel) {
        addressViewModel = viewModel;
        address.setText(viewModel.getAddress());
        contact1.setText(String.valueOf(viewModel.getContactNumber()));
        contact2.setText(String.valueOf(viewModel.getAlternateNumber()));

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

    public boolean isPermissionGranted(String contactNumber) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG", "Permission is granted");
                if (contactNumber.equalsIgnoreCase("1"))
                    call_action(contact1.getText().toString());
                else
                    call_action(contact2.getText().toString());
                return true;
            } else {

                if (contactNumber.equalsIgnoreCase("1")) {
                    Log.v("TAG", "Permission is revoked");
                    ActivityCompat.requestPermissions(ShowContactDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else if (contactNumber.equalsIgnoreCase("2")) {
                    Log.v("TAG", "Permission is revoked");
                    ActivityCompat.requestPermissions(ShowContactDetailsActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 2);

                }
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG", "Permission is granted");
            if (contactNumber.equalsIgnoreCase("1"))
                call_action(contact1.getText().toString());
            else
                call_action(contact2.getText().toString());
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {

            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action(contact1.getText().toString());
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case 2: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    call_action(contact2.getText().toString());
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public void call_action(String number) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + number));
        startActivity(callIntent);
    }
}
