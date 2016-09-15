var UserView = function() {
    var generateUserTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('user_table_tr_template', item);
    };
    var generateUserTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('user_modal_form_template', item);
    };
    var generateUserPagerHtml = function(item) {
        return TemplateUtil.renderHtml('user_table_pager_template', item);
    };
    return {
        renderUserTable: function(items) {
            TemplateUtil.registerPartical('tr', 'user_table_tr_template');
            var html = TemplateUtil.renderHtml('user_table_template', {
                data: items
            });
            $('#user_list').html(html);
        },
        renderUserTablePager: function(pager) {
        	var html = generateUserPagerHtml(pager);
            $('#user_list').find('tfoot').html(html);
        },
        insertUserRow: function(item) {
            var html = generateUserTableTrHtml(item);
            $('#user_table').find('tbody').prepend(html);
        },
        insertUserRows: function(items) {
        	 for(var i=0;i<items.length;i++){
             	var html = generateUserTableTrHtml(items[i]);
                $('#user_table').find('tbody').prepend(html);
             }
        },
        insertUserEditorRow: function(item) {
            var html = generateUserTrEditorHtml(item);
            $('#user_table').find('tbody').prepend(html);
            $('#user_table').find('.user_form_template .easyui-datebox').datebox({
                required:false
            });
        },
        deleteUserRow: function(userId) {
            $('#user_table').find('tbody').find('tr[data-id="' + userId + '"]').remove();
        },
        deleteUserRows: function(items) {
            for(var nav in items){
            	$('#user_table').find('tbody').find('tr[data-id="' + items[nav].userId + '"]').remove();
            }
        }
    };
}();