var ResourcesService = function() {
    var BASE = '../../services/sys/resourcesService';
    return {
    	getItemId: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/findResourcesPrimaryId', function(result) {
                callback(result);
            });
        },
        findResourcesById: function(resourceId) {
            AjaxUtil.sendGetRequest(BASE + '/findResources/' + resourceId, function(navigation) {
                var title = 'Edit Resources';
                ResourcesView.renderResourcesModal(title, navigation);
            });
        },
        createResources: function(navigation,callback) {
            AjaxUtil.sendPostData(BASE + '/insert', navigation, function(navigation) {
                //return navigation;//ResourcesView.insertResourcesRow(navigation.obj);
            	//callback(navigation.obj);
            });
        },
        batchInsertResources: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                ResourcesView.insertResourcesRows(items);
            });
        },
        updateResources: function(navigation) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', navigation, function(navigation) {
            	return navigation;//ResourcesView.updateResourcesRow(navigation.obj);
            });
        },
        deleteResourcesById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                //ResourcesView.deleteResourcesRow(id);
            });
        },
        deleteResourcesRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                ResourcesView.deleteResourcesRows(items);
            });
        }
    }
}();