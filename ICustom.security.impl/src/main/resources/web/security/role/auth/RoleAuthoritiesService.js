var RolesAuthoritiesService = function() {
    var BASE = '../../services/sys/roleAuthoritiesService';
    return {
    	findRoleAuthorities: function(role) {//角色的权限
    		var result=[];
    		AjaxUtil.sendGetAsyncRequest(BASE + '/findRoleAuthorities/'+role.roleId, function(resp) {
            	result=resp;
            });
    		return result;
        },
    	findAuthoritiesList: function() {//所有权限
    		var result=[];
    		var url = '../../../../services/sys/authoritiesService/findAuthoritiesList/1200/1';
    		AjaxUtil.sendGetAsyncRequest(BASE + url, function(resp) {
            	result=resp;
            });
    		return result;
        },
        batchSaveRoleAuthorieies: function(items) {
        	var result={};
            AjaxUtil.sendPostAsyncData(BASE + '/batchInsert', items, function(roleAuths) {
            	result=roleAuths;
            });
            return result;
        },
        batchRemoveRoleAuthorities: function(items) {
            AjaxUtil.sendPutData(BASE + '/batchRemovePks',items, function() {});
        }
    }
}();