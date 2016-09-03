var LanguageService = function() {
    var BASE = '../services/international/internationalService';
    return {
    	findLanguages: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLanguageList/10/1', function(object) {
                LanguageView.renderLanguageTable(object.result);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findLanguageList/'+itemId, function(list) {
                LanguageView.renderLanguageTable(list);
                callback();
            });
        },
        findLanguageById: function(itemId) {
        	//查询后直接填充到页面
            AjaxUtil.sendGetRequest(BASE + '/findItem/' + itemId, function(language) {
                var title = 'Edit Language';
                LanguageView.renderLanguageModal(title, language);
            });
        },
        findLanguageByItem: function(itemId) {
        	var result = {};
        	//返回查询值,需要发同步请求吗？
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(language) {
            	result = language;
            	return result;
            });
            return result;
        },/*
        findLanguagesByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/languages', {
                itemName: name
            }, function(languageList) {
                LanguageView.renderLanguageTable(languageList);
            });
        },*/
        createLanguage: function(language) {
        	var lans = [language];
            batchInsertLanguage(lans);
        },
        batchInsertLanguage: function(items,callback) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                LanguageView.insertLanguageRows(items.obj,callback);
            });
        },
        batchUpdateLanguage: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(language) {
                LanguageView.updateLanguageRow(language.obj);
            });
        },
        deleteLanguageById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                LanguageView.deleteLanguageRow(id);
            });
        },
        deleteLanguageRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                LanguageView.deleteLanguageRows(items);
            });
        }
    }
}();