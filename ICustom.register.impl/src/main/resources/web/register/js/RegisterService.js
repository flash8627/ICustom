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
        },/*
        findRegistersByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/registers', {
                itemName: name
            }, function(registerList) {
                RegisterView.renderRegisterTable(registerList);
            });
        },*/
        createRegister: function(register) {
            AjaxUtil.sendPostData(BASE + '/insert', register, function(register) {
                RegisterView.insertRegisterRow(register.obj);
            });
        },
        batchInsertRegister: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                RegisterView.insertRegisterRows(items);
            });
        },
        updateRegister: function(register) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', register, function(register) {
                RegisterView.updateRegisterRow(register.obj);
            });
        },
        deleteRegisterById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                RegisterView.deleteRegisterRow(id);
            });
        },
        deleteRegisterRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                RegisterView.deleteRegisterRows(items);
            });
        }
    }
}();