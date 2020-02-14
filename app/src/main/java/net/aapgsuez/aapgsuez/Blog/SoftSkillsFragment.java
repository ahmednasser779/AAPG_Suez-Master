package net.aapgsuez.aapgsuez.Blog;

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

import net.aapgsuez.aapgsuez.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class SoftSkillsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<BlogObject>> {


    public SoftSkillsFragment() {
        // Required empty public constructor
    }


    public final String LOG_TAG = net.aapgsuez.aapgsuez.Blog.SoftSkillsFragment.class.getName();
    private static final String SOFTSKILLS_REQUEST_CALL = "http://aapgsuez.net/android/android-app/blog-soft.php";
    private static final int SOFTSKILLS_LOADER_ID = 1;

    private BlogAdapter mAdapter;
    private TextView mEmptyStateTextView;
    TextView categoryName;
    SwipeRefreshLayout pullToRefresh;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.blog_fragment, container, false);

        categoryName = rootview.findViewById(R.id.cat_name);
        categoryName.setText(R.string.soft_skills);
        pullToRefresh = (SwipeRefreshLayout) rootview.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeResources(R.color.colorPrimaryBlog);
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
            loaderManager.initLoader(SOFTSKILLS_LOADER_ID, null, this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = rootview.findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
        // Find a reference to the {@link ListView} in the layout
        ListView blogListView = (ListView) rootview.findViewById(R.id.blog);

        // Create a new adapter that takes an empty list of events as input
        mAdapter = new BlogAdapter(getActivity(), new ArrayList<BlogObject>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        blogListView.setAdapter(mAdapter);
        blogListView.setEmptyView(mEmptyStateTextView);
        blogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                BlogObject currentBlog = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                String eventUri = currentBlog.getmUrl();

                // Create a new intent to view the event URI
                Intent websiteIntent = new Intent(getActivity(), BlogWebView.class);
                websiteIntent.putExtra("url", eventUri);
                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


        return rootview;
    }



    @Override
    public Loader<List<BlogObject>> onCreateLoader(int id, Bundle args) {
        return new BlogLoader(getContext(), SOFTSKILLS_REQUEST_CALL);
    }

    @Override
    public void onLoadFinished(Loader<List<BlogObject>> loader, List<BlogObject> blog) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = getView().findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_events);
        // Clear the adapter of previous events data
        mAdapter.clear();

        // If there is a valid list of {@link Event}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (blog != null && !blog.isEmpty()) {
            mAdapter.addAll(blog);

        }
    }

    @Override
    public void onLoaderReset(Loader<List<BlogObject>> loader) {
// Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

}
