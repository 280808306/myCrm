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

		var cmdObject = {
			addBean : function() {
				editBeanDialog.dialog('open').dialog('setTitle', '添加');
				beanForm.form('clear');
			},
			editBean : function() {
				beanForm.form('clear');
				var row = beanDataGrid.datagrid('getSelected');
				if (row) {
					if(row.customerSource){
						row["customerSource.id"] = row.customerSource.id;
					}
					editBeanDialog.dialog('open').dialog('setTitle', '编辑');
					beanForm.form('load', row);
				} else {
					$.messager.alert('错误提示', '请选择操作条目!', 'error');
				}
			},
			saveBean : function() {
				beanForm.form('submit', {
					url : '/potentialCustomer/save',
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
							$.post('/potentialCustomer/delete', {
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
				beanDataGrid.datagrid("load", querObject);
				searchDialog.dialog('close');
			},
			clearSearchForm : function() {
				searchForm.form("clear");
			},
			closeSearchDialog : function() {
				searchDialog.dialog('close');
			}
		};

		$("a[data-cmd]").on("click", function() {
			cmdObject[$(this).attr("data-cmd")]();
		})

	});
</script>
</head>
<body>

	<table id="beanDataGrid" class="easyui-datagrid" toolbar="#queryToolbar" fit="true" url="/potentialCustomer/list" pagination="true" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="20">ID</th>
				<th field="name" width="50">姓名</th>
				<th field="successRate" width="50">成功率</th>
				<th field="remark" width="50">客户描述</th>
				<th field="linkMan" width="50">联系人</th>
				<th field="linkManTel" width="50">联系人电话</th>
				<th field="inputTimeStr" width="50">录入时间</th>
			</tr>
		</thead>
	</table>
	<div id="queryToolbar">
		<a class="easyui-linkbutton" iconCls="icon-add" plain="true" data-cmd="addBean">添加</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" plain="true" data-cmd="editBean">编辑</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" plain="true" data-cmd="deleteBean">删除</a>
		<a class="easyui-linkbutton" iconCls="icon-search" plain="true" data-cmd="openSearchDialog">高级查询</a>
	</div>

	<div id="editBeanDialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true" buttons="#editDialogButtons">
		<div class="ftitle">潜在客户信息</div>
		<form id="beanForm" class="dialog-form" method="post" novalidate>
			<input name="id" type="hidden" class="easyui-validatebox">
			<div class="fitem">
				<label>客户姓名:</label>
				<input name="name" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>成功几率:</label>
				<input name="successRate" class="easyui-validatebox" />
			</div>
			<div class="fitem">
				<label>客户描述:</label>
				<input name="remark" class="easyui-validatebox" />
			</div>
			<div class="fitem">
				<label>联系人:</label>
				<input name="linkMan" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>联系电话:</label>
				<input name="linkManTel" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>客户来源:</label>
				<input name="customerSource.id" class="easyui-combobox" name="language"
					data-options="
		                    url:'/systemDictionaryItem/listByPartenId?parentId=54',
		                    method:'get',
		                    valueField:'id',
		                    textField:'name',
		                    panelHeight:'auto'">
			</div>
		</form>
	</div>
	<div id="editDialogButtons">
		<a class="easyui-linkbutton" iconCls="icon-ok" data-cmd="saveBean">保存</a>
		<a class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="closeEditDialog">取消</a>
	</div>

	<div id="searchDialog" class="easyui-dialog" style="width: 400px; height: 280px; padding: 10px 20px" closed="true" buttons="#searchDialogButtons">
		<div class="ftitle">查询条件</div>
		<form id="searchForm" class="dialog-form" method="post" novalidate>
			<div class="fitem">
				<label>客户姓名:</label>
				<input name="name" class="easyui-validatebox">
			</div>
			<div class="fitem">
				<label>成功机率:</label>
				<span>
					<input name="successRate" class="easyui-slider" style="width: 100px" data-options="showTip: true,range: true,value: [0,100],rule: [0,'|',25,'|',50,'|',75,'|',100]">
				</span>
			</div>
			<div class="fitem">
				<label>录入人:</label>
				<select name="inputUserId" class="easyui-combogrid" style="width: 100px"
					data-options="
						            panelWidth: 500,
						            idField: 'id',
						            textField: 'realName',
						            url: '/employee/list',
						            method: 'get',
						            columns: [[
						                {field:'id',title:'ID',width:40},
						                {field:'username',title:'账号名',width:120},
						                {field:'realName',title:'真实名',width:80,align:'right'},
						                {field:'email',title:'邮箱',width:80,align:'right'},
						                {field:'role.name',title:'角色',width:200},
						            ]],
						            fitColumns: true">
				</select>
			</div>
			<div class="fitem">
				<label>客户来源:</label>
				<input name="customerSourceId" class="easyui-combobox" name="language"
					data-options="
		                    url:'/systemDictionaryItem/listByPartenId?parentId=54',
		                    method:'get',
		                    valueField:'id',
		                    textField:'name',
		                    panelHeight:'auto'">
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