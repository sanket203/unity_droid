package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class ExpectationsDetailsPagerFragment extends BaseFragment implements ExpectationsDetailsPagerView {

    @Inject
    ExpectationsDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_min_height)
    TextView minHeight;

    @BindView(R.id.tv_max_height)
    TextView maxHeight;

    @BindView(R.id.tv_min_age)
    TextView minAge;

    @BindView(R.id.tv_max_age)
    TextView maxAge;

    @BindView(R.id.tv_subcaste)
    TextView subCaste;

    @BindView(R.id.tv_education)
    TextView education;

    @BindView(R.id.tv_income)
    TextView income;

    @BindView(R.id.tv_working_location)
    TextView workingLocation;

    @BindView(R.id.tv_other)
    TextView otherExpectations;

    @BindView(R.id.linearMain)
    NestedScrollView linearMain;


    private String candidateId;
    private int counter = 0;
    private ExpectationsViewModel expectationsViewModel;

    @Override
    public void showExpectationDetails(ExpectationsViewModel viewModel) {
        expectationsViewModel = viewModel;
        minHeight.setText(viewModel.getMinHeight());
        maxHeight.setText(viewModel.getMaxHeight());
        minAge.setText(viewModel.getMinAge());
        maxAge.setText(viewModel.getMaxAge());
        subCaste.setText(viewModel.getSubCaste());
        education.setText(viewModel.getDegree());
        income.setText(viewModel.getPackageLimit());
        workingLocation.setText(viewModel.getWorkingLocation());
        otherExpectations.setText(viewModel.getOther());
    }

    @Override
    public void showErrorMessage(String message) {
        snackbar(linearMain, message);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDi.getFragmentComponent(this).inject(this);
        presenter.bind(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expectations_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        getCandidateId();
        presenter.getExpectationDetails(candidateId);
        return view;
    }

    public static ExpectationsDetailsPagerFragment newInstance(String candidateId) {
        ExpectationsDetailsPagerFragment personalDetailsPagerFragment = new ExpectationsDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void getCandidateId() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            candidateId = bundle.getString("candidateId");
        }
    }


    @OnClick(R.id.btn_edit)
    public void onEditClicked() {
        // TODO: 02-02-2019 pass personal details data to edit screen
        navigateToEditPersonalDetailsScreen();
    }

    void navigateToEditPersonalDetailsScreen() {
        Intent intent = new Intent(getContext(), EditExpectationDetailsActivity.class);
        intent.putExtra("candidateId", candidateId);
        intent.putExtra("expectationsViewModel", expectationsViewModel);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }


    @Override
    public void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void snackbar(View view, String errorMessage) {

        if (counter == 3) {
            Snackbar snackbar = Snackbar
                    .make(view, "Please Try After Some Time", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.BLACK);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.drawable.error_message);
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();

        } else {
            Snackbar snackbar = Snackbar
                    .make(view, errorMessage, Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            counter = counter + 1;
                            presenter.getExpectationDetails(candidateId);
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
}
