package com.example.qr_corona_tracker_app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.annotation.TargetApi;

class TwitterHandle extends Activity {

    private WebView mWebview ;

<<<<<<< HEAD
=======
public class TwitterHandle extends AppCompatActivity {
    public static final String TAG = "TimeLineActivity";
    private static final String baseURl = "http://twitter.com";
    private static final String widgetInfo = "<a class=\"twitter-timeline\" href=\"http://twitter.com/WHO\" data-widget-id=\"394415351972114432\">Tweets about \"#WHO\"</a> " +
            "<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>";

>>>>>>> 9d0c83154775dfc04f06ab6755e1c861c399f0ba
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mWebview  = new WebView(this);

<<<<<<< HEAD
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        mWebview.setWebViewClient(new WebViewController());
        mWebview .loadUrl("https://twitter.com/WHO");
        setContentView(mWebview );

    }
    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
=======
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
>>>>>>> 9d0c83154775dfc04f06ab6755e1c861c399f0ba
    }
}
