var UserRolesService = function() {
    var BASE = '../../services/sys/userRolesService';
    return {
    	initUserRoleItems: function(user,callback) {
            AjaxUtil.sendGetRequest(BASE + '/getUserRoles/'+user.userId+'/0', function(resp) {
            	UserRolesView.addTabPanel(user,resp);
                callback();
            });
        },
    	findUserRoles: function(user,callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupItems/'+user.classId, function(resp) {
            	UserRolesView.addTabPanel(user,resp.obj);
                callback();
            });
        },
        findUserRoleById: function(itemId) {
        	var item = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(userRoles) {
            	item = userRoles;
                return item;
            });
            return item;
        },
        batchInsertUserRole: function(userAccount,items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(userRoles) {
            	var items = userRoles.obj;
            	for(var i=0;i<items.length;i++){
            		//插入行
            		UserRolesView.insertUserRoleRow(user.userAccount,items[i]);
            	}
            });
        },
        batchUpdateUserRole: function(userAccount,items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(userRoles) {
            	var items = userRoles.obj;
            	for(var i=0;i<items.length;i++){
            		//插入行
            		UserRolesView.insertUserRoleRow(lookup.userAccount,items[i]);
            	}
            });
        },
        batchRemoveUserRole: function(userAccount,items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
            	UserRolesView.deleteUserRoleRow(userAccount,items);
            });
        }
    }
}();