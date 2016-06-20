<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- 导入公共的头文件  --%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/systemLog.js"></script>
</head>
<body>
	
	<%-- 
		删除
		1. 监听修改按钮
		2. 获取表格里的数据 传入修改的id
		3. 按钮监听
		4. 提交from
		5. 删除的后台url实现
	--%>
	<!-- 菜单表格 -->
	<table id="systemLog-datagrid">
	</table>
	<!-- 菜单工具条 -->
	<div id="systemLog-toolbar" style="padding: 5px;">
			<form id="searchForm" style="display: inline; width: auto;">
		        <label for="keyword">关键词:</label>   
		        <input class="easyui-textbox" type="text" name="keyword" style="width:100px;"/> 
		        <div id="search-conditions" style="display: inline; width: auto;">  
			        <label for="userId">用户:</label>   
			        <input class="easyui-textbox" type="text" name="userId" style="width:100px;"/>   
			        <label for="startTime">从:</label>   
			        <input class="easyui-datetimebox" type="datetime" name="startTime" style="width:100px"/>   
			        <label for="startTime">到:</label>   
			        <input class="easyui-datetimebox" type="datetime" name="endTime" style="width:100px" /> 
		        </div>  
			</form>
		    <a href="#" id="search-more" class="easyui-linkbutton" data-cmd="searchMore" data-options="iconCls:'icon-more',text:'更多',plain:true"></a>
			<a href="#" class="easyui-linkbutton" data-cmd="searchSubmit" data-options="iconCls:'icon-search',text:'搜索'"></a>
		<div style="width: auto; display: inline; float: right;">
			<a href="#" class="easyui-linkbutton" data-cmd="delete" data-options="iconCls:'icon-remove',text:'删除'"></a>
			<a href="#" class="easyui-linkbutton" data-cmd="refresh" data-options="iconCls:'icon-reload',text:'刷新'"></a>
		</div>
	</div>
</body>
</html>
