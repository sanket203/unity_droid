package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
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

public class HomeFragment extends BaseFragment implements MyProfileView {

    @Inject
    MyProfilePresenter presenter;

    @BindView(R.id.image_pager)
    ViewPager imagePager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
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
        // TODO: 02-02-2019  Write get call for Image urls

        super.onResume();
        viewpager.setAdapter(new CustomPagerAdapter(getActivity()));

        presenter.bind(this);
        imageUrls = new ArrayList<>();
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816576676996850IMG-20180604-WA0011.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816559605300813IMG-20180604-WA0008.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/15293024361722071842IMG-20180618-WA0001.jpg");

        imagePagerAdapter = new ImagePagerAdapter(getActivity(), imageUrls);
        imagePager.setAdapter(imagePagerAdapter);
        tabLayout.setupWithViewPager(imagePager, true);

        //detailspager.setAdapter(new DetailsPagerAdapter(getChildFragmentManager(), String.valueOf(UserInfo.getUserInfo().getCandidateId())));

        detailspager.setAdapter(new CustomPagerAdapter_(getActivity()));
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unbind();
    }

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showImages(ImageResponseViewModel viewModel) {

    }

    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;

        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            ModelObject modelObject = ModelObject.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return ModelObject.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            ModelObject customPagerEnum = ModelObject.values()[position];
            return mContext.getString(customPagerEnum.getTitleResId());
        }

    }


    public enum ModelObject {

        RED(R.layout.recent_profiles_row),
        BLUE(R.layout.recent_profiles_row),
        GREEN(R.layout.recent_profiles_row);

        private int mTitleResId;
        private int mLayoutResId;

        ModelObject(int layoutResId) {

            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }

    public class CustomPagerAdapter_ extends PagerAdapter {

        private Context mContext;

        public CustomPagerAdapter_(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            ModelObject_ modelObject = ModelObject_.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return ModelObject_.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            ModelObject_ customPagerEnum = ModelObject_.values()[position];
            return mContext.getString(customPagerEnum.getTitleResId());
        }

    }


    public enum ModelObject_ {

        RED(R.layout.fragment_stories_detail),
        BLUE(R.layout.fragment_stories_detail),
        GREEN(R.layout.fragment_stories_detail);


        private int mTitleResId;
        private int mLayoutResId;

        ModelObject_(int layoutResId) {

            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }


}
