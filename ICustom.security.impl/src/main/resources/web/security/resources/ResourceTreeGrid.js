var BASE = '../../services/sys/resourcesService';

var tname = 'zh_cn=System User,zh_en=System User';

$(function() {
	$(".actionbtn").toggleClass("l-btn-disabled");
	$(".formbtn").toggleClass("l-btn-disabled");
	//视图加载
	viewGrid();
})

var viewGrid = function(resourceId) {
	var resUrl = BASE + '/findResourcesTree';
	if (resourceId != undefined) {
		resUrl = resUrl + '/' + resourceId;
	}
	$('#tg').treegrid({
		url : BASE + '/findResourcesTree',
		method : 'get',
		fitColumns : true,
		rownumbers : true,
		idField : 'resourceId',
		treeField : 'resourceName',
		onBeforeExpand : function(row) {
			if (row) {
				$('#tg').treegrid('options').url = resUrl+"/"+row.resourceId;
			}else{
				$('#tg').treegrid('options').url = resUrl;
			}
		},
		onSelect:function(row){
			//选择行后可以执行添加删除修改
			$(".formbtn").addClass("l-btn-disabled");
			$(".actionbtn").removeClass("l-btn-disabled");
		},
		showFooter : true,
		onDblClickRow : function(rowIndex, rowData) {
			onEditItem();
		},
		onBeforeEdit:function(row){
		    // 编辑后的数据在row里面 console.warn(row);
			$(".formbtn").removeClass("l-btn-disabled");
			$(".actionbtn").addClass("l-btn-disabled");
		},
		onCancelEdit:function(row,changes){
		    // 编辑后的数据在row里面 console.warn(row);
			$(".formbtn").addClass("l-btn-disabled");
			$(".actionbtn").removeClass("l-btn-disabled");
		},
		columns :[[
		{
			title : '名称',field : 'resourceName',width : 260,editor : 'text',options : {	required : true},formatter : resourceNameFormatter
		}, {
			title : '上级',field : 'parentName',	width : 180,align : 'left',formatter : resourceNameFormatter,editor : 'text'
		}, {
			title : '地址',field : 'resUrl',	width : 180,align : 'left',editor : 'text'
		}, {
			title : '启用',field : 'useStatus',	width : 60,editor:{type:'checkbox',options:{on:1,off:0}},
			formatter : resourceUseStatus		
		},{
			title : '说明',field : 'resourceDesc',	width : 120,align : 'left',editor : 'text'
		}, {
			title : '资源类型',field : 'resourceType',	width : 120,editor : 'text',formatter : resourceTypeFormatter
		}, {
			title : '排序码',field : 'orderCode',width : 80,editor : 'numberbox'
		}, {
			title : '创建用户',field : 'createdUser',width : 120,align : 'right',formatter : createNameFormatter
		}, {
			title : '创建时间',field : 'createdDate',width : 120,formatter : dataFormatter
		}, {
			title : '更新用户',field : 'updateLastUser',width : 120,align : 'right',formatter : updateNameFormatter
		}, {
			title : '更新时间', field : 'updateLastDate',width : 120,formatter : dataFormatter
		}
		]]
	});
}

updateNameFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	if (!rowData.lastNameCn) {
		return value;
	}
	return rowData.lastNameCn;
}

resourceUseStatus=function(value, rowData) {
	if(value==undefined){
		return "<span style='color:#5cb85c'>√</span>";
	}
	if(value==1){
		return "<span style='color:#5cb85c'>√</span>";
	}else{
		return "<span style='color:#e4cc05'>×</span>";
	}
}

resourceTypeFormatter = function(value, rowData) {
	if (!value) {
		return "页面";
	}
	if (value==0 || value ==1) {
		return "页面";
	}else if (value==2){
		return "按钮";
	}else if (value==3){
		return "其它";
	}
	return "";
}

createNameFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	if (!rowData.nameCn) {
		return value;
	}
	return rowData.nameCn;
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

formatName = function(value, row, index) {
	// 在名称前面显示图标就是靠iconCls属性，iconCls属性为一个css类，easyui拿到这个属性值就能显示相应的图标了
	// 由于传递过来的json字符串中未包含iconCls属性，只有icon属性，所以要想easyui显示图标只需将icon的值赋给iconCls
	row.iconCls = row.icon;
	return value;
}

dataFormatter = function(value, rowData) {
	if (!value) {
		return "";
	}
	var result = getFormatDateByLong(value, "yyyy-MM-dd");
	return result;
}

function expandNode(){
	var node = $('#tg').tree('getSelected');
	if (node){
		$('#tg').tree('expandAll', node.target);
	}
}

var editingId;
var createFlag = false;

function onEditItem() {
	createFlag = false;
	if (editingId != undefined) {
		$('#tg').treegrid('select', editingId);
		return;
	}
	var row = $('#tg').treegrid('getSelected');
	if (row) {
		editingId = row.resourceId;
		$('#tg').treegrid('beginEdit', editingId);
	}
}

function onAddItem() {
	var node = $('#tg').treegrid('getSelected');
	if (node == null) {
		jQuery.messager.alert('提示:', '请选择上一级条目!', 'info');
	} else {
		//回调函数为addSequence,并拼装对象
		ResourcesService.getItemId(addSequence);
		// ResourcesService.createResources(res);

		/*
		 * $('#tg').treegrid('select', editingId); onEditItem();
		 */

	}
}

function addSequence(sequence){
	createFlag = true;
	var node = $('#tg').treegrid('getSelected');
	var index = sequence;
	var parentName = "";
	if(node){
		parentName = node.resourceName;
	}
	var data = [{
		resourceId : index,
		resourceName : '',
		parentName:parentName,
		resUrl : '',
		resourceType : 0,
		resourceDesc : '',
		useStatus:1,
		orderCode : parseInt(Math.random() * 100),
		createdUser : '10001',
		createdDate : getFormatDateByLong(null, "yyyy-MM-dd"),
		updateLastUser : '10001',
		updateLastDate : getFormatDateByLong(null, "yyyy-MM-dd")
	}];
	
	$('#tg').treegrid('append', {
		parent : node.resourceId,
		data : data
	});
	editingId = index;
	$('#tg').treegrid('beginEdit', index);
}

function onRemoveItem() {
	var node = $('#tg').treegrid('getSelected');
	if (!node) {
		//$(this).tooltip('show');
		jQuery.messager.alert('提示:', '请选择资源再进行删除操作!', 'info');
	}else{
		$.messager.confirm("提示信息", "确定要删除资源吗？", function(r){
			$('#tg').treegrid('remove', node.resourceId);
			ResourcesService.deleteResourcesById(node.resourceId);
		});
	}
	
}

function onSaveItem() {
	if (editingId != undefined) {
		var t = $('#tg');
		var row = t.treegrid('find', editingId);
		//console.warn('更新数据', row);
		t.treegrid('endEdit', editingId);
		
		var res = {
			resourceId : row.resourceId,
			resourceName : row.resourceName,
			parentId : row._parentId,
			resUrl : row.resUrl,
			resourceType : row.resourceType,
			resourceDesc : row.resourceDesc,
			useStatus:row.useStatus,
			icon : row.icon,
			orderCode : row.orderCode
		};
		
		if (createFlag) {
			ResourcesService.createResources(res);
		} else {
			ResourcesService.updateResources(res);
		}
		editingId = undefined;

		$(".formbtn").addClass("l-btn-disabled");
		$(".actionbtn").removeClass("l-btn-disabled");
	}
}

function onEditCancel() {
	if (editingId != undefined) {
		$('#tg').treegrid('cancelEdit', editingId);
		if (createFlag) {
			$('#tg').treegrid('remove', editingId);
		}
		editingId = undefined;
		$('#tg').treegrid('reloadFooter');
	}
	
}
