var RoleAuthoritiesView = function() {
	/**表格编辑行*/
	var generateUserRoleTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('role_roles_form_template', item);
    };
    /**表格行*/
	var generateUserRoleTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('role_roles_info_template', item);
    };
    /**主表*/
    var generateUserRoleTableHtml = function(role) {
        return TemplateUtil.renderHtml('role_auths_table_template', role);
    };
	var index = 0;
    return {
    	addTabClassifyInfo:function(role){
    		var html = generateUserRoleTableHtml(role);return html;
    	},
    	initInsertUserRoleRow: function(code,items) {
    		//role_item_{{code}}_table
    		var table = 'role_item_'+code+'_table';
    		var tbody = $('#'+table).find('tbody');
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var html = generateUserRoleTableTrHtml(items[i]);
                $(tbody).prepend(html);
            }
        },
        deleteUserRoleRow:function(roleName,items) {
        	var table = 'role_item_'+roleName+'_table';
            for(var nav in items){
            	$('#'+table).find('tbody').find('tr[data-id="' + items[nav].itemId + '"]').remove();
            }
        },
    	insertUserRoleEditorRow: function(code,item) {
    		//role_item_{{code}}_table
    		var table = 'role_item_'+code+'_table';
            var html = generateUserRoleTrEditorHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	insertUserRoleRow: function(code,item) {
    		//role_item_{{code}}_table
    		var table = 'role_item_'+code+'_table';
            var html = generateUserRoleTableTrHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	addTabPanel:function(role,roleItem){
    		var tabId = 'Tab_' + role.roleName;
    		if ($('#Role_tt').tabs('exists', role.roleName)){
    			$('#Role_tt').tabs('select', role.roleName);
    		} else {
    			var tableId = 'role_item_'+role.roleName+'_table';
    			var title = role.roleName;
    			var content = RoleAuthoritiesView.addTabClassifyInfo(role);
    			var gridNode = $(content).find('#'+tableId).find('tbody');
    			var cls = $(content).find('.'+role.roleName);
    			$('#Role_tt').tabs('add',{
					title : title,
					id : tabId,
					tabWidth : title * 10 + 30,
					fit : true,
					content : content,
					closable : true
    			});
    			RoleAuthoritiesView.initInsertUserRoleRow(role.roleName,roleItem);
    		}
    	}
    };
}();