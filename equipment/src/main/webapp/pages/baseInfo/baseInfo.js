Ext.onReady(function() {

	// 定义自动当前页行号
	var rownum = new Ext.grid.RowNumberer({
		header : '序号',
		width : 40
	});

	// 定义列模型
	var cm = new Ext.grid.ColumnModel([rownum,{
	    	header : '档案编号', // 列标题
			dataIndex : 'employeeid', // 数据索引:和Store模型对应
			sortable : true	// 是否可排序
		}, {
			header : '姓名',
			dataIndex : 'employeename'
		}, {
			header : '性别',
			dataIndex : 'sex'
		}, {
			header : '出生日期',
			dataIndex : 'telephone'
		}, {
			header : '民族',
			dataIndex : 'address'
		}, {
			header : '婚姻状况',
			dataIndex : 'employeebarcode'
		}, {
			header : '隶属部门编码',
			dataIndex : 'deptid'
		}, {
			header : '隶属部门名称',
			dataIndex : 'deptname'
		}, {
			header : '工号',
			dataIndex : 'employeenum'
		}, {
			header : '隶属工作组',
			dataIndex : 'teamname'
		
		}, {
			header : '员工状态',
			dataIndex : 'isquit'
		}]);

	//grid的数据存储模型
	var store = new Ext.data.Store({
		// 获取数据的方式
		proxy : new Ext.data.HttpProxy({
			url : 'query'
		}),
		// 数据读取器
		reader : new Ext.data.JsonReader({
			totalProperty : 'TOTALCOUNT', // 记录总数
			root : 'ROOT' // Json中的列表数据根节点
			}, [{
				name : 'employeeid' // Json中的属性Key值
			}, {
				name : 'employeename'
			}, {
				name : 'employeebarcode'
			}, {
				name : 'telephone'
			}, {
				name : 'address'
			}, {
				name : 'deptid'
			}, {
				name : 'deptname'
			}, {
				name : 'teamid'
			}, {
				name : 'teamname'
			}, {
				name : 'employeenum'
			}, {
				name : 'sex'
			}, {
				name : 'isquit'
			}]
		)					
	});
	
	// 每页显示条数下拉选择框
	var pagesize_combo = new Ext.form.ComboBox({
		name : 'pagesize',
		triggerAction : 'all',
		mode : 'local',
		store : new Ext.data.ArrayStore({
			fields : ['value', 'text'],
			data : [[10, '10条/页'], 
			  [20, '20条/页'], 
			  [50, '50条/页'], 
			  [100, '100条/页'], 
			  [250, '250条/页'], 
			  [500, '500条/页']]
		}),
		valueField : 'value',
		displayField : 'text',
		value : '20',
		editable : false,
		width : 85		
	});

	// 改变每页显示条数reload数据
	pagesize_combo.on("select", function(comboBox) {
		bbar.pageSize = parseInt(comboBox.getValue());
		number = parseInt(comboBox.getValue());
		store.reload({
			params : {
				start : 0,
				limit : bbar.pageSize
			}
		});		
	});
	
	var number = parseInt(pagesize_combo.getValue());
	// 分页工具栏
	var bbar = new Ext.PagingToolbar({
		pageSize : number,
		store : store,
		displayInfo : true,
		displayMsg : '显示{0}条到{1}条,共{2}条',
		emptyMsg : "没有符合条件的记录",
		items : ['-', '&nbsp;&nbsp;', pagesize_combo]		
	});
	
	// 表格工具栏
	var tbar = new Ext.Toolbar({
		items : [{
			text : '获取',
			iconCls : 'page_findIcon',
			handler : function() {
				queryData();
			}
		},'-',{
			text : '添加',
			iconCls : 'addIcon',
			handler : function() {
				
			}
		},'-',{
			text : '删除',
			iconCls : 'deleteIcon',
			handler : function() {
				
			}
		},'-',{
			text : '修改',
			iconCls : 'edit1Icon',
			handler : function() {
				
			}
		},'-',{
			text : '查询',
			iconCls : 'previewIcon',
			handler : function() {
				
			}
		}]		
	});

	// 表格实例
	var grid = new Ext.grid.GridPanel({
		region : 'center', // 和VIEWPORT布局模型对应，充当center区域布局
		margins : '3 3 3 3',
		// collapsible : true,
		border : false,
		// 表格面板标题
		title : '<span class="commoncss">员工信息</span>',
		height : 800,
		autoScroll : true,
		frame : true,
		store : store, // 数据存储
		stripeRows : true, // 斑马线
		cm : cm, // 列模型
		tbar:tbar, //顶部工具栏
		bbar : bbar,
		loadMask : {
			msg : '正在加载表格数据,请稍等...'
		}		
	});
	
	// 监听行选中事件
	grid.on('rowclick', function(pGrid, rowIndex, event) {

	});
	grid.on('rowdblclick', function(grid, rowIndex, event) {
		
	});
	
	var hospitalStore = new Ext.data.SimpleStore({
		fields : ['name', 'code'],
		data : [['郑城镇中心卫生院', '0001'], ['仲村镇中心卫生院', '0002']]
	});
	
	var clinicStore = new Ext.data.SimpleStore({
		fields : ['name', 'code'],
		data : [['马家洼村卫生室', '0001']]
	});	
	
	var villageStore = new Ext.data.SimpleStore({
		fields : ['name', 'code'],
		data : [['马家洼村', '0001'], ['福安村', '0002'], ['黑风口', '0003']]
	});
	
	//员工信息表单
	var infoForm = new Ext.form.FormPanel({	
		id : 'infoForm',
		region : 'center',
		margins : '3 3 3 3',
		border : true,
		//labelWidth : 90, // 标签宽度
		frame : true, //是否渲染表单面板背景色
		labelAlign : 'right', // 标签对齐方式
		bodyStyle : 'padding:3 5 3 3', // 表单元素和表单面板的边距		
		items : [{
			layout : 'column',
			border : false,
			items : [{
				columnWidth : .2,
				layout : 'form',
				labelWidth : 80, // 标签宽度
				defaultType : 'textfield',
				border : false,
				items : [new Ext.form.ComboBox({
					id : 'hospital',
					hiddenName : 'hospital',
					fieldLabel : '卫生院',
					triggerAction : 'all',
					store : hospitalStore,
					displayField : 'name',
					valueField : 'code',
					mode : 'local',
					forceSelection : true,
					typeAhead : true,
					value : '0001',
					resizable : true,
					anchor : '95%'
				})]
			}, {
				columnWidth : .2,
				layout : 'form',
				labelWidth : 80, // 标签宽度
				defaultType : 'textfield',
				border : false,
				items : [
					new Ext.form.ComboBox({
						id : 'clinic',
						hiddenName : 'clinic',
						fieldLabel : '卫生室',
						triggerAction : 'all',
						store : clinicStore,
						displayField : 'name',
						valueField : 'code',
						mode : 'local',
						forceSelection : true,
						typeAhead : true,
						value : '0001',
						resizable : true,
						anchor : '95%'
					})]
			}, {
				columnWidth : .2,
				layout : 'form',
				labelWidth : 80, // 标签宽度
				defaultType : 'textfield',
				border : false,
				items : [
					new Ext.form.ComboBox({
						id : 'village',
						hiddenName : 'village',
						fieldLabel : '自然村',
						triggerAction : 'all',
						store : villageStore,
						displayField : 'name',
						valueField : 'code',
						mode : 'local',
						forceSelection : true,
						typeAhead : true,
						value : '0001',
						resizable : true,
						anchor : '95%'
				})]
			}]
		}]
	});
	
	
	//布局
	var viewport = new Ext.Viewport({
		layout : 'border',
		items : [{
			region : 'north',
			margins : '3 3 3 3',
			split : true,
			collapsible : false,
			height : 80
		}, {
			region : 'west',
			margins : '3 3 3 3',
			split : true,
			collapsible : true,
			width:240
		}, {
			region : 'center',
			items : [infoForm,grid]
		}]
	});
	
	function queryData(){
		var hospital = Ext.getCmp('hospital').getValue();
		var clinic = Ext.getCmp('clinic').getValue();
		var village = Ext.getCmp('village').getValue();
		var params = {};
		params.hospital = hospital;
		params.clinic = clinic;
		params.village = village;
		Ext.Ajax.request({
			method:'POST',//提交的方式,如Get，post等
			url:'query',//请求地址
			params:params,
			success:function(reps,option){
			   reps.responseText;//此为后台成功返回的json等字符
			},//成功的回调函数    
			failure:function(res){
			      
			}//失败的情况
		})
	}
})