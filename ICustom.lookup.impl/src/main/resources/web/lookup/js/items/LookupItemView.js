var LookupItemView = function() {
	/**表格编辑行*/
	var generateLookupItemTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_form_template', item);
    };
    /**表格行*/
	var generateLookupItemTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_info_template', item);
    };
    /**主表*/
    var generateLookupItemTableHtml = function(lookup) {
        return TemplateUtil.renderHtml('lookup_item_table_template', lookup);
    };
	var index = 0;
    return {
    	addTabClassifyInfo:function(lookup){
    		var html = generateLookupItemTableHtml(lookup);return html;
    	},
    	initInsertLookupItemRow: function(code,items) {
    		//lookup_item_{{code}}_table
    		var table = 'lookup_item_'+code+'_table';
    		var tbody = $('#'+table).find('tbody');
    		if(items.length>0){
    			$('.alert-warning').detach();
    		}
            for(var i=0;i<items.length;i++){
            	var html = generateLookupItemTableTrHtml(items[i]);
                $(tbody).prepend(html);
            }
        },
        deleteLookupItemRow:function(classCode,items) {
        	var table = 'lookup_item_'+classCode+'_table';
            for(var nav in items){
            	$('#'+table).find('tbody').find('tr[data-id="' + items[nav].itemId + '"]').remove();
            }
        },
    	insertLookupItemEditorRow: function(code,item) {
    		//lookup_item_{{code}}_table
    		var table = 'lookup_item_'+code+'_table';
            var html = generateLookupItemTrEditorHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	insertLookupItemRow: function(code,item) {
    		//lookup_item_{{code}}_table
    		var table = 'lookup_item_'+code+'_table';
            var html = generateLookupItemTableTrHtml(item);
            var tbody = $('#'+table).find('tbody');
            $(tbody).prepend(html);
        },
    	addTabPanel:function(lookup,lookupItem){
    		var tabId = 'Tab_' + lookup.classCode;
    		if ($('#Lookup_tt').tabs('exists', lookup.className)){
    			$('#Lookup_tt').tabs('select', lookup.className);
    		} else {
    			var tableId = 'lookup_item_'+lookup.classCode+'_table';
    			var title = lookup.className;
    			var content = LookupItemView.addTabClassifyInfo(lookup);
    			var gridNode = $(content).find('#'+tableId).find('tbody');
    			var cls = $(content).find('.'+lookup.classCode);
    			$('#Lookup_tt').tabs('add',{
					title : title,
					id : tabId,
					tabWidth : title * 10 + 30,
					fit : true,
					content : content,
					closable : true
    			});
    			LookupItemView.initInsertLookupItemRow(lookup.classCode,lookupItem);
    		}
    	}
    };
}();