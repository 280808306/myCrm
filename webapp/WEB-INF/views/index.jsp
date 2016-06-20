<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>crm后台管理主界面</title>
<script type="text/javascript" src="/js/index.js"></script>
</head>
<body class="easyui-layout" fit="true" style="overflow-y:hidden; " border="false" scroll="no">
        <div data-options="region:'north',split:false" style="height:60px; overflow: hidden;
        background: url(/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        ">
        	 <img alt="logo" src="/images/logo.png" style=" width:100px; height:50px; margin-top: 5px; margin-left: 30px;">
        	 <div style="line-height:60px; height:60px; overflow:hidden; font-size:20px; width:auto;  margin-left: 30px; display: inline-block; color: #ffffff;">CRM管理系统  </div>
        	 <div style="line-height:60px; height:60px; margin-right:20px; float:right; font-size: 14px;" >
        	   <span style="color: blue;">欢迎你:</span> <span style="color: #ffffff;">${userInSession.username}</span>
        	 </div>
        </div>
        
        <div data-options="region:'south',split:false" style="height:50px;">
       		 <div style="text-align: center; height: 50px; line-height: 50px; color: blue; font-size: 16px;">
        		CRM关系管理系统By&copy;第八小组
        	</div>
        </div>
        
        <div data-options="region:'west',split:false" title="导航菜单" style="width:180px;">
        	<!-- 菜单 获取菜单的url 禁止拖拽 dnd = false -->
            <ul id="menuTree"></ul>
        </div>
        
        <div id="main" data-options="split:false,region:'center',iconCls:'icon-ok'" style="overflow-y:hidden;">
            <div id="mainTabs" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                <div title="欢迎页面" data-options="href:'/index/welcome'" style="padding:10px"></div>
            </div>
        </div>
</body>
</html>