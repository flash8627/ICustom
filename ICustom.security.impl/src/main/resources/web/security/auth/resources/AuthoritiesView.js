var AuthoritiesView = function() {
    var generateAuthoritiesTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('authorities_table_tr_template', item);
    };
    return {
        renderAuthoritiesTable: function(items) {
            TemplateUtil.authoritiesPartical('tr', 'authorities_table_tr_template');
            var html = TemplateUtil.renderHtml('authorities_table_template', {
                data: items
            });
            $('#authorities_list').html(html);
        },
        renderAuthoritiesModal: function(title, item) {
            var $modal = $('#authorities_modal');
            $modal.find('.modal-title').text(title);
            var html = TemplateUtil.renderHtml('authorities_modal_form_template', item);
            $modal.find('.modal-body').html(html);
        },
        insertAuthoritiesRow: function(item) {
            var html = generateAuthoritiesTableTrHtml(item);
            $('#authorities_table').find('tbody').prepend(html);
        },
        updateAuthoritiesRow: function(item) {
        	console.warn(item);
            var html = generateAuthoritiesTableTrHtml(item);
            $('#authorities_table').find('tbody').find('tr[data-id="' + item.itemId + '"]').replaceWith(html);
        },
        deleteAuthoritiesRow: function(itemId) {
            $('#authorities_table').find('tbody').find('tr[data-id="' + itemId + '"]').remove();
        },
        deleteAuthoritiesRows: function(items) {
            for(var nav in items){
            	$('#authorities_table').find('tbody').find('tr[data-id="' + nav.itemId + '"]').remove();
            }
        },
        remove:function(){
			var nodes = $('#regTree').tree('getChecked');
			var ids = '';
			for (var i = 0; i < nodes.length; i++) {
				if (ids != '')
					ids += ',';
				ids += nodes[i].id;
			}
        },
        update:function(){
        	var node = $('#regTree').tree('getSelected');
            if (node){
                node.text = '修改';  //-->txt-->DB
                node.iconCls = 'icon-save'; //-->sel-->DB
                $('#regTree').tree('update', node);
            }
        },
		append : function() {
			var node = $('#regTree').tree('getSelected');
			$('#regTree').tree('append', {
				parent : (node ? node.target : null),
				data : [{
					text : 'new1',//  -->txt-->DB
					id : '10001',
					checked : false
				} ]
			});
		}
    };
}();