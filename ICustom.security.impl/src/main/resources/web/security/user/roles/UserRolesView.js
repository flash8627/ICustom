var UserRolesView = function() {
    /**用户角色表格行*/
	var generateUserRoleTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('user_roles_info_template', item);
    };
    /**角色表格行*/
	var generateRolesTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('roles_info_template', item);
    };
    /**主表*/
    var generateUserRoleTableHtml = function(user) {
        return TemplateUtil.renderHtml('user_roles_table_template', user);
    };
	var index = 0;
    return {
    	addTabClassifyInfo:function(user){
    		var html = generateUserRoleTableHtml(user);return html;
    	},
    	initInsertUserRoleRow: function(userAccount,items) {
    		//user_roles_{{code}}_table
    		var table = 'user_roles_'+userAccount+'_table';
    		var tbody = $('#'+table).find('tbody');
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var html = generateUserRoleTableTrHtml(items[i]);
                $(tbody).prepend(html);
            }
        },
        initInsertRolesRow: function(user,items) {
    		//user_roles_{{code}}_table
    		var table = 'roles_select_table';
    		var tbody = $('#'+table).find('tbody');
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var item = items[i];
            	item.userId = user.userId;
            	var html = generateRolesTableTrHtml(item);
                $(tbody).prepend(html);
            }
        },
        deleteUserRoleRow:function(userAccount,items) {
        	var table = 'user_roles_'+userAccount+'_table';
            for(var nav in items){
            	$('#'+table).find('tbody').find('tr[data-id="' + items[nav].id + '"]').remove();
            }
        },
    	insertUserRoleRow: function(code,item) {
    		//user_roles_{{code}}_table
    		var table = 'user_roles_'+code+'_table';
            var html = generateUserRoleTableTrHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	addTabPanel:function(user,data){
    		var tabId = 'Tab_' + user.userAccount;
    		if ($('#User_tt').tabs('exists', user.username)){
    			$('#User_tt').tabs('select', user.username);
    		} else {
    			var tableId = 'user_roles_'+user.userAccount+'_table';
    			var title = user.username;
    			var content = UserRolesView.addTabClassifyInfo(user);
    			var gridNode = $(content).find('#'+tableId).find('tbody');
    			var cls = $(content).find('.'+user.userAccount);
    			$('#User_tt').tabs('add',{
					title : title,
					id : tabId,
					tabWidth : title * 10 + 30,
					fit : true,
					content : content,
					closable : true
    			});
    			//数据插入视图--用户的角色
    			UserRolesView.initInsertUserRoleRow(user.userAccount,data.userRoles);
    			//全部角色
    			UserRolesView.initInsertRolesRow(user,data.roles);
    		}
    	}
    };
}();