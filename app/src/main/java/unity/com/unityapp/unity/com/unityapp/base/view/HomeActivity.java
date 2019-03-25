package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;

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

   // @BindView(R.id.profile_image)
    CircleImageView profileImage;

  //  @BindView(R.id.textName)
    TextView textName;

    @BindView(R.id.nav_view)
    NavigationView navigationView;
    public static int navItemIndex = 0;
    AlertDialog.Builder builder;

    private static final String TAG_HOME = "recent_profile";
    private static final String TAG_ADDRESS_TAKEN = "adress_taken";
    private static final String TAG_MY_PROFILE = "my_profile";
    private static final String TAG_HOME_FRAGMENT = "home";
    private static final String TAG_SETTINGS = "settings";
    public static String CURRENT_TAG = TAG_HOME;

    private boolean shouldLoadHomeFragOnBackPress = true;
    private Handler mHandler;
    TextView counter;
    String count = "";

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
        builder = new AlertDialog.Builder(this);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        mHandler = new Handler();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME_FRAGMENT;
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
        count = String.valueOf(UserInfo.getUserInfo().getAddressCount());
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
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                MyProfileFragment myProfileFragment = new MyProfileFragment();
                return myProfileFragment;
            case 2:
                RecentProfileFragment recentProfileFragment = new RecentProfileFragment();
                return recentProfileFragment;
            case 3:
                AddressTakenFragment addressTakenFragment = new AddressTakenFragment();
                return addressTakenFragment;

            case 4:
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;
            case 5:
                logout();

            default:
                return new HomeFragment();
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
        count = String.valueOf(UserInfo.getUserInfo().getAddressCount());
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        // This method will trigger on item Click of navigation menu

        View hView =  navigationView.getHeaderView(0);
       textName = (TextView)hView.findViewById(R.id.textName);
         profileImage = (CircleImageView) hView.findViewById(R.id.profile_image);

        navigationView.setNavigationItemSelectedListener(menuItem -> {

            //Check to see which item was being clicked and perform appropriate action
            switch (menuItem.getItemId()) {
                //Replacing the main content with ContentFragment Which is our Inbox View;
                case R.id.home:
                    navItemIndex = 0;
                    CURRENT_TAG = TAG_HOME_FRAGMENT;
                    toolbar.setTitle("Home");
                    break;
                case R.id.my_profile:
                    navItemIndex = 1;
                    CURRENT_TAG = TAG_MY_PROFILE;
                    toolbar.setTitle("My profile");
                    break;
                case R.id.recent_profiles:
                    navItemIndex = 2;
                    CURRENT_TAG = TAG_HOME;
                    toolbar.setTitle("Recent profiles");
                    break;
                case R.id.address_taken:
                    navItemIndex = 3;
                    CURRENT_TAG = TAG_ADDRESS_TAKEN;
                    toolbar.setTitle("Address taken");
                    break;
                case R.id.settings:
                    navItemIndex = 4;
                    CURRENT_TAG = TAG_SETTINGS;
                    toolbar.setTitle("Settings");
                    break;

                case R.id.logout:
                    logout();
                    break;
                default:
                    navItemIndex = 0;
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

        counter = (TextView) MenuItemCompat.getActionView(navigationView.getMenu().
                findItem(R.id.address_taken));
        counter.setGravity(Gravity.CENTER_VERTICAL);
        counter.setTypeface(null, Typeface.BOLD);
        counter.setTextColor(getResources().getColor(R.color.colorAccent));
        counter.setText(count);
        counter.setGravity(Gravity.CENTER_VERTICAL);
        counter.setTypeface(null, Typeface.BOLD);
        Picasso.get()
                .load(UserInfo.getUserInfo().getImageUrl())
                .fit()
                .into(profileImage);
        textName.setText(UserInfo.getUserInfo().getFirstName());

    }

    @Override
    public void onItemClick(ProfileResponseViewModel profileResponseViewModel) {
        Intent intent = new Intent(this, RecentProfileDetailsActivity.class);
        intent.putExtra("candidateID", profileResponseViewModel.getCandidateId());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        navItemIndex = 0;
        CURRENT_TAG = TAG_HOME_FRAGMENT;
        loadHomeFragment();
    }

    private void logout() {
        builder.setMessage("Do you want to logout.?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
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
        alert.setTitle("Logout?");
        alert.show();


    }
}
