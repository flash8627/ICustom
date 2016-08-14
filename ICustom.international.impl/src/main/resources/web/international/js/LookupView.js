var LookupView = function() {
    var generateLookupTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_table_tr_template', item);
    };
    return {
        renderLookupTable: function(items) {
            TemplateUtil.registerPartical('tr', 'lookup_table_tr_template');
            var html = TemplateUtil.renderHtml('lookup_table_template', {
                data: items
            });
            $('#lookup_list').html(html);
        },
        renderLookupModal: function(title, item) {
            var $modal = $('#lookup_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('lookup_modal_form_template', item);
            $modal.find('.modal-body').html(html);
        },
        insertLookupRow: function(item) {
            var html = generateLookupTableTrHtml(item);
            $('#lookup_table').find('tbody').prepend(html);
        },
        updateLookupRow: function(item) {
        	console.warn(item);
            var html = generateLookupTableTrHtml(item);
            $('#lookup_table').find('tbody').find('tr[data-id="' + item.itemId + '"]').replaceWith(html);
        },
        deleteLookupRow: function(itemId) {
            $('#lookup_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteLookupRows: function(items) {
            for(var nav in items){
            	$('#lookup_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        }
    };
}();