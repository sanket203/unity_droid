package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.R2;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfilesAdapter extends RecyclerView.Adapter<RecentProfilesAdapter.ProfileViewHolder> {

    private List<ProfileResponseViewModel> list;
    private ProfileItemClickListner itemClickListner;
    private LoadMoreProfilesListener mLoadMoreLottoTicketListener;
    private int mTotalItemCount;
    private int mLastVisibleItem;
    private boolean isLoading;
    private int mVisibleThreshold = 1;

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
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recent_profiles_row, parent, false);
        return new ProfileViewHolder(view, itemClickListner);

    }

    public void setLoadMoreProfilesListener(LoadMoreProfilesListener loadMoreLottoTicketListener) {
        mLoadMoreLottoTicketListener = loadMoreLottoTicketListener;
    }

    public void addOnScrollListener(RecyclerView profileSView) {
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) profileSView.getLayoutManager();
        profileSView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mTotalItemCount = linearLayoutManager.getItemCount();
                mLastVisibleItem = linearLayoutManager
                        .findLastVisibleItemPosition();
                if (!isLoading && mTotalItemCount <= (mLastVisibleItem + mVisibleThreshold)) {
                    // End has been reached
                    // Do something
                    isLoading = true;
                    if (mLoadMoreLottoTicketListener != null) {
                        mLoadMoreLottoTicketListener.onLoadMore();
                    }
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        holder.steItemId(position);
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        private ProfileItemClickListner listner;
        int itemId;

        @BindView(R2.id.profile_name)
        TextView nameTextView;

        @BindView(R2.id.tv_height)
        TextView heightTextView;

        @BindView(R2.id.tv_salary)
        TextView salaryTextView;

        @BindView(R2.id.profile_image)
        ImageView profileImageView;

        @BindView(R2.id.tv_birth_date)
        TextView birthDateTextView;

        @BindView(R2.id.tv_education)
        TextView educationTextView;

        void steItemId(int itemId) {
            this.itemId = itemId;
        }

        public ProfileViewHolder(View itemView, ProfileItemClickListner listner) {
            super(itemView);
            this.listner = listner;
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R2.id.profile_row)
        public void onProfileItemClick() {
            listner.onItemClick();
        }


        public void bind(int position) {
            nameTextView.setText(list.get(position).getName());
            //heightTextView.setText(list.get(position).getHeight());
            salaryTextView.setText(list.get(position).getIncome());
            educationTextView.setText(list.get(position).getEducation());
            birthDateTextView.setText(list.get(position).getBirthDate());
        }
    }

    public static interface LoadMoreProfilesListener {
        void onLoadMore();
    }
}
