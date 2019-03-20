package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfilesAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<ProfileResponseViewModel> list;
    private ProfileItemClickListner itemClickListner;
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoaderVisible = false;

    public RecentProfilesAdapter(List<ProfileResponseViewModel> list, Context activity, ProfileItemClickListner itemClickListner) {
        this.list = list;
        this.itemClickListner = itemClickListner;
    }

    public void updateData(List<ProfileResponseViewModel> profileResponseViewModels) {
        if (list != null) {
            list.clear();
            list.addAll(profileResponseViewModels);
            notifyDataSetChanged();
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ProfileViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_profiles_row, parent, false), itemClickListner);
            case VIEW_TYPE_LOADING:
                return new FooterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == list.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    public void addLoading() {
        isLoaderVisible = true;
        add(new ProfileResponseViewModel());
    }

    public void add(ProfileResponseViewModel response) {
        list.add(response);
        notifyItemInserted(list.size() - 1);
    }

    public void addAll(List<ProfileResponseViewModel> postItems) {
        for (ProfileResponseViewModel response : postItems) {
            add(response);
        }
    }

    ProfileResponseViewModel getItem(int position) {
        return list.get(position);
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = list.size() - 1;
        ProfileResponseViewModel item = getItem(position);
        if (item != null) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    private void remove(ProfileResponseViewModel postItems) {
        int position = list.indexOf(postItems);
        if (position > -1) {
            list.remove(position);
            notifyItemRemoved(position);
        }
    }


    class ProfileViewHolder extends BaseViewHolder {

        private ProfileItemClickListner listner;
        int itemId;

        @BindView(R.id.profile_name)
        TextView nameTextView;

        @BindView(R.id.tv_height)
        TextView heightTextView;

        @BindView(R.id.tv_salary)
        TextView salaryTextView;

        @BindView(R.id.profile_image)
        ImageView profileImageView;

        @BindView(R.id.tv_birth_date)
        TextView birthDateTextView;

        @BindView(R.id.tv_education)
        TextView educationTextView;

        public ProfileViewHolder(View itemView, ProfileItemClickListner listner) {
            super(itemView);
            this.listner = listner;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.profile_row)
        public void onProfileItemClick() {
            listner.onItemClick(list.get(getPosition()));
        }


        public void onBind(int position) {
            nameTextView.setText(list.get(position).getName());
            heightTextView.setText(list.get(position).getHeight());
            salaryTextView.setText(list.get(position).getIncome());
            educationTextView.setText(list.get(position).getEducation());
            birthDateTextView.setText(list.get(position).getBirthDate());
        }

        @Override
        protected void clear() {

        }

        @Override
        protected void setItemId(int itemId) {
            this.itemId = itemId;
        }
    }

    public class FooterHolder extends BaseViewHolder {

        @BindView(R.id.progressBar)
        ProgressBar mProgressBar;


        FooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @Override
        protected void setItemId(int itemId) {

        }

    }

}
