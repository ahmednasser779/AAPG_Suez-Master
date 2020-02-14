package net.aapgsuez.aapgsuez.Blog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.BlogViewHolder> {

    ArrayList<BlogArticle> mList;
    private OnArticleClickListener onArticleClickListener;
    Context context;

    public RecentAdapter(ArrayList<BlogArticle> mList , Context context , OnArticleClickListener onArticleClickListener) {
        this.mList = mList;
        this.context = context;
        this.onArticleClickListener = onArticleClickListener;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.blog_list, parent , false);
        return new BlogViewHolder(view , onArticleClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        holder.blogTitle.setText(mList.get(position).getName());
        holder.blogDate.setText(mList.get(position).getDate());
        holder.blogDesc.setText(mList.get(position).getDescription());
        Glide.with(holder.blogImage.getContext())
                .load(mList.get(position).getImage())
                .into(holder.blogImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class BlogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView blogImage;
        TextView blogTitle , blogDate , blogDesc;
        OnArticleClickListener onArticleClickListener;
        public BlogViewHolder(View itemView , OnArticleClickListener onArticleClickListener) {
            super(itemView);
            blogImage = itemView.findViewById(R.id.blog_image);
            blogTitle = itemView.findViewById(R.id.blog_name);
            blogDate = itemView.findViewById(R.id.blog_date);
            blogDesc = itemView.findViewById(R.id.blog_desc);

            this.onArticleClickListener = onArticleClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onArticleClickListener.onArticleClick(getAdapterPosition());
        }
    }
    public interface OnArticleClickListener{
        void onArticleClick(int position);
    }
}
