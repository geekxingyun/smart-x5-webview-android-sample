package com.xingyun.smartx5webviewsample;

import android.app.Application;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化X5 浏览器内核
        initX5WebViewCore();
    }

    private void initX5WebViewCore() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("swallow", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
                Log.d("swallow", " onCoreInitFinished");
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(),  cb);
    }
}
