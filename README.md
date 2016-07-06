###借鉴闪电浏览器+腾讯x5内核 包裹出web-app
###使用腾讯x5内核 能保证web页面兼容性比较好
###做好各种web事件拦截

###hybrid-app(混合app)
    如京东app(部分wap部分native结合使用)
    Phonegap
    页面都在本地app中(速度和展示效果可能比较好)
    ajax  访问网络  返回json数据然后展示页面

###web-app
    纯wap
    手机淘宝: [https://m.taobao.com/#index](https://m.taobao.com/#index)

###native-app
    一般应用



| 对比       |  Web App（网页应用)          |Hybrid App（混合应用）|Native App（原生应用)|
| ------------- |:-------------:|:-------------:|:-------------:|
|开发成本 |低  |中  |高  |
|维护更新 |简单|简单|复杂|
|体验     |差  |中  |优  |
|Store或market认可|不认可|认可|认可|
|安装         |不需要    |需要|需要|
|跨平台       |优         |优 |差  |





###权限和其他需要考虑问题:
      定位
      推送
      页面统计(客户端和服务端都需要做?)
      拍照
      文件
      分享(h5可以做)   手机定义share:  (tel: 之类的,但是这样子普通网页又不能分享了)   
      app版本跟新(强制和非强制)
      启动(页面)和退出
      当没有网络的时候


###手机浏览器访问百度以图搜图页面

| 对比       | Ios           |Android4.2.2|
| ------------- |:-------------:|:-------------:|
|系统浏览器|相机/相册|相机/相册/文件管理器|
|Uc浏览器|相机/相册|相机/相册/文件管理器|

###手机浏览器访问百度地图

| 对比       | Ios           |Android4.2.2|
| ------------- |:-------------:|:-------------:|
|系统浏览器|可以定位(需要赋予权限)|可以定位(需要赋予权限)|
|Uc浏览器|可以定位(需要赋予权限)|可以定位(需要赋予权限)|



![yy](https://raw.githubusercontent.com/FangWW/lightning-browser-gsy/master/58_view.png "yy")





###客户端反馈给服务端
###约定接口:
    按下返回键(只关乎android,ios应该不需要?) 客户端调用js的onBackPressed
    onBackPressed  通过返回true&false是否屏蔽调自身返回键
    onBackPressedHandled(Boolean ) 处理过返回键 boolean是否交给下一级处理
    //ios好像可以直接获取js reture返回值;android这边不能直接获取  android这边需要促发再次回调另外方法去回调

###在h5主页面 再次按下返回键即退出应用 ios是否需要?
    onExit

###客户端生命周期函数系列  通知js (创建,前台,后台,销毁等等...)
    onCreate
    onTop
    OnBackground
    onDestroy
    ....

###
    平滑返回如uc浏览器 
    
    推送页面跳转接口协议 
    
    有网络根据服务端的响应头缓存cache-control去缓存
    无网络强制取缓存


###h5优先加载html和css   javascript延迟加载
[http://gaibing2009.diandian.com/post/2012-08-07/40035127817](http://gaibing2009.diandian.com/post/2012-08-07/40035127817)
###常见js库(jQuery)写在本地app
[http://blog.csdn.net/dliyuedong/article/details/46947007](http://blog.csdn.net/dliyuedong/article/details/46947007)

###图片延迟加载,但是要提起把图片的大小预留出来

###一个漂亮的h5框架:http://dev.dcloud.net.cn/mui/

    一些国产手机浏览器，为了制造“极速”的假象，缓存处理很多地方都没有按照规范来，动不动就会过度缓存，导致页面不能及时更新。Android Webview的LOAD_CACHE_ELSE_NETWORK设置更是完全无视etag、expire time这些，强制使用缓存。


    把所有的html css js和主要的图片资源离线存储在Android的asset文件夹下，然后由Android实现从服务器端到手机的这个www主文件夹的更新机制
 
    各种提示和对话框需要调用原生app?

