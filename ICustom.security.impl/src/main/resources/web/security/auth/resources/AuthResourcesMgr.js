var BASE = '../../../services/sys/';

$(function() {
	initAuthoritiesTree();
	initResourcesTree();
	console.info('添加一级节点有问题!');
})

var authId = 0;
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
		onClick : function(node) {
			console.info('onClick',node);
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authResourcesTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */
		},
		onSelect:function(node){
			console.info('select',node);
			//选择行查询权限的资源,并赋值给资源的视图
			$('#authBYName').text(node.text);
			if(authId!=node.id){
				authId=node.id;
				if(!validateAuthData(authId)){
					doSearchAuthResource(node);
				}
			}
		},
		onBeforeExpand : function(node) {
			if (node) {
				$('#authTree').tree('options').url = baseUrl + "/" + node.id;
			}
		}
	}

	var authTreeView = $('#authTree').tree(authTreeConfig);
}

/**权限的资源,权限标识为数组标识*/
var authResources = [];
/**
 * 验证权限的资源是否已经有数据,有则不再查询
 */
validateAuthData = function(nodeId){
	
	return false;
}

/**
 * 查询权限的资源,AuthoritiesResources
 * @param node
 */
doSearchAuthResource = function(node){
	var url = BASE+'authorityResourcesService/findAuthoritiesResources/'+node.id;
	AjaxUtil.sendGetAsyncRequest(url,function(data){
		console.info(data);
		validateAuthData.push(data);
	});
}

var initResourcesTree = function(resId) {
	var baseUrl = BASE + 'resourcesService/findResourcesTree';
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
		formatter : function(node) {
			if (node.leaf) {
				// 叶子节点否?
				node.iconCls = 'icon-reload';
				node.state = 'closed';
				$("#authResourcesTree").tree("expandAll", node.target);
			}
			var s = getNodeName(node.text,node);
			if (node.children) {
				s += ' <span style="color:CCCCCC">(' + node.children.length
						+ ')</span>';
			}
			return s;
		},
		onClick : function(node) {
			console.info('onClick',node);
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authResourcesTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */
		},
		onSelect:function(row){
			console.info('select',row);
			//选择行后可以执行添加删除修改
		},
		onLoadSuccess : function(node) {
			$(".tree-title").mouseover(function(event) {
				/**
				 * console.info('mouseover',event);
				 * console.info('mouseover',event.target);
				 * console.info('mouseover',event.delegateTarget);
				 */
			});
		},
		/*
		 * onBeforeLoad: function(node, param){ },
		 */
		onBeforeExpand : function(node) {
			if (node) {
				$('#authResourcesTree').tree('options').url = baseUrl + "/" + node.id;
			}
		}
	}

	$('#authResourcesTree').tree(authResourcesTreeConfig);
}

function doNode(){
    var c="";
    var p="";
    $(".tree-checkbox1").parent().children('.tree-title').each(function(){
      c+=$(this).parent().attr('node-id')+",";
    });
     $(".tree-checkbox2").parent().children('.tree-title').each(function(){
   p+=$(this).parent().attr('node-id')+",";
    });
    var str=(c+p);
    str=str.substring(0,str.length-1);
    alert(str);
}

function getChecked(){
    var nodes = $('#tt2').tree('getChecked');
    var s = '';
    for (var i = 0; i < nodes.length; i++) {
        if (s != '') 
            s += ',';
        s += nodes[i].text;
    }
    alert(s);
}

function getNodeName(value,rowData){
	var names = value.split(",");
	var lan = names[0];
	var lans = lan.split('=');
	if(lans[1]!=undefined){
		return lans[1];
	}
	return lans;
}

// 过滤
function doSearch(value) {
	alert('You input: ' + value);
}

resourceNameFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	//
	if(rowData.leaf == true&&rowData.parentId!=null){
		rowData.iconCls = 'icon-reload';
		rowData.state = 'closed';
	}
	/*if(rowData.leaf == true&&rowData.parentId==null){
		rowData.iconCls = 'fa-folder-o';
		rowData.state = 'closed';
	}*/
	var names = value.split(",");
	var lan = names[0];
	var lans = lan.split('=');
	if(lans[1]!=undefined){
		return lans[1];
	}
	return lans;
}

// 点击 Create 按钮，弹出创建产品对话框
$('#parent_select_btn').on('click', function() {
	var title = '上一级节点选择';
	// NavigationView.renderNavigationModal(title, navigation);
	var $modal = $('#parent_select_modal');
	$modal.find('.modal-title').text(title);
	$('#parent_select_modal').modal('show');
});

// 保存，含新增和修改
function doSave() {
	var values = getFormValues();
	console.info(values);
	var selected = $('#authTree').tree('getSelected');
	if (values.authId != 0) {
		AuthoritiesService.batchUpdateAuthorities([ values ], function() {
			// 更新
			if (selected) {
				$('#authTree').tree('update', {
					target : selected.target,
					parentId : values.parentId,
					authDesc : values.authDesc,
					authId : values.authId,
					authName : values.authName,
					authCode : values.authCode,
					text : values.authName
				// ,
				// 不用更新id:values.authId
				});
			}
		});
		// 提交[values]
	} else {
		var result = AuthoritiesService.batchInsertAuthorities([ values ]);
		for (var i = 0; i < result.obj.length; i++) {
			result.obj[i].id = result.obj[i].authId;
			result.obj[i].text = result.obj[i].authName;
		}
		if (selected == null) {
			selected = {};
		}
		$('#authTree').tree('append', {
			parent : selected.target,
			data : result.obj
		});
	}
}