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
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class HoroscopeDetailsPagerFragment extends BaseFragment implements HoroscopeDetailsPagerView {

    @Inject
    HoroscopeDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_cast)
    TextView cast;

    @BindView(R.id.tv_subcast)
    TextView subCast;

    @BindView(R.id.tv_shakha)
    TextView shakha;

    @BindView(R.id.tv_upshakha)
    TextView upShakha;

    @BindView(R.id.tv_gotra)
    TextView gotra;

    @BindView(R.id.tv_rashi)
    TextView rashi;

    @BindView(R.id.tv_gana)
    TextView gana;

    @BindView(R.id.tv_nakshatra)
    TextView nakshatra;

    @BindView(R.id.tv_nadi)
    TextView naadi;

    @BindView(R.id.tv_charan)
    TextView charan;

    @BindView(R.id.tv_mangal)
    TextView mangal;

    @BindView(R.id.tv_remarks)
    TextView remarks;
    private String candidateId;
    private HoroscopeDetailsViewModel horoscopeDetailsViewModel;

    @Override
    public void showHoroscopeDetails(HoroscopeDetailsViewModel viewModel) {
        horoscopeDetailsViewModel = viewModel;
        cast.setText(viewModel.getCaste());
        subCast.setText(viewModel.getSubCaste());
        shakha.setText(viewModel.getShakha());
        upShakha.setText(viewModel.getUpshakha());
        gotra.setText(viewModel.getGotra());
        rashi.setText(viewModel.getRashi());
        gana.setText(viewModel.getGana());
        nakshatra.setText(viewModel.getNakshatra());
        naadi.setText(viewModel.getNaadi());
        charan.setText(viewModel.getCharan());
        mangal.setText(viewModel.getMangal());
        remarks.setText(viewModel.getRemarks());
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
        View view = inflater.inflate(R.layout.fragment_horoscope_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        // TODO: 02-02-2019  Write get call for Personal details
        return view;
    }

    public static HoroscopeDetailsPagerFragment newInstance(String candidateId) {
        HoroscopeDetailsPagerFragment personalDetailsPagerFragment = new HoroscopeDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
        presenter.getHoroscopeDetails(candidateId);
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
        Intent intent = new Intent(getContext(), EditHoroscopeDetailsActivity.class);
        intent.putExtra("candidateId", candidateId);
        intent.putExtra("horoscopeDetailsViewModel", horoscopeDetailsViewModel);
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
