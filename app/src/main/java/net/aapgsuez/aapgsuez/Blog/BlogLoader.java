package net.aapgsuez.aapgsuez.Blog;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import net.aapgsuez.aapgsuez.Objects.EventsObject;

import java.util.List;

public class BlogLoader extends AsyncTaskLoader<List<BlogObject>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = BlogLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link BlogLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public BlogLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<BlogObject> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of events.
        List<BlogObject> blog = Blog_Query.fetchBlogData(mUrl);
        return blog;
    }
}