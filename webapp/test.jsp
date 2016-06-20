<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="/WEB-INF/views/common/head.jsp"%>
</head>
<body style="background-repeat: no-repeat;">
	<div class="easyui-layout" fit="true">
		<div data-options="region:'west'" title="资源类" style="width: 400px; height: auto;">
			<ul id="resource-types-tree"></ul>
		</div>
		<div data-options="region:'center',iconCls:'icon-ok'" style="width: auto; height: auto;">
			<table id="resource-datagrid">
			</table>
			<div id="resource-toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="remove">移除资源</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" data-cmd="refresh">扫描</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="add">添加资源</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		$(function() {
			
			//缓存表格
			var resourcesDg = $("#resource-datagrid");
			
			var typeTree = $("#resource-types-tree");
			
			var initClassName;
			
			var btnClickMethodsObj = {
				//添加资源
				'add':function(){
					//准备请求参数
					var paramObj = {};
					//获取所有选中 的资源列表
					var selections =  resourcesDg.datagrid("getSelections");
					//封装resource参数
					var index = 0;
					for (var i = 0; i < selections.length; i++) {
						var resource = selections[i];
						if(!resource.hasResource){
							paramObj['resources['+ index +'].name'] = resource.name;
							paramObj['resources['+ index +'].url'] = resource.url;
							index ++;
						}
					}
					//发送请求添加
					console.debug(paramObj);
					$.post("/resource/savelist",paramObj, function(data) {
						//请求结果
						console.debug(data);
						if(data.status){
							resourcesDg.datagrid("reload");
						} else {
							$.messager.alert("温馨提示", data.msg, 'info');
						}
					},"json");
				},
				//添加资源
				'remove':function(){
					//准备请求参数
					var paramObj = {};
					//获取所有选中 的资源列表
					var selections =  resourcesDg.datagrid("getSelections");
					//封装resource参数
					var index = 0;
					for (var i = 0; i < selections.length; i++) {
						var resource = selections[i];
						if(resource.hasResource){
							paramObj['resources['+ index +'].url'] = resource.url;
							index ++;
						}
					}
					//发送请求添加
					console.debug(paramObj);
					$.post("/resource/deletelist",paramObj, function(data) {
						//发送添加请求
						console.debug(data);
						if(data.status){
							resourcesDg.datagrid("reload");
						} else {
							$.messager.alert("温馨提示", data.msg, 'info');
						}
					},"json");
				}
			};
			
			//监听所有的自己设置的按钮
			$("[data-cmd]").click(function(){
				//获取方法的名字
				var methodName = $(this).data("cmd");
				//根据方法名 btnClickMethodsObj 对象来调用方法
				if(methodName && btnClickMethodsObj[methodName]){
					btnClickMethodsObj[methodName]();
				}
			});
			
			//初始化树
			typeTree.tree({
				url:'/resource/types',
				animate:true,
				lines:true,
				onClick: function(node){
					//是包
					if(node.id){
						resourcesDg.datagrid('load',{
						});
					}else {
						resourcesDg.datagrid('load',{
							//将类名放在url中
							className:node.url
						});
					}
				},
				onLoadSuccess: function(node, param){
					initClassName = param[0].children[0].url;
					resourcesDg.datagrid('load',{
						//将类名放在url中
						className:initClassName
					});
				}
			});
			//初始化数据表格
			// 	class="easyui-datagrid" title="资源列表" 
			resourcesDg.datagrid({
				title:"资源列表",
				fit:true ,
				pagination:false,
				rownumbers:true,
				fitColumns:true,
				toolbar:"#resource-toolbar",
				ctrlSelect:true,
				url:'/resource/typeResources',
				columns:[[    
				          {field:'name',title:'资源名称',width:50},    
				          {field:'url',title:'资源地址',width:100},    
				          {field:'hasResource',title:'是否添加到资源库',width:20}    
				      ]]  
			});
		});
		
	</script>
</body>
</html>