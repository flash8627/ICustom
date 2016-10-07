var UserRolesService = function() {
    var BASE = '../../services/sys/userRolesService';
    return {
    	findUserRoles: function(user) {
    		var userRoles = [];
    		AjaxUtil.sendGetAsyncRequest(BASE + '/getUserRoles/'+user.userId+'/0', function(resp) {
    			userRoles = resp;
        		return userRoles;
            });
    		return userRoles;
        },
        findSysRoles: function(user) {
    		var roles = [];
    		AjaxUtil.sendGetAsyncRequest(BASE + '../../../../services/sys/rolesService/findRolesList/1000/1', function(resp) {
    			roles = resp.result;
        		return roles;
            });
    		return roles;
        },
        batchInsertUserRole: function(userAccount,items) {
            AjaxUtil.sendPostData(BASE + '/saveOrUpdate', items, function(userRoles) {
            	var items = userRoles.obj;
            	for(var i=0;i<items.length;i++){
            		//插入行
            		UserRolesView.insertUserRoleRow(user.userAccount,items[i]);
            	}
            });
        },
        batchRemoveUserRoles: function(userAccount,items) {
            AjaxUtil.sendPutData(BASE + '/delete',items, function() {
            	UserRolesView.deleteUserRoleRow(userAccount,items);
            });
        }
    }
}();