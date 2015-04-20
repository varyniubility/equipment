Ext.onReady(function(){
    //开启悬浮提示功能
    Ext.QuickTips.init();
    //开启动态加载
    Ext.Loader.setConfig({
        enabled: true
    });
    //创建应用程序的实例
    Ext.application({
        //设定命名空间
        name: 'equip',
        //指定配置选项，设置相应的路径
        appFolder: 'pages/common',
        //加载控制器
        controllers: ['equipController'],
        //自动加载和实例化Viewport文件
        autoCreateViewport: true
    });
});
