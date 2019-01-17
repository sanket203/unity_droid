package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.R2;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileFragment extends BaseFragment implements RecentProfileView {

    @Inject
    RecentProfilePresenter presenter;

    RecentProfilesAdapter adapter;
    List<ProfileResponseViewModel> list = new ArrayList<>();

    @BindView(R2.id.recent_profile_rv)
    RecyclerView recyclerView;
    private ProfileItemClickListner itemClickListner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ProfileItemClickListner)
            itemClickListner = (ProfileItemClickListner) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDi.getFragmentComponent(this).inject(this);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_list_fragment, container, false);
        ButterKnife.bind(this, view);
        ProfileResponseViewModel model = new ProfileResponseViewModel();
        model.setName("Sanket");
        model.setIncome("5000000");
        model.setHeight("5.6");
        model.setEducation("Engineer");
        model.setBirthDate("21-06-1992");
        ProfileResponseViewModel model1 = new ProfileResponseViewModel();
        model1.setName("Sanket");
        model1.setIncome("5000000");
        model1.setHeight("5.6");
        model1.setEducation("Engineer");
        model1.setBirthDate("21-06-1992");
        list = new ArrayList<>();
        list.add(model);
        list.add(model1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecentProfilesAdapter(list, getActivity(), itemClickListner);
        adapter.addOnScrollListener(recyclerView);
        adapter.setLoadMoreProfilesListener(() -> {
            int pageNumber = getPageNumberTobeFetch();
            if (pageNumber > 0) {
                presenter.getRecentProfiles(pageNumber);
            }
        });
        recyclerView.setAdapter(adapter);

        return view;
    }

    private int getPageNumberTobeFetch() {
        //Logic to be updated according to backend
        int pageNo = -1;
        pageNo = pageNo + 1;
        return pageNo;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bind(this);
        //presenter.getRecentProfiles(0);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }

    @Override
    public void showRecentProfiles(RecentProfileResponseViewModel viewModel) {
        list = viewModel.getProfileResponseViewModelList();
        adapter.updateData(viewModel.getProfileResponseViewModelList());
    }

    @Override
    public void showError(String message) {
        Log.d("ERROR", message);
    }
}
