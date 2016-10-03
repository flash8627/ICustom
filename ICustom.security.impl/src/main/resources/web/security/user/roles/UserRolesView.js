var UserRolesView = function() {
	/**表格编辑行*/
	var generateUserRoleTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('user_roles_form_template', item);
    };
    /**表格行*/
	var generateUserRoleTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('user_roles_info_template', item);
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
    	initInsertUserRoleRow: function(code,items) {
    		//user_item_{{code}}_table
    		var table = 'user_item_'+code+'_table';
    		var tbody = $('#'+table).find('tbody');
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var html = generateUserRoleTableTrHtml(items[i]);
                $(tbody).prepend(html);
            }
        },
        deleteUserRoleRow:function(userAccount,items) {
        	var table = 'user_item_'+userAccount+'_table';
            for(var nav in items){
            	$('#'+table).find('tbody').find('tr[data-id="' + items[nav].itemId + '"]').remove();
            }
        },
    	insertUserRoleEditorRow: function(code,item) {
    		//user_item_{{code}}_table
    		var table = 'user_item_'+code+'_table';
            var html = generateUserRoleTrEditorHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	insertUserRoleRow: function(code,item) {
    		//user_item_{{code}}_table
    		var table = 'user_item_'+code+'_table';
            var html = generateUserRoleTableTrHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	addTabPanel:function(user,userItem){
    		var tabId = 'Tab_' + user.userAccount;
    		if ($('#User_tt').tabs('exists', user.username)){
    			$('#User_tt').tabs('select', user.username);
    		} else {
    			var tableId = 'user_item_'+user.userAccount+'_table';
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
    			UserRolesView.initInsertUserRoleRow(user.userAccount,userItem);
    		}
    	}
    };
}();