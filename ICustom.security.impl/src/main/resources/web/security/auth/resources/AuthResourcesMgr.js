var BASE = '../../../services/sys/';


$(function() {
	initAuthoritiesTree();
	initResourcesTree();
	console.info('添加一级节点有问题!');
})

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
		onBeforeLoad : function() {
			/*
			 * //获取根节点 var rooNode = $("#authTree").tree("getRoot");
			 * //调用expand方法 $("#authTree").tree("expand",rooNode);
			 */
		},
		formatter : function(node) {
			if (node.leaf) {
				// 叶子节点否?
				node.iconCls = 'icon-reload';
				node.state = 'closed';
				$("#authTree").tree("expandAll", node.target);
			}
			var s = node.text;
			if (node.children) {
				s += ' <span style="color:CCCCCC">(' + node.children.length
						+ ')</span>';
			}
			// s += '<span style="color:#FFFFFF;">&nbsp;<i class="fa
			// fa-plus"></i></span>';
			s += '<span class="removeNode" style="color:#FFFFFF;" onclick="doRemove()">&nbsp;<i class="fa fa-remove"></i></span>';
			return s;
		},
		onClick : function(node) {
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */

			resetForm();
			setFormValues(node);
		},
		onLoadSuccess : function(node) {
			$(".tree-title").mouseover(function(event) {
				/*
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
				$('#authTree').tree('options').url = baseUrl + "/" + node.id;
			}
		}
	}

	var authTreeView = $('#authTree').tree(authTreeConfig);
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
		onBeforeLoad : function() {
		},
		formatter : function(node) {
			if (node.leaf) {
				// 叶子节点否?
				node.iconCls = 'icon-reload';
				node.state = 'closed';
				$("#authResourcesTree").tree("expandAll", node.target);
			}
			var s = node.text;
			if (node.children) {
				s += ' <span style="color:CCCCCC">(' + node.children.length
						+ ')</span>';
			}
			// s += '<span style="color:#FFFFFF;">&nbsp;<i class="fa
			// fa-plus"></i></span>';
			s += '<span class="removeNode" style="color:#FFFFFF;" onclick="doRemove()">&nbsp;<i class="fa fa-remove"></i></span>';
			return s;
		},
		onClick : function(node) {
			node.authName = node.text;
			node.authId = node.id;
			// node.parentId = pnode.id;
			var pnode = $('#authResourcesTree').tree('getParent', node.target);
			/*
			 * if(pnode!=null){ node.parentId = node.id; }
			 */

			resetForm();
			setFormValues(node);
		},
		onLoadSuccess : function(node) {
			$(".tree-title").mouseover(function(event) {
				/*
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

// 过滤
function doSearch(value) {
	alert('You input: ' + value);
}

// 点击 Create 按钮，弹出创建产品对话框
$('#parent_select_btn').on('click', function() {
	var title = '上一级节点选择';
	// NavigationView.renderNavigationModal(title, navigation);
	var $modal = $('#parent_select_modal');
	$modal.find('.modal-title').text(title);
	$('#parent_select_modal').modal('show');
});

// 添加条目，如果parentId为空则是一级
function addItem() {
	resetForm();
	var node = $('#authTree').tree('getSelected');
	console.warn('add node parent', node);
	if (node != null) {
		node.parentId = node.id;
	} else {
		node = {};
		node.parentId = 0;
	}

	node.authId = 0;
	node.authName = '';
	node.authCode = '';
	node.authDesc = '';
	setFormValues(node);
}

// .tree-title .fa-remove
// 点击 Delete 按钮，删除产品
doRemove = function() {
	var node = $("#authTree").tree("getSelected");
	if (node) {
		var params = [ {
			authId : node.id
		} ];

		if (confirm('Do you want to delete this Authorities?')) {
			AuthoritiesService.batchRemoveAuthorities(params, function() {
				$('#authTree').tree('remove', node.target);
			});

		}
	}
	return false;
}

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
	resetForm();
}

// 重置表单
function resetForm() {
	var values = {
		authId : 0,
		authName : '',
		authCode : '',
		parentId : 0,
		authDesc : ''
	};
	setFormValues(values);
}
filter = function() {
	/*
	 * $('#tt').tree({ filter: function(q, node){ return
	 * node.text.toLowerCase().indexOf(q.toLowerCase()) >= 0; } })
	 */
	$('#authTree').tree({
		// url:
		// '../services/authorities/authoritiesService/findAuthoritiesList',
		loadFilter : function(data) {
			if (data.d) {
				return data.d;
			} else {
				return data;
			}
		}
	});
}

/* 设置表单值 */
function getFormValues() {
	var values = {};
	values.authId = $('input[name="authId"]').val();
	values.authName = $('input[name="authName"]').val();
	values.authCode = $('input[name="authCode"]').val();
	values.parentId = $('input[name="parentId"]').val();
	values.authDesc = $('#authDesc').val();
	return values;
}

/* 设置表单值 */
function setFormValues(values) {
	$('input[name="authId"]').val(values.authId);
	$('input[name="authName"]').val(values.authName);
	$('input[name="authCode"]').val(values.authCode);
	$('input[name="parentId"]').val(values.parentId);
	$('#authDesc').val(values.authDesc);
}
