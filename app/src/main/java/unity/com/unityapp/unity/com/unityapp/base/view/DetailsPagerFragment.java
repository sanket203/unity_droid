package unity.com.unityapp.unity.com.unityapp.base.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BaseFragment;

/**
 * Created by admin on 03/01/19.
 */

public class DetailsPagerFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
