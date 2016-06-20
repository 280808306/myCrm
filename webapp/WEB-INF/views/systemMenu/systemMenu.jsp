<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入公共的头文件  --%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/systemMenu.js"></script>
</head>
<body>
	<!-- 	
		添加
		1. 编写界面的dialog显示 控制显示的样式
		2. 修改form表单中的内容  注意验证 和样式
		3. 控制表单中的按钮 dialog下的按钮
		4. 监听按钮的事件 
	-->
	<%-- 
		修改
		1. 界面调整 注意要传的隐藏域
		2. 监听修改按钮
		3. 获取表格里的数据 回显
		4. 弹出 dialog  处理form参数
		5. 按钮监听
		6. 提交from 
	--%>
	<%-- 
		删除
		1. 监听修改按钮
		2. 获取表格里的数据 传入修改的id
		3. 按钮监听
		4. 提交from
		5. 删除的后台url实现
	--%>
	<!-- 菜单表格 -->
	<table id="systemMenu-datagrid">
	</table>
	<!-- 菜单工具条 -->
	<div id="systemMenu-toolbar">
		<a href="#" class="easyui-linkbutton" data-cmd="save" data-options="iconCls:'icon-add',text:'添加'"> </a>
		<a href="#" class="easyui-linkbutton" data-cmd="update" data-options="iconCls:'icon-edit',text:'修改'"></a>
		<a href="#" class="easyui-linkbutton" data-cmd="delete" data-options="iconCls:'icon-remove',text:'删除'"></a>
		<a href="#" class="easyui-linkbutton" data-cmd="refresh" data-options="iconCls:'icon-reload',text:'刷新'"></a>
		<div style="width: auto; display: inline; float: right;">
			<input id="systemMenu-searchbox" style="width: 250px;" name="name" />
			<a href="#" class="easyui-linkbutton" data-cmd="search" data-options="iconCls:'icon-search',text:'精确搜索'"></a>
		</div>
	</div>


	<%-- 系统菜单的弹出dialog --%>
	<div id="systemMenu-dialog">
		<%-- 添加修改的from表单 --%>
		<form id="systemMenu-form" method="post">
			<input type="hidden" name="id">
			<table style="margin: 20px;">
				<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">系统菜单</caption>
				<tr>
					<td>编号:</td>
					<td>
						<input class="easyui-textbox" type="text" name="sn" data-options="required:true"/>
					</td>
				</tr>
				<tr>
					<td>菜单名称:</td>
					<td>
						<input class="easyui-textbox" type="text" name="name" data-options="required:true"/>
					</td>
				</tr>
				<tr id="edit-icon-tr">
					<%-- 这里可以根据图标字符串来动态的显示一个图标的效果  监听onblur事件来实现 --%>
					<td>图标:</td>
					<td>
						<input class="easyui-textbox" type="text" name="icon" />
					</td>
					<td>
						<div id="icon-systemMenu" style="height: 16px; width: 16px;"></div>
					</td>

				</tr>
				<tr>
					<td>地址:</td>
					<td>
						<input class="easyui-textbox" type="text" name="url" />
					</td>
				</tr>
				<tr>
					<td>父菜单:</td>
					<td>
						<select class="easyui-combotree" name="parent.id" style="width: 160px;" data-options="
				       			 url:'/index/menus',
				       			 panelHeight:'auto'
			       			"></select>
					</td>
				</tr>
				<tr>
					<td>权限:</td>
					<td>
						 <select name="permission.id" class="easyui-combogrid" style="width:160px;" data-options="
							            panelWidth: '500px;',
							            idField: 'id',
							            textField: 'name',
							            url: '/permission/list',
							            method: 'get',
							            singleSelect:true,
							            pagination:true,
							            columns:[[    
									        {field:'name',title:'名称',width:80,align:'center'},    
									        {field:'resource',title:'资源',width:80,align:'center'}
	    								]],
							            fitColumns: true,
							            required:true
							        ">
						</select>
					</td>
				</tr>
				<tr>
					<td>描述:</td>
					<td>
						<textarea rows="2" cols="16" name="intro"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="systemMenu-dialog-buttons">
		<a href="#" class="easyui-linkbutton" data-cmd="editSubmit" data-options="iconCls:'icon-ok c6',text:'确定'"> </a>
		<a href="#" class="easyui-linkbutton" data-cmd="editReset" data-options="iconCls:'icon-reload c6',text:'清空'"> </a>
		<a href="#" class="easyui-linkbutton" data-cmd="editCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
	</div>
	<%-- end 系统菜单的弹出dialog --%>

	<%-- start 高级查询的dialog--%>
	<div id="systemMenu-search-dialog">
		<%-- 高级查询的from表单 --%>
		<form id="systemMenu-search-form" method="post">
			<table style="margin: 20px;">
				<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">菜单搜索</caption>
				<tr>
					<td>编号:</td>
					<td>
						<input class="easyui-textbox" type="text" name="sn" />
					</td>
				</tr>
				<tr>
					<td>菜单名称:</td>
					<td>
						<input class="easyui-textbox" type="text" name="name"/>
					</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td>
						<input class="easyui-textbox" type="text" name="url" />
					</td>
				</tr>
				<tr>
					<td>父菜单:</td>
					<td>
						<%--这里搜索的name 要和查询对象中的字段对应 --%>
						<select class="easyui-combotree" name="parentId" style="width: 180px;" data-options="
				       			 url:'/index/menus',
				       			 panelHeight:'auto'
			       			"></select>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="systemMenu-search-dialog-buttons">
		<a href="#" class="easyui-linkbutton" data-cmd="searchSubmit" data-options="iconCls:'icon-ok c6',text:'确定'"> </a>
		<a href="#" class="easyui-linkbutton" data-cmd="searchReset" data-options="iconCls:'icon-reload c6',text:'清空'"> </a>
		<a href="#" class="easyui-linkbutton" data-cmd="searchCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
	</div>
</body>
</html>
