Ext.define('equip.view.Viewport', {
    extend: 'Ext.container.Viewport',
    //布局方式：border
    layout: 'border',
    items: [{
        title:'基于Java EE的设备售后服务系统',
        collapisble: true,
        region:'north',
        height: 120,
        html: '<br><center><font size=5>MVC模式实现的ExtJS案例</font><br><font size=2>源码来源:ITLee博客</font></center>'
    },{
        title: '系统菜单',
        region: 'west',
        width: 240,
        split: true,
        collapisble: true,
        items:[{
			xtype: 'menutree'
		}]
    }, {
        id: 'mainContent',
        title: '主题内容显示',
        layout: 'fit',
        region: 'center',
        collapisble: true,
        contentEl: 'contentIframe'
    }]
});
