var RegisterView = function() {
    var generateRegisterTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('register_table_tr_template', item);
    };
    return {
        renderRegisterTable: function(items) {
            TemplateUtil.registerPartical('tr', 'register_table_tr_template');
            var html = TemplateUtil.renderHtml('register_table_template', {
                data: items
            });
            $('#register_list').html(html);
        },
        renderRegisterModal: function(title, item) {
            var $modal = $('#register_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('register_modal_form_template', item);
            $modal.find('.modal-body').html(html);
        },
        insertRegisterRow: function(item) {
            var html = generateRegisterTableTrHtml(item);
            $('#register_table').find('tbody').prepend(html);
        },
        updateRegisterRow: function(item) {
        	console.warn(item);
            var html = generateRegisterTableTrHtml(item);
            $('#register_table').find('tbody').find('tr[data-id="' + item.itemId + '"]').replaceWith(html);
        },
        deleteRegisterRow: function(itemId) {
            $('#register_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteRegisterRows: function(items) {
            for(var nav in items){
            	$('#register_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        }
    };
}();