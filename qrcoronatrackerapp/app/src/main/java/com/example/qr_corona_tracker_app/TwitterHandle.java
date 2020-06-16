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
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class TwitterHandle extends AppCompatActivity {
    public static final String TAG = "TimeLineActivity";
    private static final String baseURl = "http://twitter.com";
    private static final String widgetInfo = "<a class=\"twitter-timeline\" href=\"http://twitter.com/WHO\" data-widget-id=\"394415351972114432\">Tweets about \"#WHO\"</a> " +
            "<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_handle);

        load_background_color();

        WebView webView = (WebView) findViewById(R.id.timeline_webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8",null);
    }

    private void load_background_color () {
        WebView webView = (WebView) findViewById(R.id.timeline_webview);
        webView.setBackgroundColor(0);

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
