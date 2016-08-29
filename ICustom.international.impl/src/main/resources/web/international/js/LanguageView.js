var NavigationView = function() {
    var generateNavigationTableTrHtml = function(navigation) {
        return TemplateUtil.renderHtml('navigation_table_tr_template', navigation);
    };
    return {
        renderNavigationTable: function(navigationList) {
            TemplateUtil.registerPartical('tr', 'navigation_table_tr_template');
            var html = TemplateUtil.renderHtml('navigation_table_template', {
                data: navigationList
            });
            $('#navigation_list').html(html);
        },
        renderNavigationModal: function(title, navigation) {
            var $modal = $('#navigation_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('navigation_modal_form_template', navigation);
            $modal.find('.modal-body').html(html);
        },
        insertNavigationRow: function(navigation) {
            var html = generateNavigationTableTrHtml(navigation);
            $('#navigation_table').find('tbody').prepend(html);
        },
        updateNavigationRow: function(navigation) {
        	console.warn(navigation);
            var html = generateNavigationTableTrHtml(navigation);
            $('#navigation_table').find('tbody').find('tr[data-id="' + navigation.itemId + '"]').replaceWith(html);
        },
        deleteNavigationRow: function(itemId) {
            $('#navigation_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteNavigationRows: function(items) {
            for(var nav in items){
            	$('#navigation_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        }
    };
}();