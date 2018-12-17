package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;
import unity.com.unityapp.unity.com.unityapp.base.di.AppDi;

/**
 * Created by admin on 17/12/18.
 */

public class MyProfileFragment extends BaseFragment implements MyProfileView {

    @Inject
    MyProfilePresenter presenter;

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
