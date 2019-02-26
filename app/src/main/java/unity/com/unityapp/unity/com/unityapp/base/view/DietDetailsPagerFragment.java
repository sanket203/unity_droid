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

/**
 * Created by admin on 03/01/19.
 */

public class DietDetailsPagerFragment extends BaseFragment implements DietDetailsPagerView {

    @Inject
    DietDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;


    private String candidateId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDi.getFragmentComponent(this).inject(this);
        presenter.bind(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        // TODO: 02-02-2019  Write get call for Personal details
        return view;
    }

    public static DietDetailsPagerFragment newInstance(String candidateId) {
        DietDetailsPagerFragment personalDetailsPagerFragment = new DietDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
       // presenter.getPersonalDetails(candidateId);
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
    public void showPersonalDetails(PersonalDetailsViewModel viewModel) {

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
