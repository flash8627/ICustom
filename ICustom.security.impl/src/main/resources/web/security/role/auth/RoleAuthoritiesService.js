var RolesAuthoritiesService = function() {
    var BASE = '../../services/sys/roleAuthoritiesService';
    return {
    	initRoleAuthorities: function(role,callback) {
            AjaxUtil.sendGetRequest(BASE + '/findRoleAuthorities/'+role.roleId, function(resp) {
            	RoleAuthoritiesView.addTabPanel(role,resp);
                callback();
            });
        },
    	findRoleAuthorities: function(role,callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupItems/'+role.classId, function(resp) {
            	RoleAuthoritiesView.addTabPanel(role,resp.obj);
                callback();
            });
        },
        findUserRoleById: function(itemId) {
        	var item = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(roleAuths) {
            	item = roleAuths;
                return item;
            });
            return item;
        },
        batchInsertUserRole: function(roleAccount,items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(roleAuths) {
            	var items = roleAuths.obj;
            	for(var i=0;i<items.length;i++){
            		//插入行
            		RoleAuthoritiesView.insertUserRoleRow(role.roleName,items[i]);
            	}
            });
        },
        batchUpdateUserRole: function(roleName,items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(userRoles) {
            	var items = userRoles.obj;
            	for(var i=0;i<items.length;i++){
            		//插入行
            		RoleAuthoritiesView.insertUserRoleRow(lookup.roleName,items[i]);
            	}
            });
        },
        batchRemoveUserRole: function(roleName,items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
            	RoleAuthoritiesView.deleteUserRoleRow(roleName,items);
            });
        }
    }
}();