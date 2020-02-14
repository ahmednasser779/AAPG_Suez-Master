package net.aapgsuez.aapgsuez.Blog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;



import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;

public class BlogAdapter extends ArrayAdapter<BlogObject> {
    public BlogAdapter(Activity context, ArrayList<BlogObject> blog) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, blog);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.blog_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        BlogObject currentBlog = getItem(position);

        TextView name = (TextView)listItemView.findViewById(R.id.blog_name);
        name.setText(currentBlog.getmName());

        TextView date = (TextView)listItemView.findViewById(R.id.blog_date);
        date.setText(currentBlog.getmDate());

        TextView desc = (TextView)listItemView.findViewById(R.id.blog_desc);
        desc.setText(currentBlog.getmDesc());

        ImageView event_img = (ImageView)listItemView.findViewById(R.id.blog_image);
        Picasso.get().load(currentBlog.getmimg()).fit()
                .into(event_img);

        return listItemView;
    }
    public static float convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }
}
