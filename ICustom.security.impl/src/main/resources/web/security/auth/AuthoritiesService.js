var AuthoritiesService = function() {
    var BASE = '../../services/sys/authoritiesService';
    return {
    	findAuthoritiess: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findAuthoritiesList', function(list) {
                AuthoritiesView.renderAuthoritiesTable(list);
                callback();
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findAuthoritiesList/'+itemId, function(list) {
                AuthoritiesView.renderAuthoritiesTable(list);
                callback();
            });
        },
        findAuthoritiesById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findAuthorities/' + itemId, function(authorities) {
                var title = 'Edit Authorities';
                AuthoritiesView.renderAuthoritiesModal(title, authorities);
            });
        },
        batchInsertAuthorities: function(items) {
        	var result = {};
            AjaxUtil.sendPostAsyncData(BASE + '/batchInsert', items, function(resp) {
            	result = resp;
            	return result;
            });
            return result;
        },
        batchUpdateAuthorities: function(authorities,callback) {
            AjaxUtil.sendPutData(BASE + '/batchUpdate', authorities, function(authorities) {
            	callback(authorities);
            });
        },
        batchRemoveAuthorities: function(items,callback) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks', items, function() {
            	callback();
            });
        }
    }
}();