var RegisterService = function() {
    var BASE = '../services/register/registerService';
    return {
    	findRegisters: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findRegisterList', function(list) {
                RegisterView.renderRegisterTable(list);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findRegisterList/'+itemId, function(list) {
                RegisterView.renderRegisterTable(list);
                callback();
            });
        },
        findRegisterById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findRegister/' + itemId, function(register) {
                var title = 'Edit Register';
                RegisterView.renderRegisterModal(title, register);
            });
        },
        batchInsertRegister: function(items,callback) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
            	callback();
            });
        },
        batchUpdateRegister: function(register,callback) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', register, function(register) {
            	callback(register);
            });
        },
        batchRemoveRegister: function(items,callback) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks', items, function() {
            	callback();
            });
        }
    }
}();