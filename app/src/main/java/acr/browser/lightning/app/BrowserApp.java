package acr.browser.lightning.app;

import android.app.Application;
import android.content.Context;

import acr.browser.lightning.utils.NetworkUtils;

public class BrowserApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        init();
    }

    private void init() {
        AppConfig.isNetConnected = NetworkUtils.isNetworkAvailable(context);
//        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    public static Context getAppContext() {
        return context;
    }
}
