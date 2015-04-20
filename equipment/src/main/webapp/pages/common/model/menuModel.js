Ext.define('equip.model.menuModel', {
    extend: 'Ext.data.Model',
    fields:[
        {name:'id', type:'string'},
        {name:'pid', type:'string'},
        {name:'text', type:'string'},
        //type为布尔型时，后面的默认值是必须写的，要不会出错
        {name:'leaf', type:'string'},
        {name: 'url', type:'string'}
    ]
});