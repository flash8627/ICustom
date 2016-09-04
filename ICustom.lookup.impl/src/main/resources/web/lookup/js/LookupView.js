var LookupView = function() {
    var generateLookupTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_table_tr_template', item);
    };
    var generateLookupTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_modal_form_template', item);
    };
    var generateLookupPagerHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_table_pager_template', item);
    };
    return {
        renderLookupTable: function(items) {
            TemplateUtil.registerPartical('tr', 'lookup_table_tr_template');
            var html = TemplateUtil.renderHtml('lookup_table_template', {
                data: items
            });
            $('#lookup_list').html(html);
        },
        renderLookupTablePager: function(pager) {
        	var html = generateLookupPagerHtml(pager);
            $('#lookup_list').find('tfoot').html(html);
        },
        insertLookupRow: function(item) {
            var html = generateLookupTableTrHtml(item);
            $('#lookup_table').find('tbody').prepend(html);
        },
        insertLookupRows: function(items) {
        	 for(var i=0;i<items.length;i++){
             	var html = generateLookupTableTrHtml(items[i]);
                $('#lookup_table').find('tbody').prepend(html);
             }
        },
        insertLookupEditorRow: function(item) {
            var html = generateLookupTrEditorHtml(item);
            $('#lookup_table').find('tbody').prepend(html);
        },
        deleteLookupRow: function(classId) {
            $('#lookup_table').find('tbody').find('tr[data-id="' + classId + '"]').remove();
        },
        deleteLookupRows: function(items) {
            for(var nav in items){
            	$('#lookup_table').find('tbody').find('tr[data-id="' + items[nav].classId + '"]').remove();
            }
        }
    };
}();