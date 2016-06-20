<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#fm {
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
	//序列化查询表单参数，为一个JSON对象
	$.fn.serializeJson = function() {
		var paramObj = {};
		var paramArr = $(this).serializeArray();
		$.each(paramArr, function(index, obj) {
			//console.debug(arguments);
			// 取出每一个对象的name属性和value属性
			paramObj[obj.name] = obj.value;
		});
		return paramObj;
	};

	$(function() {
		//声明并定义页面需要的组件
		var pmsGrid, rscGrid, pmsDlg, pmsForm, pmsSearchDlg, pmsSearchForm;
		pmsGrid = $("#permission-datagrid");
		pmsDlg = $("#permission-dlg");
		pmsForm = $("#permission-form");
		pmsSearchDlg = $("#permission-search-dlg");
		pmsSearchForm = $("#permission-search-form");
		rscGrid = $("#resource-datagrid");
		//创建命令对象(打包函数)
		var cmdObj = {
			create : function() {
				pmsDlg.dialog("setTitle", "添加权限");
				// 清空表单
				pmsForm.form("clear");
				// 打开对话框
				pmsDlg.dialog("open");
			},
			refresh : function() {
				pmsGrid.datagrid("reload");
				rscGrid.datagrid("reload");
			},
			edit : function() {
				// 获取选中行
				var rowData = pmsGrid.datagrid("getSelected");
				// 判断
				if (!rowData) {
					$.messager.alert("温馨提示", "请选中一行数据！！", "info");
					return;
				}

				pmsDlg.dialog("setTitle", "修改权限");
				// 清空表单
				pmsForm.form("clear");
				// 打开对话框
				pmsDlg.dialog("open");
				// 回显数据
				pmsForm.form("load", rowData);
			},
			saveList : function() {
				//获取所有选中 的资源列表
				var rows = rscGrid.datagrid("getSelections");
				// 判断
				if (!rows) {
					$.messager.alert("温馨提示", "请选中至少一行数据！！", "info");
					return;
				}
				//准备请求参数
				var paramObj = {};
				//封装resource参数
				var index = 0;
				for (var i = 0; i < rows.length; i++) {
					var resource = rows[i];
					paramObj['resources[' + index + '].name'] = resource.name;
					paramObj['resources[' + index + '].url'] = resource.url;
					index++;
				}
				//发送请求添加
				console.debug(paramObj);
				$.post("/permission/savelist", paramObj, function(data) {
					//请求结果
					console.debug(data);
					if (data.status) {
						pmsGrid.datagrid("reload");
						rscGrid.datagrid("reload");
					} else {
						$.messager.alert("温馨提示", data.msg, 'info');
					}
				}, "json");

			},
			deleteList : function() {
				//获取所有选中 的资源列表
				var rows = pmsGrid.datagrid("getSelections");
				// 判断
				if (!rows) {
					$.messager.alert("温馨提示", "请选中至少一行数据！！", "info");
					return;
				}
				//准备请求参数
				var paramObj = {};
				//封装resource参数
				var index = 0;
				for (var i = 0; i < rows.length; i++) {
					var permission = rows[i];
					paramObj['permissions[' + index + '].id'] = permission.id;
					index++;
				}
				//发送请求删除
				console.debug(paramObj);
				$.post("/permission/deletelist", paramObj, function(data) {
					//请求结果
					console.debug(data);
					if (data.status) {
						pmsGrid.datagrid("reload");
						rscGrid.datagrid("reload");
					} else {
						$.messager.alert("温馨提示", data.msg, 'info');
					}
				}, "json");

			},
			save : function() {
				// 提交表单
				pmsForm.form('submit', {
					url : "/permission/save",
					onSubmit : function() {
						// 手动调用验证方法
						return pmsForm.form("validate");
					},
					success : function(data) {
						// 获取响应
						data = $.parseJSON(data);
						// 判断
						if (data.status) {
							// 关闭
							pmsDlg.dialog("close");
							// 提示
							$.messager.alert("温馨提示", data.msg, "info",
									function() {
										// 刷新
										pmsGrid.datagrid("reload");
									});

						} else {
							$.messager.alert("温馨提示", data.msg, "info");
						}

					}
				});
			},
			cancel : function() {
				pmsDlg.dialog("close");
			},
			openSearchDlg : function() {
				// 打开搜索对话框
				pmsSearchDlg.dialog("open");

			},
			doSearch : function() {
				// 把表单条件转变为json对象
				var paramObj = pmsSearchForm.serializeJson();
				// 使用查询条件，过滤数据
				pmsGrid.datagrid("load", paramObj);
				pmsSearchDlg.dialog("close");
			},
			closeSearchDlg : function() {
				//取消
				pmsSearchDlg.dialog("close");
			},
			resetSearchForm : function() {
				//重置
				pmsSearchForm.form("clear");
			}
		};
		//对页面按钮点击做一个统一的监听
		$("a[data-cmd]").on("click", function() {
			// 获取事件源（按钮）上的cmd属性值
			var cmd = $(this).data("cmd");
			if (cmd) {
				// 如果存在,调用命令对象的方法
				cmdObj[cmd]();
			}
		});
	});
</script>


</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',split:false" style="width: 50%;">
			<table id="permission-datagrid" class="easyui-datagrid" title="权限列表"
				fit="true" pagination="true" rownumbers="true" fitColumns="true"
				toolbar="#permission-toolbar" singleSelect="false"
				data-options="url:'/permission/list',method:'get'">
				<thead>
					<tr>
						<th data-options="field:'id',width:80">ID</th>
						<th data-options="field:'name',width:80,align:'right'">名称</th>
						<th data-options="field:'resource',width:80,align:'right'">资源地址</th>
					</tr>
				</thead>
			</table>
			<div id="permission-toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" data-cmd="edit">编辑权限</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" data-cmd="deleteList">删除权限</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-reload" plain="true" data-cmd="refresh">刷新</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-search" plain="true" data-cmd="openSearchDlg">高级查询</a>
			</div>
		</div>



		<!-- 未添加权限的资源页面!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		<div data-options="region:'center'" style="width: 50%;">
			<table id="resource-datagrid" class="easyui-datagrid"
				title="未生成权限的资源列表" fit="true" pagination="true" rownumbers="true"
				fitColumns="true" toolbar="#resource-toolbar"
				data-options="url:'/resource/findlist',method:'get'">
				<thead>
					<tr>
						<th data-options="field:'id',width:80">ID</th>
						<th data-options="field:'name',width:80,align:'right'">名称</th>
						<th data-options="field:'url',width:80,align:'right'">资源地址</th>
					</tr>
				</thead>
			</table>


			<div id="resource-toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-save" plain="true" data-cmd="saveList">生成权限</a>
			</div>
		</div>
	</div>


	<!-- 查询对话框 -->
	<div id="permission-search-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		modal="true" buttons="#search-dlg-buttons">
		<div class="ftitle">权限查询条件</div>
		<form id="permission-search-form" method="post" novalidate>
			<input type="hidden" name="id">
			<div class="fitem">
				<label>权限名称:</label> <input type="test" name="name"
					class="easyui-textbox">
			</div>
			<div class="fitem">
				<label>资源地址:</label> <input type="test" name="resource"
					class="easyui-textbox">
			</div>
		</form>
	</div>
	<div id="search-dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" data-cmd="doSearch">查询</a> <a
			href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-reload" data-cmd="resetSearchForm">重置</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" data-cmd="closeSearchDlg">取消</a>
	</div>
	<!-- 编辑对话框 -->
	<div id="permission-dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		modal="true" buttons="#dlg-buttons">
		<div class="ftitle">权限编辑</div>
		<form id="permission-search-form" method="post" novalidate>
			<input type="hidden" name="id"> <input type="hidden"
				name="resource">
			<div class="fitem">
				<label>权限名称:</label> <input type="test" name="name"
					class="easyui-textbox">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-ok" data-cmd="save">确定</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconCls="icon-cancel" data-cmd="close">取消</a>
	</div>
</body>
</html>