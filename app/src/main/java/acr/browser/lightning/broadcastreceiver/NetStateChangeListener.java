/*
 * 深圳市高搜易信息技术有限公司
 */
package acr.browser.lightning.broadcastreceiver;

/**
 * 网络改变通知接口
 *
 * @author FangJW
 * @Date 15/9/22
 */
public interface NetStateChangeListener {
    public void onNetStateChange(boolean isNetConnected);
}
