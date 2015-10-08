package acr.browser.lightning.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.widget.ImageView;

import acr.browser.lightning.R;


public class LoadDialog extends Dialog {

    private AnimationDrawable animationDrawable;

    public LoadDialog(Context context) {
        super(context, R.style.CustomProgressDialog);
        this.setContentView(R.layout.load_dialog);
        this.getWindow().getAttributes().gravity = Gravity.CENTER;
//        this.setCancelable(false);
        ImageView iv_load = (ImageView) this.findViewById(R.id.iv_load);
        if (iv_load != null) {
            animationDrawable = (AnimationDrawable) iv_load.getBackground();
            animationDrawable.start();
        }
    }
}
