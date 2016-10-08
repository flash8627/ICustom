var RoleAuthoritiesView = function() {
    /**表格行*/
	var generateRoleAuthsTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('roles_auth_info_template', item);
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
    	initInsertAuthsRow: function(roleId,auths) {
    		//role_item_{{code}}_table
    		var table = 'role_item_'+roleId+'_table';
    		var tbody = $('#'+table).find('tbody');
    		
    		var items = auths.auths.result;
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var html = generateRoleAuthsTableTrHtml(items[i]);
                $(tbody).prepend(html);
            }
        },
        deleteRoleAuths:function(roleId,items) {
        	var table = 'role_item_'+roleId+'_table';
            for(var nav in items){
            	$('#'+table).find('tbody').find('tr[data-id="' + items[nav].id + '"]').remove();
            }
        },
    	insertRoleAuthRow: function(roleId,item) {
    		//role_item_{{code}}_table
    		var table = 'role_item_'+roleId+'_table';
            var html = generateRoleAuthsTableTrHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	addTabPanel:function(role,auths){
    		var tabId = 'Tab_' + role.roleId;
    		if ($('#Role_tt').tabs('exists', role.roleName)){
    			$('#Role_tt').tabs('select', role.roleName);
    		} else {
    			var tableId = 'role_item_'+role.roleId+'_table';
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
    			RoleAuthoritiesView.initInsertAuthsRow(role.roleId,auths);
    		}
    	}
    };
}();