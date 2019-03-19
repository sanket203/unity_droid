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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class PersonalDetailsPagerFragment extends BaseFragment implements PersonalDetailsPagerView {

    @Inject
    PersonalDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.full_name)
    TextView fullName;

    @BindView(R.id.birth_date)
    TextView birthDate;

    @BindView(R.id.birth_time)
    TextView birthTime;

    @BindView(R.id.birth_place)
    TextView birthPlace;

    @BindView(R.id.mothertongue)
    TextView motherTongue;

    @BindView(R.id.tv_gender)
    TextView gender;

    @BindView(R.id.marrital_status)
    TextView marritalStatus;

    @BindView(R.id.about_me)
    TextView aboutMe;

    @BindView(R.id.hobbies)
    TextView hobbies;

     @BindView(R.id.linearMain)
     LinearLayout linearMain;

    private String candidateId;
    private int counter = 0;
    private PersonalDetailsViewModel personalDetailsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDi.getFragmentComponent(this).inject(this);
        presenter.bind(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        return view;
    }

    public static PersonalDetailsPagerFragment newInstance(String candidateId) {
        PersonalDetailsPagerFragment personalDetailsPagerFragment = new PersonalDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
        presenter.getPersonalDetails(candidateId);
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
        intent.putExtra("candidateID", UserInfo.getUserInfo().getCandidateId());
        intent.putExtra("personalDetailsViewModel", personalDetailsViewModel);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }

    @Override
    public void showPersonalDetails(PersonalDetailsViewModel viewModel) {
        this.personalDetailsViewModel = viewModel;
        fullName.setText(viewModel.getFirstName() + " " + viewModel.getLastName());
        birthDate.setText(viewModel.getBirthDate());
        birthTime.setText(viewModel.getBirthTime());
        birthPlace.setText(viewModel.getBirthPlace());
        motherTongue.setText(viewModel.getMotherTongue());
        marritalStatus.setText(viewModel.getMaritalStatus());
        gender.setText(viewModel.getGender());
        aboutMe.setText(viewModel.getAboutMe());
        hobbies.setText(viewModel.getHobbies());
    }

    @Override
    public void showErrorMessage(String message) {
        snackbar(linearMain,message);
    }

    @Override
    public void showProgressBar(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void snackbar(View view, String errorMessage)
    {

        if(counter == 3) {
            Snackbar snackbar = Snackbar
                    .make(view, "Please Try After Some Time", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.BLACK);
            View sbView = snackbar.getView();
            sbView.setBackgroundResource(R.drawable.error_message);
            TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();

        }
        else
        {
            Snackbar snackbar = Snackbar
                    .make(view, errorMessage, Snackbar.LENGTH_LONG)
                    .setAction("RETRY", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            counter = counter + 1;
                            presenter.getPersonalDetails(candidateId);
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
