var LookupItemView = function() {
	var generateLookupTableTrHtml = function(item) {
        return TemplateUtil.renderHtml('lookup_item_info_template', item);
    };
	var index = 0;
    return {
    	addTabClassifyInfo:function(info){
    		var html = generateLookupTableTrHtml(info);
            //$('#dg2').before(html);
    		return html;
    	},
    	addTabPanel:function(title,lookup){
    		var tabId = 'Tab_' + title;
    		console.info($('#' + tabId));
    		if ($('#' + tabId).length < 1) {
    			var content = LookupItemView.addTabClassifyInfo(lookup);
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
    		} else {
    			$('#Lookup_tt').tabs('select', title);
    		}
    	}
    };
}();