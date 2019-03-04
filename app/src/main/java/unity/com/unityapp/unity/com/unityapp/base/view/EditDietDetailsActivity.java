package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
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

    private int candidateId;

    private DietDetailsViewModel dietDetailsViewModel;

    private void setData() {
        if (dietDetailsViewModel != null) {
            //  editDietType.setText(dietDetailsViewModel.getDietType());
            if (dietDetailsViewModel.getDrink().equalsIgnoreCase("Yes"))
                editDrink.setSelection(0);
            if (dietDetailsViewModel.getDrink().equalsIgnoreCase("Yes"))
                editSmoke.setSelection(0);

        }
    }

    private DietDetailsViewModel getData() {
        DietDetailsViewModel dietDetailsViewModel = new DietDetailsViewModel();
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
        actionbar.setTitle("Edit Personal Details");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.bind(this);
        candidateId = getIntent().getIntExtra("candidateId", 0);
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
