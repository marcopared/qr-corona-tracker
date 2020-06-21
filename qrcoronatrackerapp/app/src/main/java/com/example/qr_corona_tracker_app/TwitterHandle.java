/**
 * Class to implement twitter timeline into WebView
 *
 * @author: Philip Emmanuele  -derived from: Julien Lengrand-Lambert
 * @coauthor Marco Paredes
 * @version: 1.0.0
 * @since 1.0
 */
package com.example.qr_corona_tracker_app;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

    public class TwitterHandle extends AppCompatActivity {
        private static final String baseURl = "http://twitter.com";
        private static final String widgetInfo = "https://twitter.com/who";
        //establishes parameters (??) that will be used later for loadDataWithBaseURL
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.twitter_handle);

            load_background_color();

            WebView webView = (WebView) findViewById(R.id.timeline_webview);
            //method call which locates WebView in layout file
            webView.getSettings().setDomStorageEnabled(true);
            //need to use local storage to store the website when it is called
            webView.getSettings().setJavaScriptEnabled(true);
            //JavaScript is disabled by default so we need to enable it for it to work in the app
            webView.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8",null);
            //links on the page need to know where they came from if clicked on, so this makes it so the code knows youre coming from twitter.com/who
        }
        private void load_background_color () {
            WebView webView = (WebView) findViewById(R.id.timeline_webview);
            webView.setBackgroundColor(0);
// class that establishes background of webview as transparent
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return true;
        }
    }
