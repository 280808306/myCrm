/**
 * 起始页面的js
 */
$(function() {
	// 1.缓存控件 easyui 全局
	var menuTree = $('#menuTree');
	var mainTabs = $("#mainTabs");
	console.debug(menuTree);
	// 2.加载菜单
	menuTree.tree({
		url : '/index/menus',
		method : 'get',
		animate : true,
		dnd : false,
		onClick : function (node) {
			var tabTitle = node.text;
			var url = node.url;
			// 添加一个tab在主界面中
			// 如果面板已经存在
			if(url){
				if (mainTabs.tabs('exists', tabTitle)) {
					mainTabs.tabs('select', tabTitle);
				} else {
					mainTabs.tabs('add', {
						headerWidth: 100,
						title : tabTitle,
						content : '<iframe src="'+ url +'" id="rightIframe" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" name="main"'+
						'style="width:99%;height:99%; text-align:center; margin:5px;""></iframe>',
						closable : true,
						width:$('#main').width()-10,
						height:$('#main').height()-26
					});
				}
			}
		}
	});
});



