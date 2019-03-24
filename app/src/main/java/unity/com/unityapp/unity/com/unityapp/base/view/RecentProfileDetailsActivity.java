package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseActivity;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileDetailsActivity extends BaseActivity implements RecentProfileDetailsView, AddressCommunicator {

    @Inject
    RecentProfileDetailsPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.image_pager)
    ViewPager imagePager;

    @BindView(R.id.details_pager)
    ViewPager detailspager;
    AlertDialog.Builder builder;


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    ImagePagerAdapter imagePagerAdapter;

    List<String> imageUrls;

    int candidateId;
    private DetailsPagerAdapter detailsPagerAdapter;
    private boolean data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        candidateId = getIntent().getIntExtra("candidateID", 0);
        imageUrls = new ArrayList<>();
        setContentView(R.layout.activity_profile_details);
        ButterKnife.bind(this);
        AppDi.getActivityComponent(this).inject(this);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.ic_back);
        actionbar.setTitle("Recent Profiles");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        presenter.getImages(String.valueOf(candidateId));

        detailsPagerAdapter = new DetailsPagerAdapter(getSupportFragmentManager(), String.valueOf(candidateId), true);
        detailspager.setAdapter(detailsPagerAdapter);

        builder = new AlertDialog.Builder(this);
    }

    @OnClick(R.id.left_nav)
    public void getPreviousItem() {
        detailspager.setCurrentItem(detailspager.getCurrentItem() - 1);
    }

    @OnClick(R.id.btn_contact)
    public void onContactClick() {
        presenter.getContactDetails(String.valueOf(UserInfo.getUserInfo().getCandidateId()), String.valueOf(candidateId), false);

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

    @Override
    public void showProgressBar(boolean b) {

    }

    @Override
    public void showPopup() {
        builder.setMessage("Do you want to view contact of this profile?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        data = true;
                        UserInfo.getUserInfo().setAddressCount(UserInfo.getUserInfo().getAddressCount() - 1);
                        navigateToAddressFragment(true);
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
    public void navigateToAddressFragment(boolean b) {
        Intent intent = new Intent(this, ShowContactDetailsActivity.class);
        intent.putExtra("candidateId", String.valueOf(candidateId));
        intent.putExtra("isAddressExist", b);
        startActivity(intent);
    }

    @Override
    public void showImages(ImageResponseViewModel viewModel) {
        imageUrls = viewModel.getImageUrls();
        imagePagerAdapter = new ImagePagerAdapter(this, imageUrls);
        imagePager.setAdapter(imagePagerAdapter);
        if (imageUrls.size() > 1)
            tabLayout.setupWithViewPager(imagePager, true);
    }

    @Override
    public boolean sendData() {
        return data;
    }
}


