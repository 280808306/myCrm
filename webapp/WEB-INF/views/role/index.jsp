<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
    //---页面加载完毕后---
	$(function(){
		// 1. 声明页面中可能会用到组件
		var roleGrid,roleDlg,roleForm,selectedPermissiongrid,allPermissiongrid;
		
		// 2. 缓存页面组件
		roleGrid = $("#roleGrid");
		roleDlg = $("#roleDlg");
		roleForm = $("#roleForm");
		selectedPermissiongrid = $("#selectedPermissiongrid");
		allPermissiongrid = $("#allPermissiongrid");

		// 3. 定义一个事件处理对象,把事件相关的逻辑都封装到一个对象上(命令对象)
		var cmdObj = {
				create:function(){
						//console.debug('create:function');
						//reset : 重置为初始值(定义方式:1.input的value属性写死;2.使用form的load方法加载后的属性)
						//clear : 清空
					roleForm.form("clear");
					$("#sn").val('');
					$("#name").val('');
					// 清空表格,加载空数据
					selectedPermissiongrid.datagrid("loadData",{rows:[]});
					
					roleDlg.dialog("open");
				},
				edit:function(){
						//console.debug('edit:function');
					// 获取行选中数据
					var rowData = roleGrid.datagrid("getSelected");
					// 判断
					if(!rowData){
						$.messager.alert("温馨提示","请选中一行!!","info");
						return;
					}
					// 重置表单
					roleForm.form("reset");
					// 打开对话框
					roleDlg.dialog("open");
					
					// 数据转换/封装
					if(rowData.manager)
						rowData['manager.id'] = rowData.manager.id;
					if(rowData.parent)
						rowData['parent.id'] = rowData.parent.id;
					
					// 加载数据
					/*
					 * form的load方法运行的机制:根据表单中元素的name属性,去json对象中,取值.
						 例如: <input name="dept.name">  , {name:"zs",dept:{name:""}}  >> obj["dept.name"]
					                             针对上面特殊情况,{name:"zs",dept:{name:""}}>> {name:"zs",dept:{name:"ls"},"dept.name":"zs"}
					 */
					roleForm.form("load",rowData);
					 
					 
					 // 动态加载已选权限信息
					 $.get("/permission/getPermissions",{"roleId":rowData.id},function(data){
						 selectedPermissiongrid.datagrid("loadData",data);
					 },"json");
					
				},
				del:function(){
						//console.debug('del:function');
					// 获取行选中数据
					var rowData = roleGrid.datagrid("getSelected");
					// 判断
					if(!rowData){
						$.messager.alert("温馨提示","请选中一行!!","info");
						return;
					}
					$.messager.confirm("温馨提示","是否要删除该角色?",function(yes){
						if(yes){
							$.get("/role_delete",{"id":rowData.id},function(data){
								console.debug(data);
								if(data.status){
									// 关闭对话框
									roleDlg.dialog("close");
									// 提示,刷新
									$.messager.alert("温馨提示",data.msg,"info",function(){
										// 刷新表格数据
										roleGrid.datagrid("reload");
									});
								}else{
									$.messager.alert("温馨提示",data.msg,"info",function(){
										// 根据错误码,定位到单元格
									});
								}
							},"json");
						}
					});
				},
				refresh : function(){
					roleGrid.datagrid("reload");
				},
				save: function(){
					roleForm.submit();
				},
				cancel : function(){
					roleDlg.dialog("close");
				}
				
			};
		// 4. 初始化组件
		roleGrid.datagrid({
				url:"/role_list",
				fit:true,
				border:false,
				fitColumns:true	,
				striped:true,
				toolbar:[{
					text:"添加",
					iconCls:"icon-add",
					plain:true,
					handler:cmdObj['create']
				},{
					text:"编辑",
					iconCls:"icon-edit",
					plain:true,
					handler:cmdObj['edit']
				},{
					text:"删除",
					iconCls:"icon-remove",
					plain:true,
					handler:cmdObj['del']
				},{
					text:"刷新",
					iconCls:"icon-reload",
					plain:true,
					handler:cmdObj['refresh']
				}],//"#roleTb",
				rownumbers:true,
				singleSelect:true,
				pagination:true,
				columns:[[
			          {field:'sn',title:'角色编号',width:1},    
			          {field:'name',title:'角色名称',width:1},    
     
	          ]]
		});
		
		roleDlg.dialog({
			width: 950,
			height: 420,
			title:"添加/编辑角色信息",
			closed:true,
			modal:true,
			buttons:[{
				text:"添加",
				iconCls:"icon-save",
				handler:cmdObj['save']
			},{
				text:"取消",
				iconCls:"icon-cancel",
				handler:cmdObj['cancel']
			}]//"#roleDlgBtn"
		});
		
		// 角色表单
		roleForm.form({
			url:"/role_save",
			onSubmit: function(param){    
			        //param.p1 = 'value1';    
			        //param.p2 = 'value2';   
			        //console.debug(param.permissions[0].id);
			        //param["permissions["+i+"].id"]=row.id;
			       /*  param["permissions[0].id"]=5;
			        param["permissions[1].id"]=7;
			        param["permissions[4].id"]=9; */
			        
			        // 定位到选中表格
			        // 获取表格中的选中的权限数据集合
			        var selectedPermissions = selectedPermissiongrid.datagrid("getRows");
			        // 遍历，拼装需要的结构
			        $.each(selectedPermissions,function(index,newPermission){
			        	param["permissions["+index+"].id"]=newPermission.id;
			        });
			}    
			,
			success:function(data){
				// 把响应结果转换成JSON对象
			    var data = $.parseJSON(data);
				if(data.status){
					// 关闭对话框
					roleDlg.dialog("close");
					// 提示,刷新
					$.messager.alert("温馨提示",data.msg,"info",function(){
						// 刷新表格数据
						roleGrid.datagrid("reload");
					});
				}else{
					$.messager.alert("温馨提示",data.msg,"info",function(){
						// 根据错误码,定位到单元格
					});
				}
			}
		});
		
		allPermissiongrid.datagrid({
			url:"/permission/list",
			width:450,
			height:300,
			title:"所有权限",
			//fit:true,
			border:true,
			fitColumns:true,
			striped:true,
			rownumbers:true,
			singleSelect:true,
			pagination:true,
			toolbar:"#permissionSearchBox",
			columns:[[
		          {field:'name',title:'权限名称',width:1},    
		          {field:'resource',title:'权限资源',width:5},    
 
          	]],
          	onDblClickRow:function(i,r){
          		// 获取选中行
          		console.debug(r);
          		// 获取左边grid,获取选中的所有记录
          		var selectedRows =selectedPermissiongrid.datagrid("getRows");
          		// 遍历
          		var isRepeat = false;
          		$.each(selectedRows,function(index,rowData){
          			if(rowData.id==r.id){// 如果新增权限的id在已选中列表中重复
          				isRepeat = true; // 标记
          				return;
          			}
          		});
          		
          		// 把数据添加过去
          		if(!isRepeat){// 判断
	          		selectedPermissiongrid.datagrid("appendRow",r);
          			
          		}else{
                    $.messager.show({
                        title:'温馨提示',
                        msg:'该权限已存在！！',
                        showType:'fade',
                        timeout:1000,
                        style:{
                            right:'',
                            bottom:''
                        }
                    });
          		}
          	} 
		});
		
		
		var pager =allPermissiongrid.datagrid("getPager");
		pager.pagination({
            showPageList: false, // 是否显示每页长度配置
            showRefresh: false,  // 是否显示刷新按钮
            displayMsg: ''  // 是否显示右边的文字内容
		});
	
		
		selectedPermissiongrid.datagrid({
			title:"已选权限",
			width:450,
			height:300,
			border:true,
			fitColumns:true	,
			striped:true,
			rownumbers:true,
			singleSelect:true,
			columns:[[
		          {field:'name',title:'权限名称',width:1},    
		          {field:'resource',title:'权限资源',width:5},    
 
          ]]
		,onDblClickRow:function(i,r){
			selectedPermissiongrid.datagrid("deleteRow",i);
		}
		});
	});
    
    function doSearch(){
    	
    }
</script>
</head>
<body>
	<!-- 1. 表格-->
	<table id="roleGrid">
	</table>
	<!-- 2. 对话框-->
	<div id="roleDlg" >
	<font style="font-weight: bold;"></font>
		<form id="roleForm" method="post">
			<input name="id" type="hidden">
			<table align="center" style="margin-top: 10px;">
				<tr>
					<td colspan="2" height="15">角色编号：<input id="sn" name="sn">&emsp;&emsp;角色名称：<input id="name" name="name"></td>
				</tr>
				<tr>
					<td>
						<table id="selectedPermissiongrid"  name="xxx"></table>
					</td>
					<td>
						<table id="allPermissiongrid"></table>
					</td>
				</tr>
			</table>
		</form>
	</div>
	
    <div id="permissionSearchBox">
    	<input class="easyui-searchbox" data-options="prompt:'权限查询条件',searcher:doSearch" style="width:200px"></input>
    </div>
</body>
</html>