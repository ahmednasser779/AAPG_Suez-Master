package net.aapgsuez.aapgsuez;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import net.aapgsuez.aapgsuez.Objects.ArticlesObject;

import java.util.List;

public class ArticlesLoader extends AsyncTaskLoader<List<ArticlesObject>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = ArticlesLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link EventsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public ArticlesLoader(Context context, String url) {
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
    public List<ArticlesObject> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of articles.
        List<ArticlesObject> articles = Articles_Query.fetchArticlesData(mUrl);
        return articles;
    }
}