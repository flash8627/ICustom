var LanguageView = function() {
    var generateLanguageTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('language_table_tr_template', item);
    };
    return {
        renderLanguageTable: function(items) {
            TemplateUtil.registerPartical('tr', 'language_table_tr_template');
            var html = TemplateUtil.renderHtml('language_table_template', {
                data: items
            });
            $('#language_list').html(html);
        },
        renderLanguageModal: function(title, item) {
            var $modal = $('#language_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('language_modal_form_template', item);
            $modal.find('.modal-body').html(html);
        },
        insertLanguageRow: function(item) {
            var html = generateLanguageTableTrHtml(item);
            $('#language_table').find('tbody').prepend(html);
        },
        updateLanguageRow: function(item) {
        	console.warn(item);
            var html = generateLanguageTableTrHtml(item);
            $('#language_table').find('tbody').find('tr[data-id="' + item.itemId + '"]').replaceWith(html);
        },
        deleteLanguageRow: function(itemId) {
            $('#language_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteLanguageRows: function(items) {
            for(var nav in items){
            	$('#language_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        }
    };
}();