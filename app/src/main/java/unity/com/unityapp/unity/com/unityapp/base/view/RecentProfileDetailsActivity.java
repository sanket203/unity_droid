package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileDetailsActivity extends BaseActivity implements RecentProfileDetailsView {

    @Inject
    RecentProfileDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_pager)
    ViewPager imagePager;

    @BindView(R.id.details_pager)
    ViewPager detailspager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    ImagePagerAdapter imagePagerAdapter;

    List<String> imageUrls;

    int candidateId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        candidateId = getIntent().getIntExtra("candidateID", 0);
        imageUrls = new ArrayList<>();
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816576676996850IMG-20180604-WA0011.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816559605300813IMG-20180604-WA0008.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/15293024361722071842IMG-20180618-WA0001.jpg");
        setContentView(R.layout.activity_profile_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Recent Profiles");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        imagePagerAdapter = new ImagePagerAdapter(this, imageUrls);
        imagePager.setAdapter(imagePagerAdapter);
        detailspager.setAdapter(new DetailsPagerAdapter(getSupportFragmentManager(), String.valueOf(candidateId)));
        tabLayout.setupWithViewPager(imagePager, true);
    }

    @OnClick(R.id.left_nav)
    public void getPreviousItem() {
        detailspager.setCurrentItem(detailspager.getCurrentItem() - 1);
    }

    @OnClick(R.id.right_nav)
    public void getNextItem() {
        detailspager.setCurrentItem(detailspager.getCurrentItem() + 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unbind();
    }
}
