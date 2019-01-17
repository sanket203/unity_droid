package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by admin on 03/01/19.
 */

public class ImagePagerAdapter extends PagerAdapter {

    private Context context;

    private List<String> imageUrlList;

    public ImagePagerAdapter(Context context, List<String> imageUrlList) {
        this.context = context;
        this.imageUrlList = imageUrlList;
    }

    @Override
    public int getCount() {
        return imageUrlList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Picasso.get()
                .load(imageUrlList.get(position))
                .fit()
                .centerCrop()
                .into(imageView);
        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
