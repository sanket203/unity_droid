package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class ServiceDetailsPagerFragment extends BaseFragment implements ServiceDetailsPagerView {

    @Inject
    ServiceDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_occupation)
    TextView occupation;

    @BindView(R.id.tv_organization)
    TextView organization;

    @BindView(R.id.tv_organization_type)
    TextView organizationType;

    @BindView(R.id.tv_sector)
    TextView sector;

    @BindView(R.id.tv_working_city)
    TextView workingCity;

    @BindView(R.id.tv_designation)
    TextView designation;

    @BindView(R.id.tv_service_status)
    TextView serviceStatus;

    @BindView(R.id.tv_experience)
    TextView experience;

    @BindView(R.id.tv_annual_income)
    TextView annualIncome;


    private String candidateId;
    private ServiceDetailsViewModel serviceDetailsViewModel;

    @Override
    public void showServiceDetails(ServiceDetailsViewModel viewModel) {
        serviceDetailsViewModel = viewModel;
        occupation.setText(viewModel.getOccupation());
        organization.setText(viewModel.getOrganization());
        organizationType.setText(viewModel.getOrganizationType());
        sector.setText(viewModel.getSector());
        workingCity.setText(viewModel.getWorkingCity());
        designation.setText(viewModel.getDesignation());
        serviceStatus.setText(viewModel.getServiceStatus());
        experience.setText(viewModel.getExperience());
        annualIncome.setText(viewModel.getAnnualIncome());
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
        View view = inflater.inflate(R.layout.fragment_service_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        return view;
    }

    public static ServiceDetailsPagerFragment newInstance(String candidateId) {
        ServiceDetailsPagerFragment personalDetailsPagerFragment = new ServiceDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
        presenter.getServiceDetails(candidateId);
    }

    private void getCandidateId() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            candidateId = bundle.getString("candidateId");
        }
    }


    @OnClick(R.id.btn_edit)
    public void onEditClicked() {

        navigateToEditPersonalDetailsScreen();
    }

    void navigateToEditPersonalDetailsScreen() {
        Intent intent = new Intent(getContext(), EditServiceDetailsActivity.class);
        intent.putExtra("candidateId", candidateId);
        intent.putExtra("serviceDetailsViewModel", serviceDetailsViewModel);
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
}
