package net.aapgsuez.aapgsuez;


import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import net.aapgsuez.aapgsuez.Adapters.MagazineAdapter;
import net.aapgsuez.aapgsuez.Objects.MagazineObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MagazineFragment extends Fragment {

    SwipeRefreshLayout pullToRefresh;
    ArrayList<MagazineModel> magazines;
    RecyclerView magazineRecyclerView;
    MagazineAdapter magazineAdapter;
    TextView mEmptyStateText;
    ProgressBar progressBar;

    public MagazineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.magazine, container, false);
        pullToRefresh = rootView.findViewById(R.id.pullToRefresh);
        pullToRefresh.setColorSchemeResources(R.color.colorPrimary);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getActivity().recreate();
            }
        });
        mEmptyStateText = rootView.findViewById(R.id.empty_view);
        progressBar = rootView.findViewById(R.id.loading_indicator);
        progressBar.setVisibility(View.VISIBLE);

        callApi();

        magazineRecyclerView = rootView.findViewById(R.id.magazine_recycler_view);
        magazines = new ArrayList<>();
        /*
        magazines.add(new MagazineObject(R.drawable.aspire01, "issue 1", "March 2018", "https://s3.amazonaws.com/online.anyflip.com/dbsw/vdlm/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse06, "issue 6", "May 2018", "https://s3.amazonaws.com/online.anyflip.com/dbsw/iaqg/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse05, "issue 5", "May 2017", "http://online.anyflip.com/wowp/ctis/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse04, "issue 4", "April 2016", "http://online.anyflip.com/vfou/mmep/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse03, "issue 3", "April 2015", "http://online.anyflip.com/vfou/otkl/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse02, "issue 2", "April 2014", "http://online.anyflip.com/vfou/dypu/mobile/index.html"));
        magazines.add(new MagazineObject(R.drawable.petropulse01, "issue 1", "January 2013", "http://online.anyflip.com/vfou/gcjx/mobile/index.html"));
*/
        magazineAdapter = new MagazineAdapter(magazines , getActivity() , null);
        magazineRecyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));
        magazineRecyclerView.setAdapter(magazineAdapter);


        /*MagazineAdapter Adapter = new MagazineAdapter(getActivity(), magazines);
        GridView gridView = (GridView) rootview.findViewById(R.id.magazine);
        gridView.setAdapter(Adapter);
        */
        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MagazineObject magazine = magazines.get(i);
                String URL = magazine.getmUrl();
                Intent intent = new Intent(getActivity(), webView.class);
                intent.putExtra("url", URL);
                startActivity(intent);
            }
        });
*/

        return rootView;
    }


    private void callApi() {
        ApiService apiService = WebServiceClient.getRetrofit().create(ApiService.class);
        Call<MagazineResponse> call = apiService.getMagazines();
        call.enqueue(new Callback<MagazineResponse>() {
            @Override
            public void onResponse(Call<MagazineResponse> call, Response<MagazineResponse> response) {
                Log.e("success" , response.body().getMagazineModels().get(0).getTitle());
                if(response.isSuccessful()) {
                    magazines = (ArrayList<MagazineModel>) response.body().getMagazineModels();
                    magazineAdapter = new MagazineAdapter(magazines, getActivity(), new MagazineAdapter.OnMagazineListener() {
                        @Override
                        public void onMagazineClick(int position) {
                            MagazineModel magazineModel = magazines.get(position);
                            String URL = magazineModel.getLink();
                            Intent intent = new Intent(getActivity(), webView.class);
                            intent.putExtra("url", URL);
                            startActivity(intent);
                        }
                    });
                    magazineRecyclerView.setAdapter(magazineAdapter);
                    progressBar.setVisibility(View.GONE);
                }
                else {
                    Toast.makeText(getActivity(), "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MagazineResponse> call, Throwable t) {
                Log.e("Failed" , t.getMessage() + "");
                progressBar.setVisibility(View.GONE);
                mEmptyStateText.setText("Check Your Internet Connection");
            }
        });
    }


}
