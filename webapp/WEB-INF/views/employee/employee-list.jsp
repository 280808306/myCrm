<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工管理</title>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<style type="text/css">
.ftitle {
	border-bottom: 1px solid #ccc;
	font-size: 14px;
	font-weight: bold;
	margin-bottom: 10px;
	padding: 5px 0;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

form {
	margin: 0;
	padding: 10px 40px;
}
</style>
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
	function objectFormatter(value, rowData, rowIndex) {
		return value ? value.username || value.name : "无名";
	};
	
	function create(){
		
		$("#employee-form").form("clear");
		
		$("#employee-dialog").dialog("open");
	}
	
	function edit(){
		// 1.获取选中行信息
		var rowData = $("#employee-datagrid").datagrid("getSelected");
		// 2.判断
		if(!rowData){
			$.messager.alert("温馨提示","请选中一行数据！！");
			return;
		}
		if(rowData!=null){
			rowData["dept.id"]=rowData.dept.id;
		}
		if(rowData!=null){
			rowData["role.id"]=rowData.role.id;
		}
		// 3.清空对话框数据
		$("#employee-form").form("clear");
		// 4.打开添加对话框
		$("#employee-dialog").dialog("open");
		// 5.特殊数据处理
		// 6.把数据加载到对话框中
		$("#employee-form").form("load",rowData);
	}
	
	function del(){
		// 1.获取选中行信息
		var rowData = $("#employee-datagrid").datagrid("getSelected");
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
				$.get("/employee/delete?id="+id,function(data){
					console.debug(data);
					if(data.status){
						$.messager.alert("温馨提示",data.msg,"info",function(){
							$("#employee-datagrid").datagrid("reload");
						});
					}
				},"json");
			}
		});
		
		
	}
	
	function refresh(){
		$("#employee-datagrid").datagrid("reload");
	}
	
	function save(){
		
		$("#employee-form").form("submit",{
			url:"/employee/save",
			onSubmit:function(){
				return $("#employee-form").form("validate");
			},
			success:function(data){ 
				data = $.parseJSON(data);
				if(data.status){
					$("#employee-dialog").dialog("close");
					$.messager.alert("温馨提示",data.msg,"info",function(){
						
						$("#employee-datagrid").datagrid("load");
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
		$("#employee-dialog").dialog("close");
	}
	
	function doSearch(){
		
		var paramObj = $("#employee-searchForm").serializeJson();
		$("#employee-datagrid").datagrid("load",paramObj);
	}
	
	$(function(){
		$("#employee-datagrid").datagrid({
			
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
	<table id="employee-datagrid" class="easyui-datagrid"  
			url="/employee/list"
			title="员工管理"
			fit="true"
			border="false"
			fitColumns="true"
			singleSelect="true"
			rownumbers="true"
			pagination="true"
			pageSize="3"
			pageList="[3,5,10,20,50]"
			toolbar="#employee-toolbar"
			>
		<thead>
			<tr>
				<th field="username" width="1">用户名</th>
				<th field="realName" width="1">昵称</th>
				<th field="password" width="1">密码</th>
				<th field="tel" width="1">电话</th>
				<th field="email" width="1">Email</th>
				<th field="inputTimeFormat" width="1">录入时间</th>
				<th field="role" width="1" formatter="objectFormatter">角色</th>
				<th field="dept" width="1" formatter="objectFormatter">部门</th>
				<th field="status" width="1" formatter="statusFormatter">状态</th>
			</tr>
		</thead>
	</table>
	<!-- 2、数据表格菜单按钮 -->
	 <div id="employee-toolbar">
	 	<div>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="create();">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit();">编辑</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="del();">离职</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="refresh();">刷新</a>
	 	</div>
	 	<div>
	 		<form id="employee-searchForm"  method="post" enctype="application/x-www-form-urlencoded">
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
	<div id="employee-dialog" class="easyui-dialog" 
	 				style="width: 350px;height: 250px;"
					title="添加/编辑员工信息"  
					closed="true" 
					buttons="#employee-dlg-btns"
					modal="true">
		<form id="employee-form" method="post">
			<input type="hidden" name="id">
			<div class="fitem">
				<label>员工姓名:</label> <input name="username" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>真实姓名:</label> <input name="realName" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>密码:</label> <input name="password" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>电话:</label> <input name="tel" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>部门:</label> <select name="dept.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'name', 
			            
 			            url: '/department/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'name',title:'员工姓名',width:40}, 
 			                {field:'dept.id',title:'dept',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>角色:</label> <select name="role.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'name', 
			            
 			            url: '/role_list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'name',title:'角色姓名',width:40}, 
 			                {field:'sn',title:'角色',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
		</form>
	</div>
	<!-- 4、添加/编辑对话框按钮 -->
	 <div id="employee-dlg-btns">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" onclick="save();">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"  onclick="cancel();">取消</a>
	</div>
	
</body>
</html>