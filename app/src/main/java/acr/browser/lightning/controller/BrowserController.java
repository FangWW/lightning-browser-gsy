/*
 * Copyright 2014 A.C.R. Development
 */
package acr.browser.lightning.controller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;

import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;

import acr.browser.lightning.view.x5.X5WebView;

public interface BrowserController {

	void updateUrl(String title, boolean shortUrl);

	void updateProgress(int n);

	void onProgressChanged(int n);

	void updateHistory(String title, String url);

	void openFileChooser(ValueCallback<Uri> uploadMsg);

	void update();

	void onLongPress();

	void onShowCustomView(View view, int requestedOrientation, IX5WebChromeClient.CustomViewCallback callback);

	void onHideCustomView();

	Bitmap getDefaultVideoPoster();

	View getVideoLoadingProgressView();

	void onCreateWindow(boolean isUserGesture, Message resultMsg);

	Activity getActivity();

	void hideActionBar();

	void showActionBar();

	void toggleActionBar();

	void longClickPage(String url);

	void openBookmarkPage(X5WebView view);

	void showFileChooser(ValueCallback<Uri[]> filePathCallback);

	void closeEmptyTab();

	boolean isIncognito();

	boolean isProxyReady();

	int getMenu();

	void onPageFinished();

	void onPageStarted();
}
