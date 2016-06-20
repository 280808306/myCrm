/**
 * 菜单管理界面相关的js
 */

// 1.dataGrid相关操作  可以将相同的抽取出来传入 改变的东西
$(function(){
	
	//列表url
	var listUrl = '/systemMenu/list';
	
	//添加、修改url
	var editUrl = '/systemMenu/edit';
	
	//删除的url地址
	var deleteUrl = '/systemMenu/delete';
	
	// 初始化dataGrid
	// 定义变量 方便使用grid控件
	var systemMenuDg = $("#systemMenu-datagrid");
	// 弹出菜单的模态框dialog
	var systemMenuDlg = $("#systemMenu-dialog");
	//修改 添加表单
	var systemMenuForm = $("#systemMenu-form");
	//搜索输入框
	var systemMenuSearchBox = $("#systemMenu-searchbox");
	//搜索的dialog
	var systemMenuSearchDlg = $("#systemMenu-search-dialog");
	//搜索表单
	var systemMenuSearchForm = $("#systemMenu-search-form");
	
	// 含有 data-cmd 属性 方法点击的监听事件
	var btnClickMethodsObj = {
	    // 保存操作
		'save':function(){
			//清空表单放置 缓存
			systemMenuForm.form("clear");
			
			//清除图标缓存
			$("#icon-systemMenu").attr("class", '');
			
			//弹出dialog
			systemMenuDlg.dialog("open");
		},
		'update':function(){
			//清空菜单避免数据混淆
			systemMenuForm.form("clear");
			//获取表单中 选中的行 的数据
			var row = systemMenuDg.datagrid("getSelected");
			if(row){
				//如果选中了行   回显数据弹出 dialog
				//处理回显数据 上级菜单回显的处理
				if(row.parent){
					//如果有上级菜单 将上级菜单的id取出来 添加一个和表单回显name相同的属性
					row['parent.id'] = row.parent.id;
				}
				if(row.permission){
					//如果有上级菜单 将上级菜单的id取出来 添加一个和表单回显name相同的属性
					row['permission.id'] = row.permission.id;
				}
				//回显数据
				systemMenuForm.form("load", row);
				
				//设置图标显示
				$("#icon-systemMenu").attr("class", $("#edit-icon-tr .textbox-value").val());
				
				//修改标题
				systemMenuDlg.dialog("setTitle","修改菜单");
				//开启修改的dialog
				systemMenuDlg.dialog("open");
			} else {
				$.messager.alert("温馨提示","请选择一行","info");
			}
		},
		'delete':function(){
			//获取选中行的数据
			var row = systemMenuDg.datagrid("getSelected");
			if(row){
				$.messager.confirm('你确定要删除吗？', '删除后无法恢复，请谨慎选择。', function(r){
					if (r){
						//发送ajax请求来 实现删除功能
						$.post(deleteUrl,{id:row.id},function(result){
							console.debug(result);
							if(result.status){
								//刷新界面
								systemMenuDg.datagrid("reload");
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
			systemMenuDg.datagrid("reload");
		},
		//添加 / 修改确定
		'editSubmit':function(){
			//进行表单的提交操作
			systemMenuForm.form('submit', {    
			    url:editUrl,    
			    onSubmit: function(){    
			        return systemMenuForm.form("validate");
			    },    
			    success:function(result){    
			        console.debug(result); 
			        var data = $.parseJSON(result);
			        if(data.status){
			        	//关闭dialog
			        	systemMenuDlg.dialog("close");
			        	//提示
			        	$.messager.alert('温馨提示', data.msg,'info',function(){
			        		//用户点击确定
			        		//刷新dataGrid
			        		systemMenuDg.datagrid("reload");
			        	});
			        } else {
			        	$.messager.alert('温馨提示', "操作失败：" + data.msg +",请稍后再试！",'error');
			        }
			    }    
			}); 
		},
		'editCancel':function(){
			systemMenuDlg.dialog("close");
		},
		'editReset':function(){
			systemMenuForm.form('clear');
			//清除图标缓存
			$("#icon-systemMenu").attr("class", '');
		},
		//搜索dialog的按钮
		'search':function(){
			systemMenuSearchDlg.dialog('open');
		},
		'searchSubmit':function(){
			//直接调用dataGrid的加载数据的方法
			//将表单里的参数序列化成json对象
			var paramObj = systemMenuSearchForm.serializeJson();
			/*
			var params = systemMenuSearchForm.serializeArray();
			 * for (var index in params) {
				var param = params[index];
				if(param.value && param.value != ''){
					paramObj[param.name] = param.value;
				}
			}*/
			//关闭dialog
			systemMenuSearchDlg.dialog("close");
			//加载数据
			systemMenuDg.datagrid('load',paramObj);
		},
		'searchReset':function(){
			systemMenuSearchForm.form('clear');
		},
		'searchCancel':function(){
			//关闭dialog
			systemMenuSearchDlg.dialog("close");
		}
	};
	
	//初始化dataGrid
	systemMenuDg.datagrid({    
		//请求地址
	    url:listUrl,
	    // 标题
	    title:'菜单列表',
	    //大小自适应
	    fit:true,
	    //无边框
	    border:false,
	    //内容适应列的大小
	    fitColumns:true,
	    //不自动高度
	    autoRowHeight:false,
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
	     * 		//ID Id	主键，系统自动生成 数据库自动生成	
				private Long id;
				// 菜单编号 sn 文本 必须	
				private String sn;
				// 菜单名称 name 文本 必须
				private String name;
				// 上级菜单 parent 菜单对象
				private SystemMenu parent;
				//图标	icon 文本	
				private String icon;
				//地址	url	文本	
				private String url;
				//简介	intro 文本	
				private String intro;
	     */
	    columns:[[    
	        {field:'sn',title:'编号',width:80,align:'center'},    
	        {field:'name',title:'名称',width:80,align:'center'},    
	        {field:'parent',title:'父菜单名称',width:80,align:'center',formatter:objectFormatter},
	        {field:'icon',title:'菜单图标',width:80,align:'center',
	        	//特殊的图标显示formatter
	        	formatter: function(value,row,index){
	        		if(value){
	        			return '<span class="tree-icon tree-file '+value+'"></span>';
	        		}else {
	        			return '';
	        		}
			    }
	        },
	        {field:'url',title:'地址',width:80,align:'left'},
	        {field:'permission',title:'权限',width:80,align:'left',formatter:objectFormatter},
	        {field:'intro',title:'描述',width:160,align:'left'}
	    ]],
	    //工具条
	    toolbar:'#systemMenu-toolbar'
	}); 
	
	//初始化dialog
	systemMenuDlg.dialog({
	 	title: '添加菜单',    
	    width: 'auto',    
	    height: 'auto',  
	    //是否可以关闭
	    closed: true,  
	    // 模态框模式
	    modal: true,
	    //是否可以拖拽
	    draggable:true,
	    //添加底部的buttons
	    buttons:'#systemMenu-dialog-buttons'
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
	
	//图标修改失去焦点时 
	$("#edit-icon-tr .textbox-text").blur(function(){
		$("#icon-systemMenu").attr("class", $("#edit-icon-tr .textbox-value").val());
	});
	
	//初始化搜索box
	systemMenuSearchBox.searchbox({
		//搜索方法
		searcher:function(value,name){ 
			//搜索内容  调用datagrid的加载方法加载数据
			if(value && value !=''){
				systemMenuDg.datagrid('load',{
					name : value
				});
			}else {
				systemMenuDg.datagrid('load',{
				});
			}
		},
		//输入提示
		prompt:'输入菜单名搜索'
	});
	
	//初始化搜索dialog
	systemMenuSearchDlg.dialog({
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
	    buttons:'#systemMenu-search-dialog-buttons'
	});
});
