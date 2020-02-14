package net.aapgsuez.aapgsuez;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Assem on 9/19/2017.
 */

public class WebViewClass extends WebViewClient {
    final WebView wv;

    public WebViewClass(WebView webView) {
        this.wv = webView;
    }

    @Override
    public void onLoadResource(WebView view, String url) {

        try {
            wv.loadUrl("javascript:(function() { " +
                    "var head = document.getElementsByClassName('top-bar')[0].style.display='none'; " +
                    "})()");
            wv.loadUrl("javascript:(function() { " +
                    "var head = document.getElementsByClassName('container')[0].style.display='none'; " +
                    "})()");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onPageFinished(WebView view, String url) {
        wv.loadUrl("javascript:(function() { " +
                "var head = document.getElementsByClassName('top-bar')[0].style.display='none'; " +
                "})()");
        wv.setVisibility(View.VISIBLE);

        view.clearCache(true);
    }

}
