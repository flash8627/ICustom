var LookupService = function() {
    var BASE = '../services/lookup/lookupClassifyService';
    return {
    	findLookups: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findLookupList/10/1', function(list) {
                LookupView.renderLookupTable(list.result);
                LookupView.renderLookupTablePager(list.result);
                callback();
            });
        },
        findLookupById: function(itemId) {
        	var result = {};
            AjaxUtil.sendGetAsyncRequest(BASE + '/findItem/' + itemId, function(lookup) {
            	result = lookup;
            	return result;
            });
            return result;
        },
        batchInsertLookup: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(result) {
                LookupView.insertLookupRows(result.obj);
            });
        },
        batchUpdateLookup: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', items, function(result) {
                LookupView.insertLookupRows(result.obj);
            });
        },
        deleteLookupRows: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {
                LookupView.deleteLookupRows(items);
            });
        }
    }
}();