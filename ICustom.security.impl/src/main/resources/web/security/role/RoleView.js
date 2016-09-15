var RoleView = function() {
    var generateRoleTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('role_table_tr_template', item);
    };
    var generateRoleTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('role_modal_form_template', item);
    };
    var generateRolePagerHtml = function(item) {
        return TemplateUtil.renderHtml('role_table_pager_template', item);
    };
    return {
        renderRoleTable: function(items) {
            TemplateUtil.registerPartical('tr', 'role_table_tr_template');
            var html = TemplateUtil.renderHtml('role_table_template', {
                data: items
            });
            $('#role_list').html(html);
        },
        renderRoleTablePager: function(pager) {
        	var html = generateRolePagerHtml(pager);
            $('#role_list').find('tfoot').html(html);
        },
        insertRoleRow: function(item) {
            var html = generateRoleTableTrHtml(item);
            $('#role_table').find('tbody').prepend(html);
        },
        insertRoleRows: function(items) {
        	 for(var i=0;i<items.length;i++){
             	var html = generateRoleTableTrHtml(items[i]);
                $('#role_table').find('tbody').prepend(html);
             }
        },
        insertRoleEditorRow: function(item) {
            var html = generateRoleTrEditorHtml(item);
            $('#role_table').find('tbody').prepend(html);
        },
        deleteRoleRow: function(classId) {
            $('#role_table').find('tbody').find('tr[data-id="' + classId + '"]').remove();
        },
        deleteRoleRows: function(items) {
            for(var nav in items){
            	$('#role_table').find('tbody').find('tr[data-id="' + items[nav].classId + '"]').remove();
            }
        }
    };
}();