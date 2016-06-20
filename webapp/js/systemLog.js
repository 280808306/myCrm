/**
 * 菜单管理界面相关的js
 */

// 1.dataGrid相关操作  可以将相同的抽取出来传入 改变的东西
$(function(){
	
	//列表url
	var listUrl = '/systemlog/list';
	
	//删除的url地址
	var deleteUrl = '/systemlog/delete';
	
	// 初始化dataGrid
	// 定义变量 方便使用grid控件
	var systemLogDg = $("#systemLog-datagrid");
	
	var systemLogSearchForm = $("#searchForm");
	
	// 含有 data-cmd 属性 方法点击的监听事件
	var btnClickMethodsObj = {
		'delete':function(){
			//获取选中行的数据
			var row = systemLogDg.datagrid("getSelected");
			if(row){
				$.messager.confirm('你确定要删除吗？', '删除后无法恢复，请谨慎选择。', function(r){
					if (r){
						//发送ajax请求来 实现删除功能
						$.post(deleteUrl,{id:row.id},function(result){
							console.debug(result);
							if(result.status){
								//刷新界面
								systemLogDg.datagrid("reload");
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
			systemLogDg.datagrid("reload");
		},
		'searchSubmit':function(){
			//直接调用dataGrid的加载数据的方法
			//将表单里的参数序列化成json对象
			var paramObj = systemLogSearchForm.serializeJson();
			alert("xxxx");
			//加载数据
			systemLogDg.datagrid('load',paramObj);
		}
	};
	
	//searchForm的初始化
	systemLogSearchForm.form({
		
	});
	
	//初始化dataGrid
	systemLogDg.datagrid({    
		//请求地址
	    url:listUrl,
	    // 标题
	    title:'系统日志列表',
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
	    // 分页列表
	    pageSize:20,
	    pageList:[20,30,40,50],
	    columns:[[    
	        {field:'opUser',title:'操作用户',width:50,align:'center',formatter:objectFormatter},    
	        {field:'opTime',title:'操作时间',width:50,align:'center'},    
	        {field:'opIp',title:'登录ip',width:50,align:'center'},
	        {field:'function',title:'使用功能',width:100,align:'center'},
	    ]],
	    //工具条
	    toolbar:'#systemLog-toolbar'
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
	//隐藏搜索条件
	$("#search-conditions").hide();
	
	var show = false;
	
	$("#search-more").click(function(){
		$("#search-conditions").toggle("slow","linear", function() {
			if(show){
				$("#search-more").find(".l-btn-text").text("更多");
			}else {
				$("#search-more").find(".l-btn-text").text("隐藏");
			}
			show = !show;
		});
	});
});
