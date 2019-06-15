package com.xingyun.smartx5webviewsample.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm;
import com.tencent.smtt.sdk.WebView;

public class X5WebView extends WebView {
	TextView title;

	@SuppressLint("SetJavaScriptEnabled")
	public X5WebView(Context arg0, AttributeSet arg1) {
		super(arg0, arg1);
//		 this.setWebChromeClient(chromeClient);
//		 WebStorage webStorage = WebStorage.getInstance();
		initWebViewSettings();
		this.getView().setClickable(true);
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void initWebViewSettings() {
		WebSettings webSetting = this.getSettings();

		webSetting.setJavaScriptEnabled(true);
		webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
		webSetting.setAllowFileAccess(true);
		webSetting.setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
		webSetting.setSupportZoom(true);
		webSetting.setBuiltInZoomControls(true);
		webSetting.setUseWideViewPort(true);
		webSetting.setSupportMultipleWindows(true);
		// webSetting.setLoadWithOverviewMode(true);
		webSetting.setAppCacheEnabled(true);
		// webSetting.setDatabaseEnabled(true);
		webSetting.setDomStorageEnabled(true);
		webSetting.setGeolocationEnabled(true);
		webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
		// webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
		webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
		// webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
		webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);

		// this.getSettingsExtension().setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);//extension
		// settings 的设计
	}

	@Override
	protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
		boolean ret = super.drawChild(canvas, child, drawingTime);
		return ret;
	}

	public X5WebView(Context arg0) {
		super(arg0);
		setBackgroundColor(85621);
	}
}
