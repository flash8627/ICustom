var BASE = '../../../services/sys/';

$(function() {
	initAuthoritiesTree();
	initResourcesTree();
	console.info('添加一级节点有问题!');
})

var authId = 0;
var curAuthId = 0;
var initAuthoritiesTree = function(authId) {
	var baseUrl = BASE + 'authoritiesService/findAuthoritiesTree';
	var url = baseUrl;
	if (authId != undefined) {
		url = url + '/' + authId;
	} else {
		url = url + '/0';
	}

	var authTreeConfig = {
		url : url,
		method : 'get',
		fit : true,
		lines : true,
		checkbox : false,
		onLoadSuccess : function(node, data) {
			var t = $(this);
			if (data) {
				$(data).each(function(index, d) {
					if (this.state == 'closed') {
						t.tree('expandAll');
					}
				});
			}
		},
		onClick : function(node) {
			// console.info('onClick', node);
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authResourcesTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */
		},
		onSelect : function(node) {
			console.info('select', node);
			// 选择行查询权限的资源,并赋值给资源的视图
			$('#authBYName').text(node.text);
			if (authId != node.id) {
				authId = node.id;
				curAuthId = node.id;
			}
			doSearchAuthResource(node);
		},
		onBeforeExpand : function(node) {
			if (node) {
				$('#authTree').tree('options').url = baseUrl + "/" + node.id;
			}
		}
	}

	var authTreeView = $('#authTree').tree(authTreeConfig);
}

/** 权限的资源,权限标识为数组标识 */
var authResources = [];
/**
 * 验证权限的资源是否已经有数据,有则不再查询
 */
validateAuthData = function(nodeId) {

	return false;
}

/** 根据权限拥有的资源选择资源 */
doSelectResource = function(data) {
	var child = $("#authResourcesTree").tree("getChildren");
	for (var i = 0; i < child.length; i++) {
		//console.info(child[i].id, child[i].text);
		var node = $("#authResourcesTree").tree('find',child[i].id);
		$('#authResourcesTree').tree('update', node);
		for(var j=0;j<data.length;j++){
			if(data[j].resourceId==child[i].id){
                if(node){
                    $("#authResourcesTree").tree('check',node.target);
                }
				console.info(data[j].resourceId+" = "+child[i].id+" -> "+child[i].text);
			}
		}
	}
}

/**
 * 查询权限的资源,AuthoritiesResources
 * 
 * @param node
 */
doSearchAuthResource = function(node) {
	var url = BASE + 'authorityResourcesService/findAuthoritiesResources/'
			+ node.id;
	AjaxUtil.sendGetAsyncRequest(url, function(data) {
		console.info(data);
		//authResources.push(data);
		doSelectResource(data);
	});
}

var initResourcesTree = function(resId) {
	var baseUrl = BASE
			+ 'authoritiesResourcesTreeService/findAuthResourcesTree';
	var url = baseUrl;
	if (resId != undefined) {
		url = url + '/' + resId;
	}

	var authResourcesTreeConfig = {
		url : url,
		method : 'get',
		fit : true,
		lines : true,
		checkbox : true,
		onLoadSuccess : function(node, data) {
			var t = $(this);
			if (data) {
				$(data).each(function(index, d) {
					if (this.state == 'closed') {
						t.tree('expandAll');
					}
				});
			}
		},
		/*
		 * formatter : function(node) { if (node.leaf) { // 叶子节点否? //
		 * node.iconCls = 'icon-reload'; node.state = 'closed';
		 * $("#authResourcesTree").tree("expandAll", node.target); } var s =
		 * getNodeName(node.text, node); if (node.children) { s += ' <span
		 * style="color:CCCCCC">(' + node.children.length + ')</span>'; }
		 * return s; },
		 */
		onClick : function(node) {
			console.info('onClick', node);
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authResourcesTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */
		},
		onSelect : function(row) {
			// console.info('select', row);
			// 选择行后可以执行添加删除修改
		},
		onBeforeLoad : function() {
			var rooNode = $("#authResourcesTree").tree('getRoot');
			$("#authResourcesTree").tree('expand', rooNode);
		},
		onBeforeExpand : function(node) {
			if (node) {
				$('#authResourcesTree').tree('options').url = baseUrl + "/"
						+ node.id;
			}
		}
	}

	$('#authResourcesTree').tree(authResourcesTreeConfig);
}

function getNodeName(value, rowData) {
	var names = value.split(",");
	var lan = names[0];
	var lans = lan.split('=');
	if (lans[1] != undefined) {
		return lans[1];
	}
	return lans;
}

resourceNameFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	//
	if (rowData.leaf == true && rowData.parentId != null) {
		//rowData.iconCls = 'icon-reload';
		rowData.state = 'closed';
	}
	/*
	 * if(rowData.leaf == true&&rowData.parentId==null){ rowData.iconCls =
	 * 'fa-folder-o'; rowData.state = 'closed'; }
	 */
	var names = value.split(",");
	var lan = names[0];
	var lans = lan.split('=');
	if (lans[1] != undefined) {
		return lans[1];
	}
	return lans;
}

// $('#' + ids[j]).prop("checked", true);

// 保存，含新增和修改
function doSave() {
	
	if(curAuthId==0){
		alert('请选择权限信息!!!');
		return ;
	}
	
	var nodes = $('#authResourcesTree').tree('getChecked');
	var chks = [];
	for (var i = 0; i < nodes.length; i++) {
		var item = {};
		item.resourceId = nodes[i].id;
		//item.text = nodes[i].text;
		item.authId = curAuthId;
		chks.push(item);

	}
	if(chks.length<1){
		alert('请选择资源条目!!!');
		return;
	}
	console.info('save authorities ' + curAuthId + ' Resources params', chks);

	var url = BASE + 'authorityResourcesService/batchInsert';
	AjaxUtil.sendPostData(url,chks, function(data) {
		console.info(data);
	});

}