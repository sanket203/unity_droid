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
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileFragment extends BaseFragment implements RecentProfileView, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {

    @Inject
    RecentProfilePresenter presenter;

    private RecentProfilesAdapter adapter;
    private List<ProfileResponseViewModel> list = new ArrayList<>();
    
    @BindView(R.id.recent_profile_rv)
    RecyclerView recyclerView;

    @BindView(R.id.swipeRefresh)
    android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    private ProfileItemClickListner itemClickListner;

    private static final int PAGE_START = 1;
    private int currentPage = PAGE_START;
    private boolean isLastPage = false;
    private int totalPage = 10;
    private boolean isLoading = false;
    private int itemCount = 0;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecentProfilesAdapter(list, getActivity(), itemClickListner);
        recyclerView.setAdapter(adapter);
      presenter.getRecentProfiles(0);
      /*  recyclerView.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
                presenter.getRecentProfiles(currentPage);
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
        swipeRefreshLayout.setOnRefreshListener(this);*/



        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
               // swipeRefreshLayout.setRefreshing(true);
                Log.e("Page Count",":"+page);
                presenter.getRecentProfiles(page);
               // swipeRefreshLayout.setEnabled(true);

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bind(this);
        onRefresh();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }

    @Override
    public void showRecentProfiles(RecentProfileResponseViewModel viewModel) {
       // if (currentPage != PAGE_START) adapter.removeLoading();

      //  arrayList = data.getData();

        Log.e("List",":"+viewModel.getProfileResponseViewModelList().size());
        list.addAll(viewModel.getProfileResponseViewModelList());
        adapter.notifyDataSetChanged();

       // adapter.addAll(viewModel.getProfileResponseViewModelList());
       // swipeRefreshLayout.setRefreshing(false);
       /* if (currentPage < totalPage) adapter.addLoading();
        else isLastPage = true;*/
       // isLoading = false;
    }

    @Override
    public void showError(String message) {
        Log.d("ERROR", message);
      //  isLastPage = true;
     //   isLoading = false;
      //  adapter.removeLoading();
    }


    @Override
    public void onRefresh() {
      //  itemCount = 0;
       // currentPage = PAGE_START;
        //isLastPage = false;
        //adapter.clear();
       // presenter.getRecentProfiles(0);

    }
}
