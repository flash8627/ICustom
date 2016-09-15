var RoleService = function() {
    var BASE = '../../services/sys/rolesService';
    return {
    	findRoles: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findRoleList/10/1', function(list) {
                RoleView.renderRoleTable(list.result);
                RoleView.renderRoleTablePager(list.result);
                callback();
            });
        },
        findRoleById: function(itemId) {
        	var result = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(role) {
            	result = role;
            	return result;
            });
            return result;
        },
        batchInsertRole: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(result) {
                RoleView.insertRoleRows(result.obj);
            });
        },
        batchUpdateRole: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(result) {
                RoleView.insertRoleRows(result.obj);
            });
        },
        deleteRoleRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                RoleView.deleteRoleRows(items);
            });
        }
    }
}();