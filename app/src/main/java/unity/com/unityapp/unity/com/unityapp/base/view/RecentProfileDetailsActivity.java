package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.R2;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileDetailsActivity extends BaseActivity implements RecentProfileDetailsView {

    @Inject
    RecentProfileDetailsPresenter presenter;

    @BindView(R2.id.image_pager)
    ViewPager imagePager;

    @BindView(R2.id.details_pager)
    ViewPager detailspager;

    ImagePagerAdapter imagePagerAdapter;

    List<String> imageUrls;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUrls = new ArrayList<>();
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816576676996850IMG-20180604-WA0011.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/1528816559605300813IMG-20180604-WA0008.jpg");
        imageUrls.add("http://brahmanunityorganization.com/uploads/images/elite_match_couple_images/15293024361722071842IMG-20180618-WA0001.jpg");
        setContentView(R.layout.activity_profile_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        imagePagerAdapter = new ImagePagerAdapter(this, imageUrls);
        imagePager.setAdapter(imagePagerAdapter);
        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4 - 1) {
                    currentPage = 0;
                }
                imagePager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);
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
