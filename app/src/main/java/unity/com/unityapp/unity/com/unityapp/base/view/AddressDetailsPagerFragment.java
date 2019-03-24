package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

/**
 * Created by admin on 03/01/19.
 */

public class AddressDetailsPagerFragment extends BaseFragment implements AddressDetailsPagerView {

    @Inject
    AddressDetailsPagerPresenter presenter;


    @BindView(R.id.btn_edit)
    TextView editButton;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.tv_address)
    TextView address;

    @BindView(R.id.tv_contact_no)
    TextView contactNo;

    @BindView(R.id.tv_alternate_contact)
    TextView alternateContaxt;

    AlertDialog.Builder builder;


    private String candidateId;

    private AddressCommunicator addressCommunicator;

    private boolean isAddressTaken = true;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AddressCommunicator) {
            addressCommunicator = (AddressCommunicator) context;
        }
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
        View view = inflater.inflate(R.layout.fragment_contact_details_pager, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() instanceof RecentProfileDetailsActivity) {
            editButton.setVisibility(View.GONE);
        }
        builder = new AlertDialog.Builder(getActivity());
        return view;

    }

    public static AddressDetailsPagerFragment newInstance(String candidateId) {
        AddressDetailsPagerFragment personalDetailsPagerFragment = new AddressDetailsPagerFragment();
        Bundle b = new Bundle();
        b.putString("candidateId", candidateId);
        personalDetailsPagerFragment.setArguments(b);
        return personalDetailsPagerFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCandidateId();
        if (addressCommunicator != null)
            isAddressTaken = addressCommunicator.sendData();
        if (candidateId.equalsIgnoreCase(String.valueOf(UserInfo.getUserInfo().getCandidateId()))) {
            presenter.getContactDetails();
        } else {
            presenter.getContactDetails(String.valueOf(UserInfo.getUserInfo().getCandidateId()), candidateId, isAddressTaken);
        }

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

    @Override
    public void showPopup() {
        builder.setMessage("Do you want to view contact details of the profile.?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        presenter.getContactDetails(String.valueOf(UserInfo.getUserInfo().getCandidateId()), candidateId, true);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        dialog.cancel();

                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("View Contact");
        alert.show();

    }

    @Override
    public void showContactDetails(AddressViewModel viewModel) {
        address.setText(viewModel.getAddress());
        contactNo.setText(String.valueOf(viewModel.getContactNumber()));
        alternateContaxt.setText(String.valueOf(viewModel.getAlternateNumber()));
    }

   /* @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            getCandidateId();
            isAddressTaken = addressCommunicator.sendData();
            if (candidateId.equalsIgnoreCase(String.valueOf(UserInfo.getUserInfo().getCandidateId()))) {

            } else {
                presenter.getContactDetails(String.valueOf(UserInfo.getUserInfo().getCandidateId()), candidateId, isAddressTaken);
            }
        }
    }*/
}
