import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.qr_corona_tracker_app.R;

<a class="twitter-timeline" href="http://twitter.com/WHO" data-widget-id="394415351972114432">Tweets about "#WHO"</a>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>


public class MainActivity extends ActionBarActivity {

    public static final String TAG = "TimeLineActivity";

    private static final String baseURl = "http://twitter.com";

    private static final String widgetInfo = "<a class=\"twitter-timeline\" href=\"http://twitter.com/search?q=%23BresTram\" data-widget-id=\"394415351972114432\">Tweets about \"#BresTram\"</a> " +
            "<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load_background_color();

        WebView webView = (WebView) findViewById(R.id.timeline_webview);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8", null);
    }


    private void load_background_color() {
        WebView webView = (WebView) findViewById(R.id.timeline_webview);
        //webView.setBackgroundColor(getResources().getColor(R.color.twitter_dark));
        webView.setBackgroundColor(0); // transparent
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
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        tools:context=".Latest Coronavirus News" >

<WebView
        android:id="@+id/timeline_webview"
                android:layout_width="fill_parent"
                android:layout_height="fill_parent"/>

</RelativeLayout>

<uses-permission android:name="android.permission.INTERNET" />
//this has to go into activity?