/**
 * Class to implement twitter timeline into WebView
 *
 * @author: Philip Emmanuele  -derived from: Julien Lengrand-Lambert
 * @coauthor Marco Paredes
 * @version: 1.0.0
 * @since 1.0
 */
package com.example.qr_corona_tracker_app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TwitterHandle extends Activity {
    private WebView webview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_handle);
        //where we want this code to display (specific xml file)

        String url = "http://twitter.com/WHO";
        //what webapge we want to go to

        webview = (WebView) findViewById(R.id.myWebView);
        webview.setWebViewClient(new MyWebViewClient());
        //makes it so webpage is viewed in app not in browser
        webview.getSettings().setJavaScriptEnabled(true);
        //enables Java
        webview.loadUrl(url);
        //loads the url
    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }
    }
}