package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileRequestViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileFragment extends BaseFragment implements RecentProfileView {

    @Inject
    RecentProfilePresenter presenter;

    RecentProfilesAdapter adapter;

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
        View view = inflater.inflate(R.layout.recent_profile_fragment, container, false);
        ButterKnife.bind(this, view);
        RecentProfileRequestViewModel model = new RecentProfileRequestViewModel("Sanket Kasrekar", "5.6", "5000000");

        RecentProfileRequestViewModel model1 = new RecentProfileRequestViewModel("Sanket Kasrekar", "5.6", "5000000");
        RecentProfileRequestViewModel model2 = new RecentProfileRequestViewModel("Sanket Kasrekar", "5.6", "5000000");
        List<RecentProfileRequestViewModel> list = new ArrayList<>();
        list.add(model);
        list.add(model1);
        list.add(model2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecentProfilesAdapter(list, getActivity(), itemClickListner);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bind(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }
}
