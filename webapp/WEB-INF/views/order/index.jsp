<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://crm.wudi.cn/jsp/jstl/core" prefix="uCtx"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<style type="text/css">
.dialog-form {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
<script type="text/javascript">
	$(function() {
		var editBeanDialog = $('#editBeanDialog');
		var beanForm = $('#beanForm');
		var beanDataGrid = $('#beanDataGrid');
		var searchDialog = $('#searchDialog');
		var searchForm = $('#searchForm');

		var cmdObject = {
			addBean : function() {
				editBeanDialog.dialog('open').dialog('setTitle', '添加');
				beanForm.form('clear');
			},
			editBean : function() {
				beanForm.form('clear');
				var row = beanDataGrid.datagrid('getSelected');
				if (row) {
					if (row.customer) {
						row["customer.id"] = row.customer.id;
					}
					if (row.seller) {
						row["seller.id"] = row.seller.id;
					}
					editBeanDialog.dialog('open').dialog('setTitle', '编辑');
					beanForm.form('load', row);
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			saveBean : function() {
				beanForm.form('submit', {
					url : '/order/save',
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(result) {
						var result = $.parseJSON(result);
						if (!result.status) {
							$.messager.show({
								title : '错误',
								msg : result.msg
							});
						} else {
							editBeanDialog.dialog('close'); // close the dialog
							beanDataGrid.datagrid('reload'); // reload the user data
						}
					}
				});
			},
			deleteBean : function() {
				var row = beanDataGrid.datagrid('getSelected');
				if (row) {
					$.messager.confirm('确认', '确定删除吗?', function(r) {
						if (r) {
							$.post('/order/delete', {
								id : row.id
							}, function(result) {
								if (result.status) {
									beanDataGrid.datagrid('reload'); // reload the user data
								} else {
									$.messager.show({ // show error message
										title : '错误',
										msg : result.msg
									});
								}
							}, 'json');
						}
					});
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			closeEditDialog : function() {
				editBeanDialog.dialog('close'); // close the dialog
			},
			openSearchDialog : function() {
				searchDialog.dialog('open').dialog('setTitle', '高级查询');
			},
			doSearch : function() {
				var array = searchForm.serializeArray();
				var querObject = {};
				$.each(array, function(index, obj) {
					if (obj.value) {
						if (querObject[obj.name]) {
							querObject[obj.name] = querObject[obj.name] + ","
									+ obj.value;
						} else {
							querObject[obj.name] = obj.value;
						}
					}
				});
				console.debug("load");
				beanDataGrid.datagrid("load", querObject);
				searchDialog.dialog('close');
			},
			clearSearchForm : function() {
				searchForm.form('clear');
			},
			closeSearchDialog : function() {
				searchDialog.dialog('close');
			}
		};

		$("a[data-cmd]").on("click", function() {
			cmdObject[$(this).attr("data-cmd")]();
		})

	});

	function formatDatagrid(value, row, index) {
		return value ? value.name || value.realName : "";
	}
</script>
</head>
<body>

	<table id="beanDataGrid" class="easyui-datagrid" toolbar="#queryToolbar" fit="true" url="/order/list" pagination="true" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="sn" width="50">订单号</th>
				<th field="customer" width="50" formatter='formatDatagrid'>目标客户</th>
				<th field="signTimeStr" width="50">签约时间</th>
				<th field="seller" width="50" formatter='formatDatagrid'>营销人员</th>
				<th field="sum" width="50">订金</th>
				<th field="intro" width="50">备注</th>
			</tr>
		</thead>
	</table>
	<div id="queryToolbar">
		<uCtx:hasPermission permissionName="订单保存">
			<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="addBean">添加</a>
			<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="editBean">编辑</a>
		</uCtx:hasPermission>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="deleteBean">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="openSearchDialog">高级查询</a>
	</div>

	<div id="editBeanDialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true" buttons="#editDialogButtons">
		<div class="ftitle">订单</div>
		<form id="beanForm" class="dialog-form" method="post" novalidate>
			<input name="id" type="hidden" class="easyui-validatebox">
			<div class="fitem">
				<label>订单号:</label>
				<input name="sn" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>签约时间:</label>
				<input name="signTimeStr" class="easyui-datebox"></input>
			</div>
			<div class="fitem">
				<label>目标客户:</label>
				<select name="customer.id" class="easyui-combogrid" style="width: 100px"
					data-options="
						            panelWidth: 500,
						            idField: 'id',
						            textField: 'name',
						            url: '/customer/list',
						            method: 'get',
						            columns: [[
						                {field:'id',title:'ID',width:40},
						                {field:'name',title:'客户名',width:120},
						                {field:'qq',title:'QQ号',width:80,align:'right'},
						                {field:'email',title:'邮箱',width:80,align:'right'},
						            ]],
						            fitColumns: true">
				</select>
			</div>
			<div class="fitem">
				<label>营销人员:</label>
				<select name="seller.id" class="easyui-combogrid" style="width: 100px"
					data-options="
						            panelWidth: 500,
						            idField: 'id',
						            textField: 'realname',
						            url: '/employee/list',
						            method: 'get',
						            columns: [[
						                {field:'id',title:'ID',width:40},
						                {field:'username',title:'账号名',width:120},
						                {field:'realname',title:'真实名',width:80,align:'right'},
						                {field:'email',title:'邮箱',width:80,align:'right'},
						                {field:'role.name',title:'角色',width:200},
						            ]],
						            fitColumns: true">
				</select>
			</div>
			<div class="fitem">
				<label>定金（元）:</label>
				<input name="sum" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>备注:</label>
				<input name="intro" class="easyui-validatebox">
			</div>
		</form>
	</div>
	<div id="editDialogButtons">
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="saveBean">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="closeEditDialog">取消</a>
	</div>

	<div id="searchDialog" class="easyui-dialog" style="width: 500px; height: 280px; padding: 10px 20px" closed="true" buttons="#searchDialogButtons">
		<div class="ftitle">查询条件</div>
		<form id="searchForm" class="dialog-form" method="post" novalidate>
			<div class="fitem">
				<label>目标客户:</label>
				<input name="customer.id" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>录入人:</label>
				<select name="seller.id" class="easyui-combogrid" style="width: 100px"
					data-options="
						            panelWidth: 500,
						            idField: 'id',
						            textField: 'realname',
						            url: '/employee/list',
						            method: 'get',
						            columns: [[
						                {field:'id',title:'ID',width:40},
						                {field:'username',title:'账号名',width:120},
						                {field:'realname',title:'真实名',width:80,align:'right'},
						                {field:'email',title:'邮箱',width:80,align:'right'},
						                {field:'role.name',title:'角色',width:200},
						            ]],
						            fitColumns: true">
				</select>
			</div>
		</form>
	</div>
	<div id="searchDialogButtons">
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="doSearch">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="clearSearchForm">重置</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="closeSearchDialog">取消</a>
	</div>

</body>
</html>