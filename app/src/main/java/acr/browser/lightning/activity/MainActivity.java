package acr.browser.lightning.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.widget.Toast;

import acr.browser.lightning.R;
import acr.browser.lightning.app.AppConfig;
import acr.browser.lightning.broadcastreceiver.NetStateBroadcaseReceiver;
import acr.browser.lightning.broadcastreceiver.NetStateChangeListener;
import acr.browser.lightning.preference.PreferenceManager;
import acr.browser.lightning.view.LightningView;

@SuppressWarnings("deprecation")
public class MainActivity extends BrowserActivity implements NetStateChangeListener {

    CookieManager mCookieManager;
    public static final String HOME_URL = "http://m.gaosouyi.com";
    public static final String HOME_URL_INDEX = "http://m.gaosouyi.com/index/index.html";
    private long firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WelcomeActivity.gotoHere(MainActivity.this);
        searchTheWeb(HOME_URL);
    }

    @Override
    public void onBackPressed() {
        if (mCurrentView.getUrl().equals(HOME_URL) || mCurrentView.getUrl().equals(HOME_URL_INDEX)) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 800) {// 如果两次按键时间间隔大于800毫秒，则不退出
                Toast.makeText(MainActivity.this, "再按一次返回桌面",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;// 更新firstTime
                return;
            } else {
                finish();
            }
        }
        super.onBackPressed();
    }

    @Override
    public void updateCookiePreference() {
        mCookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            CookieSyncManager.createInstance(this);
        }
        mCookieManager.setAcceptCookie(PreferenceManager.getInstance().getCookiesEnabled());
        super.updateCookiePreference();
    }

    @Override
    public synchronized void initializeTabs() {
        restoreOrNewTab();
        // if incognito mode use newTab(null, true); instead
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        NetStateBroadcaseReceiver.registerReceiver(this);
    }


    @Override
    protected void onPause() {
        super.onPause();
        saveOpenTabs();
        NetStateBroadcaseReceiver.unregisterReceiver(this);
    }

    @Override
    public void updateHistory(String title, String url) {
        super.updateHistory(title, url);
        addItemToHistory(title, url);
    }

    @Override
    public boolean isIncognito() {
        return false;
    }

    @Override
    public int getMenu() {
        return R.menu.main;
    }

    @Override
    public void closeActivity() {
        closeDrawers();
        moveTaskToBack(true);
    }

    @Override
    public void onNetStateChange(boolean isNetConnected) {
        AppConfig.isNetConnected = isNetConnected;
        for (LightningView webView : mWebViews) {
            webView.getWebView().getSettings().setCacheMode(AppConfig.isNetConnected ? WebSettings.LOAD_DEFAULT : WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
    }
}
