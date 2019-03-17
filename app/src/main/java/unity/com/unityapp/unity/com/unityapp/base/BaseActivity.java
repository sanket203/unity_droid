package unity.com.unityapp.unity.com.unityapp.base;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import unity.com.unityapp.R;

/**
 * Created by admin on 10/12/18.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    protected void initToolbar(final Toolbar toolbar, final boolean showNavigationButton, boolean showTitle) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showNavigationButton);
            getSupportActionBar().setDisplayShowTitleEnabled(showTitle);
        }
    }

    @Override
    public void close() {
        finish();
    }


}
