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
import android.widget.Spinner;
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
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;

public class EditDietDetailsActivity extends BaseActivity implements EditDietDetailsView {

    @Inject
    EditDietDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_bar)
    ProgressBar loader;

    @BindView(R.id.editDietType)
    Spinner editDietType;

    @BindView(R.id.editDrink)
    Spinner editDrink;

    @BindView(R.id.editSmoke)
    Spinner editSmoke;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    @BindView(R.id.textErrorDietType)
    TextView textErrorDietType;

    @BindView(R.id.textErrorDrink)
    TextView textErrorDrink;

    @BindView(R.id.textErrorSmoke)
    TextView textErrorSmoke;

    private int candidateId;
    int pos;
    private DietDetailsViewModel dietDetailsViewModel;

    private boolean isFromRegistration;

    private void setData() {
        if (dietDetailsViewModel != null) {
            //  editDietType.setText(dietDetailsViewModel.getDietType());
           /* if (dietDetailsViewModel.getDrink().equalsIgnoreCase("Yes"))
                editDrink.setSelection(0);
            if (dietDetailsViewModel.getDrink().equalsIgnoreCase("Yes"))
                editSmoke.setSelection(0);*/
            setSpinnerValue();
        }

    }

    private DietDetailsViewModel getData() {
        DietDetailsViewModel dietDetailsViewModel = new DietDetailsViewModel();
        dietDetailsViewModel.setCandidateId(UserInfo.getUserInfo().getCandidateId());
        if (editDietType.getSelectedItem() != null)
            dietDetailsViewModel.setDietType(editDietType.getSelectedItem().toString());
        if (editDrink.getSelectedItem() != null)
            dietDetailsViewModel.setDrink(editDrink.getSelectedItem().toString());
        if (editSmoke.getSelectedItem() != null)
            dietDetailsViewModel.setSmoke(editSmoke.getSelectedItem().toString());
        return dietDetailsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diet_detail);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Edit Diet Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        isFromRegistration = getIntent().getBooleanExtra("isFromRegistration", false);
        dietDetailsViewModel = (DietDetailsViewModel) getIntent().getSerializableExtra("dietDetailsViewModel");
        setData();
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
    public void showErrorMessage(String message) {
        snackbar(linearMain,message);
    }

    @Override
    public void navigateToExpectationDetails() {
        Intent intent = new Intent(this, EditExpectationDetailsActivity.class);
        intent.putExtra("isFromRegistration", true);
        startActivity(intent);
    }

    public void setSpinnerValue() {
        for (int i = 0; i < getResources().getStringArray(R.array.diet_type_spinner).length; i++) {
            if (dietDetailsViewModel.getDietType().equals("")) {
                pos = 0;
            } else if (getResources().getStringArray(R.array.diet_type_spinner)[i].equals(dietDetailsViewModel.getDietType())) {
                pos = i;

            }
        }
        editDietType.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.spinner_drink).length; i++) {
            if (dietDetailsViewModel.getDrink().equals("")) {
                pos = 0;
            }
            else if (getResources().getStringArray(R.array.spinner_drink)[i].equals(dietDetailsViewModel.getDrink())) {
                pos = i;

            }
        }
        editDrink.setSelection(pos);
        for (int i = 0; i < getResources().getStringArray(R.array.spinner_smoke).length; i++) {
            if (dietDetailsViewModel.getSmoke().equals(""))
            {
                pos = 0;
            }
            else if (getResources().getStringArray(R.array.spinner_smoke)[i].equals(dietDetailsViewModel.getSmoke())) {
                pos = i;

            }
        }
        editSmoke.setSelection(pos);
    }

    private boolean validation()
    {
        if (editDietType.getSelectedItem().toString().equalsIgnoreCase("") || editDietType.getSelectedItem().toString().equalsIgnoreCase("Diet Type")) {
            textErrorDietType.setVisibility(View.VISIBLE);
            textErrorDietType.setText(getString(R.string.empty_field));
            return false;
        }else {textErrorDietType.setVisibility(View.GONE);}
        if (editDrink.getSelectedItem().toString().equalsIgnoreCase("") || editDrink.getSelectedItem().toString().equalsIgnoreCase("Drink(Alcoholic)")) {
            textErrorDrink.setVisibility(View.VISIBLE);
            textErrorDrink.setText(getString(R.string.empty_field));
            return false;
        }else {textErrorDrink.setVisibility(View.GONE);}
        if (editSmoke.getSelectedItem().toString().equalsIgnoreCase("") || editSmoke.getSelectedItem().toString().equalsIgnoreCase("Smoke")) {
            textErrorSmoke.setVisibility(View.VISIBLE);
            textErrorSmoke.setText(getString(R.string.empty_field));
            return false;
        }
        else {textErrorSmoke.setVisibility(View.GONE);}
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

