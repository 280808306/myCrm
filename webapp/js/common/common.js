//一些公共的js 

/**
 * 简单对象显示的formatter 只能返回字符串
 * value,当前列对应字段的值 一般是一个对象
 * row,  当前行的数据
 * index 当前第几行
 */
function objectFormatter(value,row,index) {
	if(value){
		//选取value对象中存在的属性    将你的属性放在后面
		return value.name||value.username;
	} else {
		return '';
	}
}

$.fn.serializeJson = function(){
	var paramObj = {};
	//将表单里的参数序列化成json对象
	var params = $(this).serializeArray();
	for (var index in params) {
		//获取参数数组中的参数对象
		var param = params[index];
		//添加参数对象中的属性
		if(param.value && param.value != ''){
			paramObj[param.name] = param.value;
		}
	}
	return paramObj;
}