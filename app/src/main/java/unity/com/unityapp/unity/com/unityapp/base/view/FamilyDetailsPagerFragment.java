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
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class FamilyDetailsPagerFragment extends BaseFragment implements FamilyDetailsPagerView {

    @Inject
    FamilyDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_father_name)
    TextView fatherName;

    @BindView(R.id.tv_father_detail)
    TextView fatherDetails;

    @BindView(R.id.tv_mother_name)
    TextView motherName;

    @BindView(R.id.tv_mother_details)
    TextView motherDetails;

    @BindView(R.id.tv_brothers)
    TextView brothers;

    @BindView(R.id.tv_sisters)
    TextView sisters;

    @BindView(R.id.tv_brother_details)
    TextView brotherDetails;

    @BindView(R.id.tv_sister_details)
    TextView sisterDetails;

    @BindView(R.id.linearMain)
    NestedScrollView linearMain;

    private int counter = 0;
    private String candidateId;
    private FamilyDetailsViewModel familyDetailsViewModel;

    @Override
    public void showFamilyDetails(FamilyDetailsViewModel viewModel) {
        familyDetailsViewModel = viewModel;
        fatherName.setText(viewModel.getFather());
        fatherDetails.setText(viewModel.getFatherDescription());
        motherName.setText(viewModel.getMother());
        motherDetails.setText(viewModel.getMotherDescription());
        brothers.setText(viewModel.getBrothers());
        sisters.setText(viewModel.getSisters());
        brotherDetails.setText(viewModel.getBrotherDescription());
        sisterDetails.setText(viewModel.getSisterDescription());
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
        View view = inflater.inflate(R.layout.fragment_family_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        getCandidateId();
        presenter.getFamilyDetails(candidateId);
        // TODO: 02-02-2019  Write get call for Personal details
        return view;
    }

    public static FamilyDetailsPagerFragment newInstance(String candidateId) {
        FamilyDetailsPagerFragment personalDetailsPagerFragment = new FamilyDetailsPagerFragment();
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
        navigateToEditPersonalDetailsScreen();
    }

    void navigateToEditPersonalDetailsScreen() {
        Intent intent = new Intent(getContext(), EditFamilyDetailsActivity.class);
        intent.putExtra("candidateId", candidateId);
        intent.putExtra("familyDetailsViewModel", familyDetailsViewModel);
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
                            presenter.getFamilyDetails(candidateId);
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
