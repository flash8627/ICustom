/***/
var ICustom = function() {
	return {
    	confirm : function(title,message) {
            $.messager.confirm(title, message, function(r){
        		return r;
        	});
        },
        //弹出输入框,可以回调函数
        prompt : function(title,message, callback) {
        	$.messager.prompt(title, message, function(r){
        		if (r){
        			callback();
        		}
        	});
        }
    };
}();

$(function(){
	
	/*if (ICustom.confirm("标题测试","确定要删除吗？")){
		alert('confirmed: '+r);
	}else{
		alert(123);
	}*/
	
})