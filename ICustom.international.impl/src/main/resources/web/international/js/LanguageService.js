var LanguageService = function() {
    var BASE = '../services/international/internationalService';
    return {
    	findLanguages: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLanguageList', function(list) {
                LanguageView.renderLanguageTable(list);
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
            AjaxUtil.sendGetRequest(BASE + '/findLanguage/' + itemId, function(language) {
                var title = 'Edit Language';
                LanguageView.renderLanguageModal(title, language);
            });
        },/*
        findLanguagesByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/languages', {
                itemName: name
            }, function(languageList) {
                LanguageView.renderLanguageTable(languageList);
            });
        },*/
        createLanguage: function(language) {
            AjaxUtil.sendPostData(BASE + '/insert', language, function(language) {
                LanguageView.insertLanguageRow(language.obj);
            });
        },
        batchInsertLanguage: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                LanguageView.insertLanguageRows(items);
            });
        },
        updateLanguage: function(language) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', language, function(language) {
                LanguageView.updateLanguageRow(language.obj);
            });
        },
        deleteLanguageById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                LanguageView.deleteLanguageRow(id);
            });
        },
        deleteLanguageRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                LanguageView.deleteLanguageRows(items);
            });
        }
    }
}();