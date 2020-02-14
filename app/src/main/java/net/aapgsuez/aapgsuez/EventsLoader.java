package net.aapgsuez.aapgsuez;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;

import net.aapgsuez.aapgsuez.Objects.EventsObject;

import java.util.List;

public class EventsLoader extends AsyncTaskLoader<List<EventsObject>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = EventsLoader.class.getName();

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
    public EventsLoader(Context context, String url) {
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
    public List<EventsObject> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of events.
        List<EventsObject> events = Events_Query.fetchEventsData(mUrl);
        return events;
    }
}