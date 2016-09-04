var LookupItemView = function() {
    var generateLookupItemTrEditorHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_form_template', item);
    };
	var generateLookupItemTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_info_template', item);
    };
    var generateLookupItemTableHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_table_template', item);
    };
	var index = 0;
    return {
    	addTabClassifyInfo:function(info){
    		var html = generateLookupItemTableHtml(info);
            //$('#dg2').before(html);
    		return html;
    	},
    	insertLanguageItemRow: function(code,item) {
    		//lookup_item_{{code}}_table
    		var table = 'lookup_item_'+code+'_table';
            var html = generateLookupItemTrEditorHtml(item);
            $('#'+table).find('tbody').prepend(html);
        },
    	addTabPanel:function(title,lookup){
    		var tabId = 'Tab_' + title;
    		console.info($('#' + tabId));
    		if ($('#Lookup_tt').tabs('exists', title)){
    			$('#Lookup_tt').tabs('select', title);
    		} else {
    			var content = LookupItemView.addTabClassifyInfo(lookup);
    			var gridNode = 'Lookup_Item_'+title+'_grid'
    			var flag = $(content).find('#'+gridNode);
    			var cls = $(content).find('.'+title);
    			/*console.info(content);
    			console.info('cls',cls);
    			console.info('flag',flag);*/
    			$('#Lookup_tt').tabs(
    					'add',
    					{
    						title : title,
    						id : tabId,
    						tabWidth : title.length * 10 + 30,
    						fit : true,
    						content : content,
    						closable : true
    					});
    		}
    	}
    };
}();