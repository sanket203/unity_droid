package unity.com.unityapp.unity.com.unityapp.base;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by admin on 10/12/18.
 */

public class BaseActivity extends AppCompatActivity {

    protected void initToolbar(final Toolbar toolbar, final boolean showNavigationButton, boolean showTitle) {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(showNavigationButton);
            getSupportActionBar().setDisplayShowTitleEnabled(showTitle);
        }
    }
}
