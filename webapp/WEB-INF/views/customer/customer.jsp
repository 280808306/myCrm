<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	function objectFormatter(value, rowData, rowIndex) {
		return value ? value.username : "无名";
	};
	function genderFormatter(v, r, i) {
		if (v && r) {
			if (v == -1) {
				return "女";
			} else {
				return "男";
			}
		}
	};
</script>
</head>
<body>
	<table id="customer-datagrid" class="easyui-datagrid"
		url="/customer/list" title="客户管理" fit="true" border="false"
		fitColumns="true" singleSelect="true" rownumbers="true"
		pagination="true" toolbar='#customer-toolbar'>
		<thead>
			<tr>
				<th field="name" width="1">客户姓名</th>
				<th field="age" width="1 ">客户年龄</th>
				<th field="gender" width="1 " formatter="genderFormatter">客户性别</th>
				<th field="tel" width="1">客户电话</th>
				<th field="seller" width="1" formatter="objectFormatter">销售人员</th>
				<th field="inputUser" width="1" formatter="objectFormatter">创建人</th>
			</tr>
		</thead>
	</table>

	<!-- 数据的增删改 -->
	<!-- 2、添加编辑对话框 -->
	<div id="customer-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		title="添加客户对话框" modal="true" buttons="#customer-dlg-buttons">
		<div class="ftitle">客户详情</div>
		<form id="customer-form" method="post" novalidate>
			<input name="id" type="hidden">
			<div class="fitem">
				<label>客户姓名:</label> <input name="name" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
			<label>客户性别:</label>
				<select class="easyui-combobox" name="gender"
					style="width: 155px" fitColumns = "true" >
					<option value="-1">女</option>
					<option value="1">男</option>
				</select>
			</div>
			<div class="fitem">
				<label>客户年龄:</label> <input name="age" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>客户电话:</label> <input name="tel" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>营销人员:</label> <select name="seller.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'relName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>创建人:</label> <select name="inputUser.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'relName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
		</form>
	</div>
	<!-- 对话框按钮 -->
	<div id="customer-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" id="save" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" id="cancel" style="width: 90px">取消</a>
	</div>

	<!-- 3、添加搜索对话框 -->
	<div id="customer-search-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		title="客户搜索对话框" modal="true" buttons="#customer-search-dlg-buttons">
		<div class="ftitle">客户搜索条件</div>
		<form id="customer-search-form" method="post" novalidate>
			<div class="fitem">
				<label>客户姓名:</label> <input name="name" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>客户年龄:</label> <input name="age" class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>销售人员:</label> <select name="sellerId"
					class="easyui-combogrid" style="width: 142px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'relName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>创建人:</label> <select name="inputUserId"
					class="easyui-combogrid" style="width: 142px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'relName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
		</form>
	</div>
	<!-- 对话框按钮 -->
	<div id="customer-search-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" id="doSearch" style="width: 90px">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-reload" id="resetSearchForm" style="width: 90px">重置</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" id="closeSearchDlg" style="width: 90px">取消</a>
	</div>
	<!-- 数据表格的顶部菜单 -->
	<div id="customer-toolbar">
		<a id="add" href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">添加</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="eidt">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-remove" plain="true" id="del">删除</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true" id="refresh">刷新</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-search" plain="true" id="openSearchDlg">高级查询</a>
	</div>



	<script type="text/javascript">
		//  声明我们需要操作的组件
		//  缓存组件
		var cusDatagrid = $('#customer-datagrid');
		var cusToolbar = $('#customer-toolbar');
		var cusForm = $('#customer-form');
		var cusDlgButtons = $('#customer-dlg-buttons');
		var cusDlg = $('#customer-dlg');
		var customerSearch = $('#customer-search-dlg');
		var customerSearchForm = $('#customer-search-form');
		$("#add").click(
				function() {
					// 清理表单中的信息  清空表单里的信息
					cusForm.form('clear');
					//显示dialog对话框
					cusDlg.dialog("center").dialog("setTitle", "添加客户信息")
							.dialog("open");
				});

		//  删除
		$("#del").click(function() {
			//  先获取这行数据
			var row = cusDatagrid.datagrid("getSelected");
			if (!row) {
				$.messager.alert("温馨提示", "请选中一行数据删除", "info");
				return;
			}
			$.messager.confirm('温馨提示', '您确定想要删除本条数据吗？', function(r) {
				if (r) {
					$.post("/customer/delete", {
						"id" : row.id
					}, function(result) {
						if (result.status) {
							cusDatagrid.datagrid('reload');
						} else {
							$.messager.show({
								title : '错误信息',
								msg : result.msg
							});
						}
					}, "json");
				}
			});

		});
		//   取消
		$("#cancel").click(function() {
			cusDlg.dialog("close");
		});
		//  刷新
		$("#refresh").click(function() {
			cusDatagrid.datagrid('reload');
		});

		//   添加数据
		$("#save").click(function() {
			//  提交表单
			cusForm.form('submit', {
				url : url = "/customer/save",
				onSubmit : function() {
					//  进行表单验证
					return cusForm.form("validate");
				},
				success : function(data) {
					var result = $.parseJSON(data);
					if (result) {
						if (result.status) {
							cusDatagrid.datagrid('reload');
							cusDlg.dialog('close');
						} else {
							$.messager.alert('温馨提示', result.msg);
						}
					} else {
						$.messager.alert('温馨提示', "操作失败");
					}
				}
			});
		});

		//  修改
		$("#eidt").click(
				function() {
					//  先获取这行数据
					var row = cusDatagrid.datagrid("getSelected");
					if (!row) {
						$.messager.alert("温馨提示", "请选中一行数据修改", "info");
						return;
					}
					//  获得打开这个对话框
					cusDlg.dialog("center").dialog("setTitle", "修改客户信息")
							.dialog("open");
					//  数据回显
					cusForm.form("load", row);
				});

		//  高级查询
		$("#openSearchDlg").click(function() {
			customerSearch.dialog("open");
		});
		//  查询
		$("#doSearch").click(function() {
			$.fn.serializeJson = function() {
				var paramObj = {};
				var paramArr = $(this).serializeArray();
				$.each(paramArr, function(index, obj) {
					//console.debug(arguments);
					// 取出每一个对象的name属性和value属性
					if (obj.value != null && obj.value != "") {
						paramObj[obj.name] = obj.value;
					}
				});
				return paramObj;
			};
			// 把表单条件转变为json对象
			var paramObj = customerSearchForm.serializeJson();
			// 使用查询条件，过滤数据
			cusDatagrid.datagrid("load", paramObj);
			customerSearch.dialog("close");
		});
		//  重置
		$("#resetSearchForm").click(function() {
			customerSearchForm.form("clear");
		});
		//  取消
		$("#closeSearchDlg").click(function() {
			customerSearch.dialog("close");
		});
	</script>
</body>
</html>
