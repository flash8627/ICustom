/**
 * 头部功能
 */
$(function() {
	var url = "/services/sys/resourcesService/findResourcesSiteMenu";
	AjaxUtil.sendGetRequest(url, menuCallback);	
})

resourceNameFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	if(rowData.leaf == true&&rowData.parentId!=null){
		rowData.iconCls = 'icon-reload';
	}
	var names = value.split(",");
	var lan = names[0];
	var lans = lan.split('=');
	if(lans[1]!=undefined){
		return lans[1];
	}
	return lans;
}

var anode = function(item){
	var name = resourceNameFormatter(item.resourceName,item);
	var url = "#";
	if(item.resUrl!=null){
		url = "/"+item.resUrl;
	}
	var node = '';
	node += '<a href="';
	node += url;
	node += '">'+name+'</a>';
	return node;
}

var newRed = '<span class="label label-danger text-center hidden-xs">New <i class="fa fa-caret-right"></i></span>';
var newGre = '<span class="label label-info text-center hidden-xs">New <i class="fa fa-caret-right"></i></span>';

var homeHtml = '<li>'+
'<a  href="#">Home</a>'+
'</li>'; 

var menuCallback = function(response){
	var menuHtml = '';
	menuHtml += homeHtml;
	if(response==null){
		return;
	}else{
		for(var i=0;i<response.length;i++){
			menuHtml += '<li>';
			var rows = response[i];
			menuHtml += anode(rows);
			if('SHOP'==rows.resourceName){
				menuHtml += newRed;
			}
			if('BLOG'==rows.resourceName){
				menuHtml += newGre;
			}
			if(rows.children&&rows.children.length>0){
				menuHtml += '<ul>';
				var rc = rows.children;
				for(var x=0;x<rc.length;x++){
					var rowss = rc[x];
					menuHtml += '<li>';
					menuHtml += anode(rowss);
					var rcc = rowss.children;
					if(rcc!=null){
						menuHtml += '<ul>';
						for(var xx=0;xx<rcc.length;xx++){
							var rccNode = rcc[xx];
							menuHtml += '<li>';
							menuHtml += anode(rccNode);
							menuHtml += '</li>';
						}
						menuHtml += '</ul>';
					}
					menuHtml += '</li>';
				}
				menuHtml += '</ul>';
			}
			menuHtml += '</li>';
		}
	}
	$('#nav').html(menuHtml);
}

