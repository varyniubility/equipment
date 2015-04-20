Ext.define('equip.controller.equipController', {
    extend: 'Ext.app.Controller',
	views: ['Viewport','menuTree'],
	stores: ['menuStore'],
	model: ['menuModel']
});
