<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<script type="text/javascript">
	function statusFormatter(v,r,i){
		switch (v) {
		case -1:
			return "<font color='red'>离职</font>";
			break;

		default:
			return "<font color='green'>正常</font>";
			break;
		}
	}
	
	function create(){
		
		$("#department-form").form("clear");
		
		$("#department-dialog").dialog("open");
	}
	
	function edit(){
		// 1.获取选中行信息
		var rowData = $("#department-datagrid").datagrid("getSelected");
		// 2.判断
		if(!rowData){
			$.messager.alert("温馨提示","请选中一行数据！！");
			return;
		}
		// 3.清空对话框数据
		$("#department-form").form("clear");
		// 4.打开添加对话框
		$("#department-dialog").dialog("open");
		// 5.特殊数据处理
		// 6.把数据加载到对话框中
		$("#department-form").form("load",rowData);
	}
	
	function del(){
		// 1.获取选中行信息
		var rowData = $("#department-datagrid").datagrid("getSelected");
		// 2.判断
		if(!rowData){
			$.messager.alert("温馨提示","请选中一行数据！！");
			return;
		}
		
		if(rowData.status==-1){
			$.messager.alert("温馨提示","请不要重复离职！！","warning");
			return;
		}
		
		$.messager.confirm("温馨提示","是否确认离职【"+rowData.nickname+"】员工??",function(yes){
			if(yes){
				// 获取数据的唯一标示
				var id = rowData.id;
				// 发送AJAX请求，修改ID对应数据状态
				$.get("/department/delete?id="+id,function(data){
					console.debug(data);
					if(data.status){
						$.messager.alert("温馨提示",data.msg,"info",function(){
							$("#department-datagrid").datagrid("reload");
						});
					}
				},"json");
			}
		});
		
		
	}
	
	function refresh(){
		$("#department-datagrid").datagrid("reload");
	}
	
	function save(){
		
		$("#department-form").form("submit",{
			url:"/department/save",
			onSubmit:function(){
				return $("#department-form").form("validate");
			},
			success:function(data){ 
				data = $.parseJSON(data);
				if(data.status){
					$("#department-dialog").dialog("close");
					$.messager.alert("温馨提示",data.msg,"info",function(){
						
						$("#department-datagrid").datagrid("load");
					});
				}else{
					$.messager.alert("温馨提示",data.msg,"info",function(){
						if(data.errorCode==-103){
							
						}
					});
				}
			}
		});
	}
	function cancel(){
		$("#department-dialog").dialog("close");
	}
	
	function doSearch(){
		
		var paramObj = $("#department-searchForm").serializeJson();
		$("#department-datagrid").datagrid("load",paramObj);
	}
	
	$(function(){
		$("#department-datagrid").datagrid({
			
			onClickRow:function(i,r){
				//console.debug(arguments);
				if(r.status==-1){
					// 禁用按钮。。
				}
			}
		});
		
	});
	
</script>
</head>
<body>
	<!-- 1、数据表格 -->
	<table id="department-datagrid" class="easyui-datagrid"  
			url="/department/list"
			title="员工管理"
			fit="true"
			border="false"
			fitColumns="true"
			singleSelect="true"
			rownumbers="true"
			pagination="true"
			pageSize="10"
			pageList="[10,20,50]"
			toolbar="#department-toolbar"
			>
		<thead>
			<tr>
				<th field="sn" width="1">部门编号</th>
				<th field="name" width="1">部门名称</th>
				<th field="manager" width="1" formatter="objectFormatter">部门经理</th>
				<th field="parent" width="1" formatter="objectFormatter">上级部门</th>
			</tr>
		</thead>
	</table>
	<!-- 2、数据表格菜单按钮 -->
	 <div id="department-toolbar">
	 	<div>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="create();">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit();">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del();">删除</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refresh();">刷新</a>
	 	</div>
	 	<div>
	 		<form id="department-searchForm"  method="post" enctype="application/x-www-form-urlencoded">
	 			关键字 : <input name="searchKey" style="width:120px">
				状态:
				<select   name="status"  class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="">--请选择--</option>
				<option value="0">正常</option>
				<option value="-1">离职</option>
				</select>
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="doSearch();">搜索</a>
	 		</form>
	 	</div>
	</div>
	<!-- 3、添加/编辑对话框 -->
	<div id="department-dialog" class="easyui-dialog" 
	 				style="width: 260px;height: 200px;"
					title="添加/编辑员工信息"  
					closed="true" 
					buttons="#department-dlg-btns"
					modal="true">
		<form id="department-form" method="post">
			<input type="hidden" name="id">
			<table align="center" style="margin-top: 10px;">
				<tr>
					<td>部门名称:</td>
					<td><input name="name" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>部门编号:</td>
					<td><input name="sn" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>经理:</td>
					<td><input name="manager.id" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>上级部门:</td>
					<td><input name="parent.id"></td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 4、添加/编辑对话框按钮 -->
	 <div id="department-dlg-btns">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="save();">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"  onclick="cancel();">取消</a>
	</div>
</body>
</html>