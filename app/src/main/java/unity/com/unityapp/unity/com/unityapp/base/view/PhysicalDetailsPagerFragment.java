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
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class PhysicalDetailsPagerFragment extends BaseFragment implements PhysicalDetailsPagerView {

    @Inject
    PhysicalDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.tv_height)
    TextView tv_height;

    @BindView(R.id.tv_weight)
    TextView tv_weight;

    @BindView(R.id.tv_complexion)
    TextView tv_complexion;

    @BindView(R.id.tv_body_fom)
    TextView tv_body_fom;

    @BindView(R.id.tv_spects)
    TextView tv_spects;

    @BindView(R.id.tv_blood_group)
    TextView tv_blood_group;

    @BindView(R.id.tv_medical_surgery)
    TextView tv_medical_surgery;

    @BindView(R.id.tv_disability)
    TextView tv_disability;

    @BindView(R.id.tv_other_remarks)
    TextView tv_other_remarks;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;


    private String candidateId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  presenter.bind(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_physical_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        // TODO: 02-02-2019  Write get call for Personal details
        return view;
    }

    public static PhysicalDetailsPagerFragment newInstance(String candidateId) {
        PhysicalDetailsPagerFragment physicalDetailsPagerFragment = new PhysicalDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        physicalDetailsPagerFragment.setArguments(b);
        return physicalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
        AppDi.getFragmentComponent(this).inject(this);
        presenter.getPhysicalDetails(candidateId);
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
        Intent intent = new Intent(getContext(), EditPersonalDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }


    @Override
    public void showPhysicalDetails(PhysicalDetailsViewModel viewModel) {
        tv_height.setText(viewModel.getHeight());
        tv_weight.setText(viewModel.getWeight());
        tv_weight.setText(viewModel.getWeight());

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
