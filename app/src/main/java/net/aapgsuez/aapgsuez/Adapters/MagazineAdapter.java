package net.aapgsuez.aapgsuez.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.aapgsuez.aapgsuez.MagazineModel;
import net.aapgsuez.aapgsuez.MagazineResponse;
import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;

import retrofit2.Callback;

public class MagazineAdapter extends RecyclerView.Adapter<MagazineAdapter.MagazineViewHolder> {

    ArrayList<MagazineModel> mMagazineList;
    private OnMagazineListener mOnMagazineListener;
    private Context context;

    public MagazineAdapter(ArrayList<MagazineModel> magazineList, Context context
            , OnMagazineListener onMagazineListener) {
        this.mMagazineList = magazineList;
        this.context = context;
        this.mOnMagazineListener = onMagazineListener;
    }


    @NonNull
    @Override
    public MagazineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.magazine_list, parent, false);
        return new MagazineViewHolder(view, mOnMagazineListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MagazineViewHolder holder, int position) {

        holder.mIssueName.setText(mMagazineList.get(position).getTitle());
        holder.mIssueData.setText(mMagazineList.get(position).getData());
        Glide.with(context)
                .load(mMagazineList.get(position).getImage())
                .into(holder.mIssueImage);

    }

    @Override
    public int getItemCount() {
        return mMagazineList.size();
    }

    class MagazineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mIssueImage;
        TextView mIssueName, mIssueData;
        OnMagazineListener onMagazineListener;

        public MagazineViewHolder(View itemView, OnMagazineListener onMagazineListener) {
            super(itemView);
            mIssueImage = itemView.findViewById(R.id.issue_image);
            mIssueName = itemView.findViewById(R.id.issue_name);
            mIssueData = itemView.findViewById(R.id.issue_date);
            this.onMagazineListener = onMagazineListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onMagazineListener.onMagazineClick(getAdapterPosition());
        }
    }

    public interface OnMagazineListener {
        void onMagazineClick(int position);
    }

}



   /* public MagazineAdapter(Activity context, ArrayList<MagazineObject> magazines) {
        super(context, 0, magazines);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.magazine_list, parent, false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        MagazineObject currentMagazine = getItem(position);

        // Find the TextView in the magazine_list.xml.xml layout with the ID version_name
        ImageView imageResource = (ImageView) listItemView.findViewById(R.id.issue_image);
        imageResource.setImageResource(currentMagazine.getmImageResource());

        TextView issueName = (TextView) listItemView.findViewById(R.id.issue_name);
        issueName.setText(currentMagazine.getmName());

        TextView date = (TextView)listItemView.findViewById(R.id.issue_date);
        date.setText(currentMagazine.getmDate());
        return listItemView;
    }*/

