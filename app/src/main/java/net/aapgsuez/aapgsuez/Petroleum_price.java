package net.aapgsuez.aapgsuez;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import static android.content.Context.CONNECTIVITY_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Petroleum_price extends Fragment {
    WebView webView;
    public TextView textView;

    public Petroleum_price() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webview,container,false);
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.home_btn);
        fab.setVisibility(View.GONE);
        webView = (WebView) rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        if (!isNetworkAvailable()) {
            textView = (TextView)rootView.findViewById(R.id.textforerror);
            textView.setText("No Internet Connection");
        }else{
            webView.loadUrl("http://aapgsuez.net/android/widget.html");
            // Force links and redirects to open in the WebView instead of in a browser
            webView.setWebViewClient(new WebViewClass(webView));
        }
        return rootView;
    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
