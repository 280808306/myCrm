<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/common/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/js/systemDictionary.js"></script>
<script type="text/javascript" src="/js/systemDictionaryItem.js"></script>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'east',split:false" style="width:50%;">
			<!-- 数据字典表格 -->
			<table id="systemDictionaryItem-datagrid">
			</table>
			<!-- 菜单工具条 -->
			<div id="systemDictionaryItem-toolbar">
				<a href="#" class="easyui-linkbutton" data-cmd="itemSave" data-options="iconCls:'icon-add',text:'添加'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemUpdate" data-options="iconCls:'icon-edit',text:'修改'"></a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemDelete" data-options="iconCls:'icon-remove',text:'删除'"></a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemRefresh" data-options="iconCls:'icon-reload',text:'刷新'"></a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemAll" data-options="iconCls:'icon-more',text:'所有'"></a>
				<div style="width: auto; display: inline; float: right;">
					<input id="systemDictionaryItem-searchbox" style="width: 150px;" name="name" />
					<a href="#" class="easyui-linkbutton" data-cmd="itemSearch" data-options="iconCls:'icon-search',text:'精确搜索'"></a>
				</div>
			</div>
		
		
			<%-- 系统菜单的弹出dialog --%>
			<div id="systemDictionaryItem-dialog">
				<%-- 添加修改的from表单 --%>
				<form id="systemDictionaryItem-form" method="post">
					<input type="hidden" name="id">
					<table style="margin: 20px;">
						<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">数据字典明细</caption>
						<tr>
							<td>编号:</td>
							<td>
								<input class="easyui-textbox" type="number" name="sn"  data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>数据字典名称:</td>
							<td>
								<input class="easyui-textbox" type="text" name="name" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>字典:</td>
							<td>
							  <select name="parent.id" class="easyui-combogrid" style="width:179px;" data-options="
							            panelWidth: '500px;',
							            idField: 'id',
							            textField: 'name',
							            url: '/systemDictionary/list?rows=-1',
							            method: 'get',
							            singleSelect:true,
							            columns:[[    
								        {field:'sn',title:'编号',width:80,align:'center'},    
								        {field:'name',title:'名称',width:80,align:'center'},    
								        {field:'state',title:'状态',width:80,align:'center'},
								        {field:'intro',title:'描述',width:160,align:'left'}
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
								<textarea rows="4" cols="20" name="intro"></textarea>
							</td>
						</tr>
						
					</table>
				</form>
			</div>
		
			<div id="systemDictionaryItem-dialog-buttons">
				<a href="#" class="easyui-linkbutton" data-cmd="itemEditSubmit" data-options="iconCls:'icon-ok c6',text:'确定'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemEditReset" data-options="iconCls:'icon-reload c6',text:'清空'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemEditCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
			</div>
			<%-- end 系统数据字典的弹出dialog --%>
		
			<%-- start 高级查询的dialog--%>
			<div id="systemDictionaryItem-search-dialog">
				<%-- 高级查询的from表单 --%>
				<form id="systemDictionaryItem-search-form" method="post">
					<table style="margin: 20px;">
						<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">数据字典搜索</caption>
						<tr>
							<td>序号:</td>
							<td>
								<input class="easyui-textbox" type="text" name="sn" />
							</td>
						</tr>
						<tr>
							<td>字典详细项:</td>
							<td>
								<input class="easyui-textbox" type="text" name="name" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		
			<div id="systemDictionaryItem-search-dialog-buttons">
				<a href="#" class="easyui-linkbutton" data-cmd="itemSearchSubmit" data-options="iconCls:'icon-ok',text:'确定'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemSearchReset" data-options="iconCls:'icon-reload',text:'清空'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="itemSearchCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
			</div>
        </div>
        
		<%-- 数据字典  ################################################################################################ --%>
		<div data-options="region:'center'" style="width:50%;">
           	<!-- 数据字典表格 -->
			<table id="systemDictionary-datagrid">
			</table>
			<!-- 菜单工具条 -->
			<div id="systemDictionary-toolbar">
				<a href="#" class="easyui-linkbutton" data-cmd="save" data-options="iconCls:'icon-add',text:'添加'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="update" data-options="iconCls:'icon-edit',text:'修改'"></a>
				<a href="#" class="easyui-linkbutton" data-cmd="delete" data-options="iconCls:'icon-remove',text:'删除'"></a>
				<a href="#" class="easyui-linkbutton" data-cmd="refresh" data-options="iconCls:'icon-reload',text:'刷新'"></a>
				<div style="width: auto; display: inline; float: right;">
					<input id="systemDictionary-searchbox" style="width: 150px;" name="name" />
					<a href="#" class="easyui-linkbutton" data-cmd="search" data-options="iconCls:'icon-search',text:'精确搜索'"></a>
				</div>
			</div>
		
		
			<%-- 系统菜单的弹出dialog --%>
			<div id="systemDictionary-dialog">
				<%-- 添加修改的from表单 --%>
				<form id="systemDictionary-form" method="post">
					<input type="hidden" name="id">
					<table style="margin: 20px;">
						<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">数据字典</caption>
						<tr>
							<td>编号:</td>
							<td>
								<input class="easyui-textbox" type="text" name="sn" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>数据字典名称:</td>
							<td>
								<input class="easyui-textbox" type="text" name="name" data-options="required:true"/>
							</td>
						</tr>
						<tr>
							<td>状态:</td>
							<td>
								<select class="easyui-combobox" name="state" style="width: 180px;" data-options="panelHeight:'auto'">
									    <option value="1" selected="selected">正常</option>   
									    <option value="-1">停用</option>   
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
		
			<div id="systemDictionary-dialog-buttons">
				<a href="#" class="easyui-linkbutton" data-cmd="editSubmit" data-options="iconCls:'icon-ok c6',text:'确定'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="editReset" data-options="iconCls:'icon-reload c6',text:'清空'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="editCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
			</div>
			<%-- end 系统数据字典的弹出dialog --%>
		
			<%-- start 高级查询的dialog--%>
			<div id="systemDictionary-search-dialog">
				<%-- 高级查询的from表单 --%>
				<form id="systemDictionary-search-form" method="post">
					<table style="margin: 20px;">
						<caption style="border-bottom: 1px solid #EEEEEE; padding-bottom: 5px; margin-bottom: 5px; font-weight: bold; color: gray;">数据字典搜索</caption>
						<tr>
							<td>编号:</td>
							<td>
								<input class="easyui-textbox" type="text" name="sn" />
							</td>
						</tr>
						<tr>
							<td>数据字典名称:</td>
							<td>
								<input class="easyui-textbox" type="text" name="name" />
							</td>
						</tr>
						<tr>
							<td>状态:</td>
							<td>
								<select class="easyui-combobox" name="state" style="width: 180px;" data-options="panelHeight:'auto'">
									    <option value="1" selected="selected">正常</option>   
									    <option value="-1">停用</option>   
					       		</select>
							</td>
						</tr>
					</table>
				</form>
			</div>
		
			<div id="systemDictionary-search-dialog-buttons">
				<a href="#" class="easyui-linkbutton" data-cmd="searchSubmit" data-options="iconCls:'icon-ok',text:'确定'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="searchReset" data-options="iconCls:'icon-reload',text:'清空'"> </a>
				<a href="#" class="easyui-linkbutton" data-cmd="searchCancel" data-options="iconCls:'icon-cancel',text:'取消'"></a>
			</div>
	      </div>
    </div>
	
</body>
</html>