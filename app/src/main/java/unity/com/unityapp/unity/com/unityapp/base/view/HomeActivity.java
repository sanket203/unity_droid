package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 10/12/18.
 */

public class HomeActivity extends BaseActivity implements HomeView, ProfileItemClickListner {

    @Inject
    HomePresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    public static int navItemIndex = 0;

    private static final String TAG_HOME = "recent_profile";
    private static final String TAG_ADDRESS_TAKEN = "adress_taken";
    private static final String TAG_MY_PROFILE = "my_profile";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("USE_INFO", String.valueOf(UserInfo.getUserInfo().getCandidateId()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.menu_icon);
        actionbar.setTitle("Recent Profiles");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mHandler = new Handler();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 1;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void sowData() {
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                MyProfileFragment myProfileFragment = new MyProfileFragment();
                return myProfileFragment;
            case 1:
                RecentProfileFragment recentProfileFragment = new RecentProfileFragment();
                return recentProfileFragment;
            case 2:
                AddressTakenFragment addressTakenFragment = new AddressTakenFragment();
                return addressTakenFragment;

            case 4:
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;

            default:
                return new RecentProfileFragment();
        }
    }


    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void loadHomeFragment() {
        // selecting appropriate nav menu item
        selectNavMenu();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            mDrawerLayout.closeDrawers();

            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.content_frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }
        //Closing drawer on item click
        mDrawerLayout.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        // This method will trigger on item Click of navigation menu
        navigationView.setNavigationItemSelectedListener(menuItem -> {

            //Check to see which item was being clicked and perform appropriate action
            switch (menuItem.getItemId()) {
                //Replacing the main content with ContentFragment Which is our Inbox View;
                case R.id.my_profile:
                    navItemIndex = 0;
                    CURRENT_TAG = TAG_MY_PROFILE;
                    toolbar.setTitle("My profile");
                    break;
                case R.id.recent_profiles:
                    navItemIndex = 1;
                    CURRENT_TAG = TAG_HOME;
                    toolbar.setTitle("Recent profiles");
                    break;
                case R.id.address_taken:
                    navItemIndex = 2;
                    CURRENT_TAG = TAG_ADDRESS_TAKEN;
                    toolbar.setTitle("Address taken");
                    break;
                case R.id.settings:
                    navItemIndex = 4;
                    CURRENT_TAG = TAG_SETTINGS;
                    toolbar.setTitle("Settings");
                    break;
                default:
                    navItemIndex = 1;
            }
            //Checking if the item is in checked state or not, if not make it in checked state
            if (menuItem.isChecked()) {
                menuItem.setChecked(false);
            } else {
                menuItem.setChecked(true);
            }
            menuItem.setChecked(true);

            loadHomeFragment();

            return true;
        });

    }

    @Override
    public void onItemClick() {
        Intent intent = new Intent(this, RecentProfileDetailsActivity.class);
        startActivity(intent);
    }
}
