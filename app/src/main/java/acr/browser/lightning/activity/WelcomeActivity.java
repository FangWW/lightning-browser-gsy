package acr.browser.lightning.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import acr.browser.lightning.R;
import acr.browser.lightning.app.AppConfig;
import acr.browser.lightning.broadcastreceiver.NetStateChangeListener;


public class WelcomeActivity extends Activity implements NetStateChangeListener {
    public static final long time = 2000;

    public static void gotoHere(Activity act) {
        act.startActivity(new Intent(act, WelcomeActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0, time);
    }


    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            Intent intent = new Intent(WelcomeActivity.this,
                    MainActivity.class);
            startActivity(intent);
            finish();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
//        NetStateBroadcaseReceiver.registerReceiver(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        NetStateBroadcaseReceiver.unregisterReceiver(this);
    }


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    @Override
    public void onNetStateChange(boolean isNetConnected) {
        AppConfig.isNetConnected = isNetConnected;
    }
}
