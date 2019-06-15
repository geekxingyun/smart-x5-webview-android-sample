package com.xingyun.smartx5webviewsample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.xingyun.smartx5webviewsample.custom.X5WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.myX5WebView)
    X5WebView myX5WebView;

    private static final String BASE_URL="http://www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        myX5WebView.clearCache(true);
        myX5WebView.clearHistory();
        myX5WebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {
                Log.d("swallow","shouldOverrideUrlLoading------>"+url);
                if(url.startsWith("http://")||url.startsWith("https://")){
                    webView.loadUrl(url);
                    return true;
                }else{
                    return false;
                }
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                Log.d("swallow","onPageStarted------->"+s);
                super.onPageStarted(webView, s, bitmap);
            }


            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                Log.d("swallow","onPageFinished------->"+s);
                webView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
            }

            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
        });
        myX5WebView.loadUrl(BASE_URL);
    }
}
