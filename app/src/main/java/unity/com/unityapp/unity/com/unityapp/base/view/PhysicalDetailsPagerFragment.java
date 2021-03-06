package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_height)
    TextView height;

    @BindView(R.id.tv_weight)
    TextView weight;

    @BindView(R.id.tv_complexion)
    TextView complexion;

    @BindView(R.id.tv_body_form)
    TextView bodyForm;

    @BindView(R.id.tv_spects)
    TextView spects;

    @BindView(R.id.tv_blood_group)
    TextView bloodGroup;

    @BindView(R.id.tv_medical_surgery)
    TextView medicalSurgery;

    @BindView(R.id.tv_disability)
    TextView disability;

    @BindView(R.id.tv_other_remarks)
    TextView otherRemarks;

    @BindView(R.id.linearMain)
    LinearLayout linearMain;

    private String candidateId;
    private int counter = 0;
    private PhysicalDetailsViewModel physicalDetailsViewModel;

    @Override
    public void showPhysicalDetails(PhysicalDetailsViewModel viewModel) {
        physicalDetailsViewModel = viewModel;
        height.setText(viewModel.getHeight());
        weight.setText(viewModel.getWeight() + "Kg");
        complexion.setText(viewModel.getComplexion());
        bodyForm.setText(viewModel.getBodyform());
        spects.setText(viewModel.getSpects());
        bloodGroup.setText(viewModel.getBloodGroup());
        medicalSurgery.setText(viewModel.getMedicalSurgary());
        disability.setText(viewModel.getDisability());
        otherRemarks.setText(viewModel.getOtherRemarks());
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
        View view = inflater.inflate(R.layout.fragment_physical_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        getCandidateId();
        presenter.getPhysicalDetails(candidateId);
        return view;
    }

    public static PhysicalDetailsPagerFragment newInstance(String candidateId) {
        PhysicalDetailsPagerFragment personalDetailsPagerFragment = new PhysicalDetailsPagerFragment();
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
        navigateToEditPhysicalDetailsScreen();
    }

    void navigateToEditPhysicalDetailsScreen() {
        Intent intent = new Intent(getContext(), EditPhysicalDetailsActivity.class);
        intent.putExtra("candidateId", candidateId);
        intent.putExtra("physicalDetailsViewModel", physicalDetailsViewModel);
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
                            presenter.getPhysicalDetails(candidateId);
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
