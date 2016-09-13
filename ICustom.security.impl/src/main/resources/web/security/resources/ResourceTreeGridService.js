var ResourceService = function() {
    var BASE = '../../services/sys/resourcesService';
    return {
    	getItemId: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/selectByItemId', function(result) {
                callback(result);
            });
        },
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findResourceList/'+itemId, function(resourceList) {
                ResourceView.renderResourceTable(resourceList);
                callback();
            });
        },
        findResourceById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findResource/' + itemId, function(resource) {
                var title = 'Edit Resource';
                ResourceView.renderResourceModal(title, resource);
            });
        },
        createResource: function(resource,callback) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', [resource], function(resource) {
                //return resource;//ResourceView.insertResourceRow(resource.obj);
            	//callback(resource.obj);
            });
        },
        batchInsertResource: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                ResourceView.insertResourceRows(items);
            });
        },
        updateResource: function(resource) {
            AjaxUtil.sendPostData(BASE + '/batchUpdate', [resource], function(resource) {
            	return resource;//ResourceView.updateResourceRow(resource.obj);
            });
        },
        deleteResourceById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                //ResourceView.deleteResourceRow(id);
            });
        },
        deleteResourceRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                ResourceView.deleteResourceRows(items);
            });
        }
    }
}();