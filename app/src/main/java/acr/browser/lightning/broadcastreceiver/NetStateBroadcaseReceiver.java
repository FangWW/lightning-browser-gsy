/*
 * 深圳市高搜易信息技术有限公司
 */
package acr.browser.lightning.broadcastreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import acr.browser.lightning.utils.NetworkUtils;

/**
 * 网络变化监听
 *
 * @author FangJW
 * @Date 15/9/22
 */
public class NetStateBroadcaseReceiver extends BroadcastReceiver {
    private static NetStateBroadcaseReceiver mNetStateBroadcaseReceiver;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ww", "NetStateBroadcaseReceiver=" + NetworkUtils.isNetworkAvailable(context));
        if (context instanceof NetStateChangeListener) {
            ((NetStateChangeListener) context).onNetStateChange(NetworkUtils.isNetworkAvailable(context));
        }
    }

    public static NetStateBroadcaseReceiver registerReceiver(Activity act) {
        mNetStateBroadcaseReceiver = new NetStateBroadcaseReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        act.registerReceiver(mNetStateBroadcaseReceiver, filter);
        mNetStateBroadcaseReceiver.onReceive(act, null);
        return mNetStateBroadcaseReceiver;
    }

    public static void unregisterReceiver(Activity act) {
        if (mNetStateBroadcaseReceiver != null) {
            act.unregisterReceiver(mNetStateBroadcaseReceiver);
        }
    }


}
