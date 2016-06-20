<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		var listItemDataGrid = $('#listItemDataGrid');
		var editItemDialog = $('#editItemDialog');
		var editItemForm = $('#editItemForm');

		beanDataGrid.datagrid({
			url : '/guarantee/list',
			toolbar : "#queryToolbar",
			fit : true,
			pagination : true,
			rownumbers : true,
			fitColumns : true,
			singleSelect : true,
			columns : [ [ {
				field : 'sn',
				title : '保修单号',
				width : 100
			}, {
				field : 'customer',
				title : '目标客户',
				formatter : formatDatagrid,
				width : 100
			}, {
				field : 'endTimeStr',
				title : '到期时间',
				width : 100
			} ] ]
		});

		listItemDataGrid.datagrid({
// 			url : "/guaranteeItem/listByParent?id=" + (id ? id : ''),
			toolbar : "#listItemToolbar",
			fit : true,
			rownumbers : true,
			fitColumns : true,
			singleSelect : true,
			columns : [ [ {
				field : 'guaranteeTimeStr',
				title : '保修时间',
				width : 100
			}, {
				field : 'content',
				title : '内容',
				width : 100
			}, {
				field : 'isSolve',
				title : '是否解决',
				formatter : formatBoolean,
				width : 100
			} ] ]
		});

		var cmdObject = {
			addBean : function() {
				listItemDataGrid.datagrid("loadData",{rows:[]});
				beanForm.form('clear');
				editBeanDialog.dialog('open').dialog('setTitle', '添加');
			},
			editBean : function() {
				beanForm.form('clear');
				var row = beanDataGrid.datagrid('getSelected');
				if (row) {
					if (row.customer) {
						row["customer.id"] = row.customer.id;
					}
					beanForm.form('load', row);
					$.get("/guaranteeItem/listByParent",{id:row.id},function(data){
						listItemDataGrid.datagrid("loadData",data);
					},"json");
					editBeanDialog.dialog('open').dialog('setTitle', '编辑');
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			saveBean : function() {
				beanForm
						.form(
								'submit',
								{
									url : '/guarantee/save',
									onSubmit : function(param) {
										var rows = listItemDataGrid
												.datagrid("getRows");
										console.debug(rows);
										for (var i = 0; i < rows.length; i++) {
											for ( var name in rows[i]) {
												if (rows[i][name]) {
													param["items[" + i + "]."
															+ name] = rows[i][name];
												}
											}
										}
										console.debug(param);
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
							$.post('/guarantee/delete', {
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
			},
			addItem : function() {
				editItemForm.form("reset");
				editItemDialog.dialog("open").dialog("setTitle", "添加详细");
			},
			editItem : function() {
				editItemForm.form('clear');
				var row = listItemDataGrid.datagrid('getSelected');
				if (row) {
					editItemDialog.dialog('open').dialog('setTitle', '编辑');
					editItemForm.form('load', row);
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			saveItem : function() {
				var array = editItemForm.serializeArray();
				console.debug(array);
				var itemObj = {};
				$.each(array, function(index, obj) {
					if (obj.value) {
						itemObj[obj.name] = obj.value;
					}
				});
				console.debug(itemObj);
				var row = listItemDataGrid.datagrid('getSelected');
				if (row) {
					var index = listItemDataGrid.datagrid('getRowIndex', row);
					var value = {};
					value.index = index;
					value.row = itemObj;
					console.debug(value);
					listItemDataGrid.datagrid("updateRow", value);
				} else {
					listItemDataGrid.datagrid("appendRow", itemObj);
				}
				editItemDialog.dialog("close");
			},
			deleteItem : function() {
				var row = listItemDataGrid.datagrid('getSelected');
				if (row) {
					$.messager.confirm('确认', '确定删除吗?', function(r) {
						if (r) {
							var index = listItemDataGrid.datagrid(
									'getRowIndex', row);
							listItemDataGrid.datagrid("deleteRow", index);
						}
					});
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			closeEditItemDialog : function() {
				editItemDialog.dialog("close");
			}
		};

		$("a[data-cmd]").on("click", function() {
			cmdObject[$(this).attr("data-cmd")]();
		})

	});

	function formatDatagrid(value, row, index) {
		return value ? value.name || value.realName : "";
	}

	function formatBoolean(value, row, index) {
		return value && value != 0 ? '是' : "否";
	}
</script>
</head>
<body>

	<table id="beanDataGrid"></table>
	<div id="queryToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="addBean">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="editBean">编辑</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="deleteBean">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="openSearchDialog">高级查询</a>
	</div>

	<div id="editBeanDialog" class="easyui-dialog" style="width: 900px; height: 400px; padding: 10px 20px" closed="true" buttons="#editDialogButtons">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'west',split:true" style="width: 420px; height: 300px; padding: 10px;">
				<div class="easyui-panel" data-options="fit:true,title:'保修信息'">
					<form id="beanForm" class="dialog-form" method="post" novalidate>
						<input name="id" type="hidden" class="easyui-validatebox">
						<div class="fitem">
							<label>保修号:</label>
							<input name="sn" class="easyui-validatebox">
						</div>
						<div class="fitem">
							<label>到期时间:</label>
							<input name="endTimeStr" class="easyui-datebox"></input>
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
					</form>
				</div>
			</div>
			<div data-options="region:'east',split:true" style="width: 420px; height: 300px; padding: 10px;">
				<div class="easyui-panel" data-options="fit:true,title:'保修详细'">
					<table id="listItemDataGrid"></table>
				</div>
			</div>
		</div>
	</div>

	<div id="listItemToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="addItem">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="editItem">编辑</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="deleteItem">删除</a>
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
				<select name="customerId" class="easyui-combogrid" style="width: 100px"
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
		</form>
	</div>
	<div id="searchDialogButtons">
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="doSearch">查询</a>
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="clearSearchForm">重置</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="closeSearchDialog">取消</a>
	</div>

	<div id="editItemDialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true" buttons="#editItemButtons">
		<form id="editItemForm" class="dialog-form" method="post" novalidate>
			<input name="id" type="hidden" class="easyui-validatebox">
			<div class="fitem">
				<label>保修时间:</label>
				<input name="guaranteeTimeStr" class="easyui-datebox">
			</div>
			<div class="fitem">
				<label>内容:</label>
				<input name="content" class="easyui-validatebox"></input>
			</div>
			<div class="fitem">
				<label>是否解决:</label>
				<input type="radio" name="isSolve" value="1">
				是
				</input>
				<input type="radio" name="isSolve" checked="checked" value="0">
				否
				</input>
			</div>
		</form>
	</div>
	<div id="editItemButtons">
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="saveItem">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="closeEditItemDialog">取消</a>
	</div>

</body>
</html>