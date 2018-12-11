package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import unity.com.unityapp.R;
import unity.com.unityapp.R2;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileRequestViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfilesAdapter extends RecyclerView.Adapter<RecentProfilesAdapter.ProfileViewHolder> {

    private List<RecentProfileRequestViewModel> list;
    private ProfileItemClickListner itemClickListner;

    public RecentProfilesAdapter(List<RecentProfileRequestViewModel> list, Context activity, ProfileItemClickListner itemClickListner) {
        this.list = list;
        this.itemClickListner = itemClickListner;
    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recent_profiles_row, parent, false);
        return new ProfileViewHolder(view, itemClickListner);

    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {
        holder.steItemId(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ProfileViewHolder extends RecyclerView.ViewHolder {

        private ProfileItemClickListner listner;
        int itemId;

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
            listner.onItemClick(list.get(itemId));
        }


    }
}
