var LookupService = function() {
    var BASE = '../services/lookup/lookupClassifyService';
    return {
    	findLookups: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupList', function(list) {
                LookupView.renderLookupTable(list);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupList/'+itemId, function(list) {
                LookupView.renderLookupTable(list);
                callback();
            });
        },
        findLookupById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findLookup/' + itemId, function(lookup) {
                var title = 'Edit Lookup';
                LookupView.renderLookupModal(title, lookup);
            });
        },/*
        findLookupsByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/lookups', {
                itemName: name
            }, function(lookupList) {
                LookupView.renderLookupTable(lookupList);
            });
        },*/
        createLookup: function(lookup) {
            AjaxUtil.sendPostData(BASE + '/insert', lookup, function(lookup) {
                LookupView.insertLookupRow(lookup.obj);
            });
        },
        batchInsertLookup: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                LookupView.insertLookupRows(items);
            });
        },
        updateLookup: function(lookup) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', lookup, function(lookup) {
                LookupView.updateLookupRow(lookup.obj);
            });
        },
        deleteLookupById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                LookupView.deleteLookupRow(id);
            });
        },
        deleteLookupRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                LookupView.deleteLookupRows(items);
            });
        }
    }
}();