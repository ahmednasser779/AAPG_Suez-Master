package net.aapgsuez.aapgsuez;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import net.aapgsuez.aapgsuez.Adapters.EventsAdapter;
import net.aapgsuez.aapgsuez.Objects.EventsObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<EventsObject>> {

    public static final String LOG_TAG = EventsFragment.class.getName();
    private static final String EVENTS_REQUEST_CALL = "http://aapgsuez.net/android/android-app/Android-Events.php";
    private static final int EVENTS_LOADER_ID = 1;

    private EventsAdapter mAdapter;
    private TextView mEmptyStateTextView;
    SwipeRefreshLayout pullToRefresh;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.events, container, false);

        pullToRefresh = (SwipeRefreshLayout) rootview.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeResources(R.color.colorPrimary);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getActivity().recreate();
            }
        });
        mEmptyStateTextView = (TextView) rootview.findViewById(R.id.empty_view);

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();
            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(EVENTS_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = rootview.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
        // Find a reference to the {@link ListView} in the layout
        ListView eventsListView = (ListView) rootview.findViewById(R.id.events);

        // Create a new adapter that takes an empty list of events as input
        mAdapter = new EventsAdapter(getActivity(), new ArrayList<EventsObject>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        eventsListView.setAdapter(mAdapter);
        eventsListView.setEmptyView(mEmptyStateTextView);
        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EventsObject currentEvent = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                String eventUri = currentEvent.getmUrl();

                // Create a new intent to view the event URI
                Intent websiteIntent = new Intent(getActivity(), webView.class);
                websiteIntent.putExtra("url", eventUri);
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


        return rootview;
    }



    @Override
    public Loader<List<EventsObject>> onCreateLoader(int id,  Bundle args) {
        return new EventsLoader(getContext(), EVENTS_REQUEST_CALL);
    }

    @Override
    public void onLoadFinished(Loader<List<EventsObject>> loader, List<EventsObject> events) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = getView().findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_events);
        // Clear the adapter of previous events data
        mAdapter.clear();

        // If there is a valid list of {@link Event}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (events != null && !events.isEmpty()) {
            mAdapter.addAll(events);

        }
    }

    @Override
    public void onLoaderReset(Loader<List<EventsObject>> loader) {
// Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

}
