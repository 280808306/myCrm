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
		return value ? value.username || value.name : "无名";
	};
	function traceResultFormatter(v, r, i) {
		if (v && r) {
			if (v == 1) {
				return "优";
			} else if (v == 2) {
				return "良";
			} else {
				return "差";
			}
		}
	};
//  日期格式转换
	$.fn.datebox.defaults.formatter = function timeFormatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return m+'/'+d+'/'+y;
	};
	$.fn.datebox.defaults.parser = function timeParser(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	};
</script>
</head>
<body>
	<table id="cutomerTransfer-datagrid" class="easyui-datagrid"
		url="/cutomerTransfer/list" title="客户跟进历史管理" fit="true" border="false"
		fitColumns="true" singleSelect="true" rownumbers="true"
		pagination="true" toolbar='#cutomerTransfer-toolbar'>
		<thead>
			<tr>
				<th field="customer" width="1" formatter="objectFormatter">客户</th>
				<th field="transUser" width="1" formatter="objectFormatter">移交人员</th>
				<th field="oldSeller" width="1" formatter="objectFormatter">老市场专员</th>
				<th field="newSeller" width="1" formatter="objectFormatter">新市场专员</th>
				<th field="transReason" width="1">移交原因</th>
				<th field="transTimeFormat" width="1" parser=timeParser>移交时间</th>
			</tr>
		</thead>
	</table>

	<!-- 数据的增删改 -->
	<!-- 2、添加编辑对话框 -->
	<div id="cutomerTransfer-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		title="添加客户移交记录" modal="true" buttons="#cutomerTransfer-dlg-buttons">
		<div class="ftitle">客户移交记录详情</div>
		<form id="cutomerTransfer-form" method="post" novalidate>
			<input name="id" type="hidden">
			<div class="fitem">
				<label>客户:</label> <select name="customer.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
			            panelWidth: 300,
			            idField: 'id',
			            textField: 'name',
			            url: '/customer/list',
			            method: 'get',
			            columns: [[
			                {field:'name',title:'客户姓名',width:40},
			                {field:'tel',title:'电话',width:50,align:'right'},
			                {field:'age',title:'年龄',width:50,align:'right'}
			            ]],
			            fitColumns: true
			        ">
				</select>
			</div>
			<div class="fitem">
				<label>移交人员:</label> <select name="transUser.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>老市场专员:</label> <select name="oldSeller.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>新市场专员:</label> <select name="newSeller.id"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>移交原因:</label> <input name="transReason"
					class="easyui-textarea" required="true">
			</div>
			<div class="fitem">
				<label>移交时间:</label> 
					<input name="transTimeFormat" class="easyui-datebox"></input>
			</div>
		</form>
	</div>
	<!-- 对话框按钮 -->
	<div id="cutomerTransfer-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" id="save" style="width: 90px">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" id="cancel" style="width: 90px">取消</a>
	</div>

	<!-- 3、添加搜索对话框 -->
	<div id="cutomerTransfer-search-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		title="客户移交记录搜索对话框" modal="true"
		buttons="#cutomerTransfer-search-dlg-buttons">
		<div class="ftitle">客户移交记录搜索条件</div>
		<form id="cutomerTransfer-search-form" method="post" novalidate>
			<div class="fitem">
				<label>客户:</label> <select name="customerId"
					class="easyui-combogrid" style="width: 155px"
					data-options="
			            panelWidth: 300,
			            idField: 'id',
			            textField: 'name',
			            url: '/customer/list',
			            method: 'get',
			            columns: [[
			                {field:'name',title:'客户姓名',width:40},
			                {field:'tel',title:'电话',width:50,align:'right'},
			                {field:'age',title:'年龄',width:50,align:'right'}
			            ]],
			            fitColumns: true
			        ">
				</select>
			</div>
			<div class="fitem">
				<label>移交人员:</label> <select name="transUserId"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>老市场专员:</label> <select name="oldSellerId"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
 			                {field:'tel',title:'电话',width:50,align:'right'},
 			                {field:'email',title:'邮箱',width:50,align:'right'}
			            ]], 
 			            fitColumns: true 
 			        ">
				</select>
			</div>
			<div class="fitem">
				<label>新市场专员:</label> <select name="newSellerId"
					class="easyui-combogrid" style="width: 155px"
					data-options="
 			            panelWidth: 300, 
 			            idField: 'id', 
 			            textField: 'username', 
			            
 			            url: '/employee/list', 
 			            method: 'get', 
 			            columns: [[ 
			                {field:'username',title:'员工姓名',width:40}, 
 			                {field:'realName',title:'昵称',width:50,align:'right'}, 
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
	<div id="cutomerTransfer-search-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" id="doSearch" style="width: 90px">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-reload" id="resetSearchForm" style="width: 90px">重置</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" id="closeSearchDlg" style="width: 90px">取消</a>
	</div>
	<!-- 数据表格的顶部菜单 -->
	<div id="cutomerTransfer-toolbar">
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
		var cusDatagrid = $('#cutomerTransfer-datagrid');
		var cusToolbar = $('#cutomerTransfer-toolbar');
		var cusForm = $('#cutomerTransfer-form');
		var cusDlgButtons = $('#cutomerTransfer-dlg-buttons');
		var cusDlg = $('#cutomerTransfer-dlg');
		var cutomerTransferSearch = $('#cutomerTransfer-search-dlg');
		var cutomerTransferSearchForm = $('#cutomerTransfer-search-form');
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
					$.post("/cutomerTransfer/delete", {
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
				url : url = "/cutomerTransfer/save",
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
					if(row.customer){
						row["customer.id"]=row.customer.id;
					}
					if(row.transUser){
						row["transUser.id"]=row.transUser.id;
					}
					if(row.oldSeller){
						row["oldSeller.id"]=row.oldSeller.id;
					}
					if(row.newSeller){
						row["newSeller.id"]=row.newSeller.id;
					}
					//  获得打开这个对话框
					cusDlg.dialog("center").dialog("setTitle", "修改客户信息")
							.dialog("open");
					//  数据回显
					cusForm.form("load", row);
				});

		//  高级查询
		$("#openSearchDlg").click(function() {
			cutomerTransferSearch.dialog("open");
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
			var paramObj = cutomerTransferSearchForm.serializeJson();
			// 使用查询条件，过滤数据
			cusDatagrid.datagrid("load", paramObj);
			cutomerTransferSearch.dialog("close");
		});
		//  重置
		$("#resetSearchForm").click(function() {
			cutomerTransferSearchForm.form("clear");
		});
		//  取消
		$("#closeSearchDlg").click(function() {
			cutomerTransferSearch.dialog("close");
		});
	</script>
</body>
</html>
