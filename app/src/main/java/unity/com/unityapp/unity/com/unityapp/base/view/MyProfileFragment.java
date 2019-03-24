package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

/**
 * Created by admin on 17/12/18.
 */

public class MyProfileFragment extends BaseFragment implements MyProfileView {

    @Inject
    MyProfilePresenter presenter;

    @BindView(R.id.image_pager)
    ViewPager imagePager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.details_pager)
    ViewPager detailspager;

    ImagePagerAdapter imagePagerAdapter;

    List<String> imageUrls;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDi.getFragmentComponent(this).inject(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_profile_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.left_nav)
    public void getPreviousItem() {
        detailspager.setCurrentItem(detailspager.getCurrentItem() - 1);
    }

    @OnClick(R.id.right_nav)
    public void getnextItem() {
        detailspager.setCurrentItem(detailspager.getCurrentItem() + 1);
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.bind(this);
        imageUrls = new ArrayList<>();
        presenter.getImages(String.valueOf(UserInfo.getUserInfo().getCandidateId()));
        detailspager.setAdapter(new DetailsPagerAdapter(getChildFragmentManager(), String.valueOf(UserInfo.getUserInfo().getCandidateId()), false));
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showImages(ImageResponseViewModel viewModel) {
        imageUrls = viewModel.getImageUrls();
        imagePagerAdapter = new ImagePagerAdapter(getActivity(), imageUrls);
        imagePager.setAdapter(imagePagerAdapter);
        if (imageUrls.size() > 1)
            tabLayout.setupWithViewPager(imagePager, true);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }
}
