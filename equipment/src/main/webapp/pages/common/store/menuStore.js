Ext.define("equip.store.menuStore",{
	extend:'Ext.data.TreeStore',
	defaultRoodId:'root',
	requires: 'equip.model.menuModel',
	model: 'equip.model.menuModel',
	proxy:{
		type:'ajax',
		url:'pages/common/server/data.json',
		reader:'json',
		autoLoad:true
	}
});