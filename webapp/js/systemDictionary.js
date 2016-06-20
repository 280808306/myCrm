/**
 * 数据字典界面的js
 * @zh
 */
// 1.dataGrid相关操作  可以将相同的抽取出来传入 改变的东西
$(function(){
	
	//列表url
	var listUrl = '/systemDictionary/list';
	
	//添加、修改url
	var editUrl = '/systemDictionary/edit';
	
	//删除的url地址
	var deleteUrl = '/systemDictionary/delete';
	
	// 初始化dataGrid
	// 定义变量 方便使用grid控件
	var systemDictionaryDg = $("#systemDictionary-datagrid");
	// 弹出模态框dialog
	var systemDictionaryDlg = $("#systemDictionary-dialog");
	//修改 添加表单
	var systemDictionaryForm = $("#systemDictionary-form");
	//搜索输入框
	var systemDictionarySearchBox = $("#systemDictionary-searchbox");
	//搜索的dialog
	var systemDictionarySearchDlg = $("#systemDictionary-search-dialog");
	//搜索表单
	var systemDictionarySearchForm = $("#systemDictionary-search-form");
	
	/**
	 * 详细表格
	 */
	var systemDictionaryItemDg = $("#systemDictionaryItem-datagrid");
	
	/**
	 * 缓存查询的父id 不用重复加载
	 */
	var parentId = '';
	
	// 含有 data-cmd 属性 方法点击的监听事件
	var btnClickMethodsObj = {
	    // 保存操作
		'save':function(){
			//清空表单放置 缓存
			systemDictionaryForm.form("clear");
			
			//弹出dialog
			systemDictionaryDlg.dialog("open");
		},
		'update':function(){
			//清空菜单避免数据混淆
			systemDictionaryForm.form("clear");
			//获取表单中 选中的行 的数据
			var row = systemDictionaryDg.datagrid("getSelected");
			if(row){
				//如果选中了行   回显数据弹出 dialog
				//回显数据
				systemDictionaryForm.form("load", row);
				
				//修改标题
				systemDictionaryDlg.dialog("setTitle","修改数据字典");
				//开启修改的dialog
				systemDictionaryDlg.dialog("open");
			} else {
				$.messager.alert("温馨提示","请选择一行","info");
			}
		},
		'delete':function(){
			//获取选中行的数据
			var row = systemDictionaryDg.datagrid("getSelected");
			if(row){
				$.messager.confirm('你确定要删除吗？', '删除该字典，该字典对应的详细也会删除,请谨慎操作。', function(r){
					if (r){
						//发送ajax请求来 实现删除功能
						$.post(deleteUrl,{id:row.id},function(result){
							console.debug(result);
							if(result.status){
								//刷新界面
								systemDictionaryDg.datagrid("reload");
								systemDictionaryItemDg.datagrid("reload");
							}else {
								$.messager.alert("温馨提示","删除失败："+result.msg,'error');
							}
						},'json');
					}
				});
			}else {
				$.messager.alert("温馨提示","需要选中删除行",'info');
			}
		},
		'refresh':function(){
			systemDictionaryDg.datagrid("reload");
		},
		//添加 / 修改确定
		'editSubmit':function(){
			//进行表单的提交操作
			systemDictionaryForm.form('submit', {    
			    url:editUrl,    
			    onSubmit: function(){    
			        return systemDictionaryForm.form("validate");
			    },    
			    success:function(result){    
			        console.debug(result); 
			        var data = $.parseJSON(result);
			        if(data.status){
			        	//关闭dialog
			        	systemDictionaryDlg.dialog("close");
			        	//提示
			        	$.messager.alert('温馨提示', data.msg,'info',function(){
			        		//用户点击确定
			        		//刷新dataGrid
			        		systemDictionaryDg.datagrid("reload");
			        	});
			        } else {
			        	$.messager.alert('温馨提示', "操作失败：" + data.msg +",请稍后再试！",'error');
			        }
			    }    
			}); 
		},
		'editCancel':function(){
			systemDictionaryDlg.dialog("close");
		},
		'editReset':function(){
			systemDictionaryForm.form('clear');
		},
		//搜索dialog的按钮
		'search':function(){
			systemDictionarySearchDlg.dialog('open');
		},
		'searchSubmit':function(){
			//直接调用dataGrid的加载数据的方法
			//将表单里的参数序列化成json对象
			var paramObj = systemDictionarySearchForm.serializeJson();
			//			var params = systemDictionarySearchForm.serializeArray();
			//			for (var index in params) {
			//				var param = params[index];
			//				if(param.value && param.value != ''){
			//					paramObj[param.name] = param.value;
			//				}
			//			}
			//关闭dialog
			systemDictionarySearchDlg.dialog("close");
			//加载数据
			systemDictionaryDg.datagrid('load',paramObj);
		},
		'searchReset':function(){
			systemDictionarySearchForm.form('clear');
		},
		'searchCancel':function(){
			//关闭dialog
			systemDictionarySearchDlg.dialog("close");
		}
	};
	
	//初始化dataGrid
	systemDictionaryDg.datagrid({    
		//请求地址
	    url:listUrl,
	    // 标题
	    title:'数据字典列表',
	    fit:true,
	    //无边框
	    border:false,
	    //内容适应列的大小
	    fitColumns:true,
	    //不自动高度
	    autoRowHeight:false,
	    pagination:true,
	    //只显示一行
	    nowrap:true,
	    loadMsg:'数据正在加载中，请稍等哒~',
	    //显示分页条
	    pagination:true,
	    //测试的时候显示行号
	    rownumbers:true,
	    //单选
	    singleSelect:true,
	    //滚动条宽度
	    scrollbarSize:20,
	    
	    /**
 			//	ID	id	主键，系统自动生成	数据库自动生成
			private Long id;
			//	字典目录编号	sn		文本
			private String sn;
			//	字典目录名称	name		文本
			private String name;
			//	字典目录简介	intro		文本
			private String intro;
			//	状态	state	1正常 -1停用	文本
			private Integer state;
			//	字典明细	details	一对多	明细对象
			private List<SystemDictionaryItem> details = new ArrayList<>();
	     */
	    columns:[[    
	        {field:'sn',title:'编号',width:80,align:'center'},    
	        {field:'name',title:'名称',width:80,align:'center'},    
	        {field:'state',title:'状态',width:80,align:'center',formatter:function(value,row,index){
	        	if(value){
	        		if(value == 1){
	        			return '<span style="color:green;">正常</span>';
	        		}else if(value == -1){
	        			return '<span style="color:red;">停用</span>';
	        		}else{
	        			return '<span style="color:gray;">未知</span>';
	        		}
	        	}else {
	        		return '';
	        	}
	        }},
	        
	        {field:'intro',title:'描述',width:160,align:'left'}
	    ]],
	    //工具条
	    toolbar:'#systemDictionary-toolbar',
	    // 双击刷新字典详细
	    onDblClickRow:function(rowIndex, row){
	    	if(parentId && row.id == parentId){
	    		$.messager.alert("别点了","已经加载详细了~~",'info');
	    	} else {
	    		parentId = row.id;
	    		systemDictionaryItemDg.datagrid("load",{'parentId':row.id});
	    	}
		}
	}); 
	
	//初始化dialog
	systemDictionaryDlg.dialog({
	 	title: '添加数据字典',    
	    width: 'auto',    
	    height: 'auto',  
	    //是否可以关闭
	    closed: true,  
	    // 模态框模式
	    modal: true,
	    //是否可以拖拽
	    draggable:true,
	    //添加底部的buttons
	    buttons:'#systemDictionary-dialog-buttons'
	});
	
	//监听所有的自己设置的按钮
	$("[data-cmd]").click(function(){
		//获取方法的名字
		var methodName = $(this).data("cmd");
		//根据方法名 btnClickMethodsObj 对象来调用方法
		if(methodName && btnClickMethodsObj[methodName]){
			btnClickMethodsObj[methodName]();
		}
	});
	
	//初始化搜索box
	systemDictionarySearchBox.searchbox({
		//搜索方法
		searcher:function(value,name){ 
			//搜索内容  调用datagrid的加载方法加载数据
			if(value && value !=''){
				systemDictionaryDg.datagrid('load',{
					name : value
				});
			}else {
				systemDictionaryDg.datagrid('load',{
				});
			}
		},
		//输入提示
		prompt:'输入数据字典名称搜索'
	});
	
	//初始化搜索dialog
	systemDictionarySearchDlg.dialog({
		title: '搜索',    
	    width: 'auto',    
	    height: 'auto',  
	    //是否可以关闭
	    closed: true,  
	    // 模态框模式
	    modal: true,
	    //是否可以拖拽
	    draggable:true,
	    //添加底部的buttons
	    buttons:'#systemDictionary-search-dialog-buttons'
	});
	
});