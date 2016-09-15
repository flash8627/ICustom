var UserService = function() {
    var BASE = '../../services/sys/userServices';
    return {
    	findUsers: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findUserList/10/1', function(list) {
                UserView.renderUserTable(list.result);
                UserView.renderUserTablePager(list.result);
                callback();
            });
        },
        findUserById: function(itemId) {
        	var result = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(user) {
            	result = user;
            	return result;
            });
            return result;
        },
        batchInsertUser: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(result) {
                UserView.insertUserRows(result.obj);
            });
        },
        batchUpdateUser: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(result) {
                UserView.insertUserRows(result.obj);
            });
        },
        deleteUserRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                UserView.deleteUserRows(items);
            });
        }
    }
}();