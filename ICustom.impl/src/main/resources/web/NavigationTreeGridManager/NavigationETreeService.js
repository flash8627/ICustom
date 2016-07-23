var NavigationService = function() {
    var BASE = '../services/sysRestMGR';
    return {
        findChildren: function(callback,itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findNavigationList/'+itemId, function(navigationList) {
                NavigationView.renderNavigationTable(navigationList);
                callback();
            });
        },
        findNavigationById: function(itemId) {
            AjaxUtil.sendGetRequest(BASE + '/findNavigation/' + itemId, function(navigation) {
                var title = 'Edit Navigation';
                NavigationView.renderNavigationModal(title, navigation);
            });
        },
        createNavigation: function(navigation) {
            AjaxUtil.sendPostData(BASE + '/insert', navigation, function(navigation) {
                return navigation;//NavigationView.insertNavigationRow(navigation.obj);
            });
        },
        batchInsertNavigation: function(items) {
            AjaxUtil.sendPostData(BASE + '/batchInsert', items, function(items) {
                NavigationView.insertNavigationRows(items);
            });
        },
        updateNavigation: function(navigation) {
            AjaxUtil.sendPostData(BASE + '/updateByKey', navigation, function(navigation) {
            	return navigation;//NavigationView.updateNavigationRow(navigation.obj);
            });
        },
        deleteNavigationById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/deleteBy/' + id, function() {
                //NavigationView.deleteNavigationRow(id);
            });
        },
        deleteNavigationRows: function(items) {
            AjaxUtil.sendBatchRemove(BASE + '/batchRemove',items, function() {
                NavigationView.deleteNavigationRows(items);
            });
        }
    }
}();