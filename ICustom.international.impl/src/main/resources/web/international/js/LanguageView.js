var LanguageView = function() {
    var generateLanguageTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('language_table_tr_template', item);
    };
    var insertLanguageTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('language_modal_form_template', item);
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
        insertLanguageRows: function(items,callback) {
            for(var i=0;i<items.length;i++){
            	var html = generateLanguageTableTrHtml(items[i]);
                $('#language_table').find('tbody').prepend(html);
            }
            //callback();//执行方法
        },
        insertLanguageRow: function(item) {
            var html = insertLanguageTableTrHtml(item);
            $('#language_table').find('tbody').prepend(html);
        },
        updateLanguageRow: function(items) {
        	console.warn(items);
            for(var i=0;i<items.length;i++){
            	var item = items[i];
            	var html = generateLanguageTableTrHtml(item);
            	$('#language_table').find('tbody').prepend(html);//不再使用更新，因为页面　已经删除此行
                //$('#language_table').find('tbody').find('tr[data-id="' + item.itemId + '"]').replaceWith(html);
            }
        },
        deleteLanguageRow: function(itemId) {
            $('#language_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteLanguageRows: function(items) {
            for(var nav in items){
            	$('#language_table').find('tbody').find('tr[data-id="' + items[nav].lanId + '"]').remove();
            }
        }
    };
}();