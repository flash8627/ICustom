var role={};

/**
 * 验证删除角色的按钮状态
 */
var validateRemoveBtn = function(){
	var checkNum = $('input:checkbox[name=roleId]:checked').length;
	if(checkNum>0){
		$(".optionbtn").removeClass("l-btn-disabled");
	}else{
		$(".optionbtn").addClass("l-btn-disabled");
	}
}

/**
 * roleAuthSaveState 验证保存按钮应该的状态
 */
var roleAuthSaveState = function(){
	var checkNum = $('input:checkbox[name=id]:checked');
	var count = 0;
	for(var i=0;i<checkNum.length;i++){
		var chk = checkNum[i];
		var tagId=$(chk).attr('tagId');
		var state = $(chk).prop("checked");
		if(!tagId){
			count++;
		}
	}
	if(count>0){
		$(".itemFormActionbtn").removeClass("l-btn-disabled");
	}else{
		$(".itemFormActionbtn").addClass("l-btn-disabled");
	}
}

/**
 * 获取需要保存的数据
 */
var getRoleAuth = function(){
	var checkNum = $('input:checkbox[name=id]:checked');
	var count = 0;
	var params = [];
	var roleId = $('input[name=curEditorRoleId]').val();//curEditorRoleId
	for(var i=0;i<checkNum.length;i++){
		var chk = checkNum[i];
		var tagId=$(chk).attr('tagId');
		var state = $(chk).prop("checked");
		var param = {};
		if(!tagId){
			count++;
			param.authId = $(chk).val();
			param.id = 0;
			param.roleId = roleId;
			params.push(param);
		}
	}
	return params;
}

/**
 * 验证删除角色的权限的按钮状态
 */
var validateRoleAuthRemoveBtn = function(){
	var checkNum = $('input:checkbox[name=id]:checked').length;
	if(checkNum>0){
		$("#removeRoleAuths").removeClass("l-btn-disabled");
	}else{
		$("#removeRoleAuths").addClass("l-btn-disabled");
	}
}

/**
 * 勾选角色已经有的权限
 */
var checkedRoleAuthsBox = function(){
	var checkNum = $('input:checkbox[name=id]');
	for(var i=0;i<checkNum.length;i++){
		var chk = checkNum[i];
		var tagId=$(chk).attr('tagId');
		if(tagId)
			$(chk).prop("checked",true);
	}
}

$(function() {
	
	// 显示所有产品
	//$('body').hide(); // 隐藏界面
	RoleService.findRoles(function() {
		$('body').show(); // 显示界面
	});

	// 根据关键字查询产品
	$('#role_search_form').on('submit', function() {
		var roleName = $('#roleName').val().trim();
		var roleCode = $('#roleCode').val().trim();
		var roleDesc = $('#roleDesc').val().trim();
		var role = {
			roleDesc:roleDesc,
			roleCode:roleCode,
			roleName:roleName
		};
		RoleService.findRolesByName(role);
		return false;
	});
	
	// 点击 Create 按钮，弹出创建产品对话框
	$('#role_create').on('click', function() {
		var role = {
			roleId : 0,
			orderCode : 1,
			roleName : '',
			roleCode : '',
			roleDesc : ''
		};
		RoleView.insertRoleEditorRow(role);
		
		$(".actionbtn").addClass("l-btn-disabled");
		$(".formbtn").removeClass("l-btn-disabled");
	});

	// 点击对话框中的 Save 按钮，创建或更新产品
	$('#role_modal_submit').on('click', function() {
		var id = $('#roleId').val();
		var role = [{
			roleId : id,
			roleName : $('#roleName').val().trim(),
			roleCode : $('#roleCode').val().trim(),
			orderCode : $('#orderCode').val().trim(),
			roleDesc : $('#roleDesc').val().trim()
		}];
		if (id == 0) {
			RoleService.batchInsertRole(role);
		} else {
			RoleService.batchUpdateRole(role);
		}
		$(".actionbtn").removeClass("l-btn-disabled");
		$(".formbtn").addClass("l-btn-disabled");
		//删除当前行
		$("tr.template").detach();
	});
	
	// 点击 Edit 按钮，插入编辑行
	$(document).on('click', '#role_table .role_edit', function() {
		var $tr = $(this).closest('tr');
		var itemId = $tr.data('id');
		var role = RoleService.findRoleById(itemId);
		//删除当前行
		RoleView.deleteRoleRow(itemId);
		//插入编辑行
		RoleView.insertRoleEditorRow(role.obj);
		$(".actionbtn").addClass("l-btn-disabled");
		$(".formbtn").removeClass("l-btn-disabled");
	});

	// 点击 Delete 按钮，删除产品
	$(document).on('click', '#role_remove', function() {
		var chkValues =[];
		$('input[name="roleId"]:checked').each(function(){
			var item = {roleId:$(this).val()}
			chkValues.push(item);
		});
		if(chkValues.length<1){
			//
			return;
		}
		if (confirm('Do you want to delete this Role?')) {
			RoleService.deleteRoleRows(chkValues);
		}
		return false;
	});
	
	// 点击 Edit 按钮，弹出编辑产品对话框
	$(document).on('click', '#role_table .role_item_edit', function() {
		var $tr = $(this).closest('tr');
		var itemId = $tr.data('id');
		var roleDesc = $tr.find('td[data-name="roleDesc"]').text().trim();
		var roleCode = $tr.find('td[data-name="roleCode"]').text().trim();
		var roleName = $tr.find('td[data-name="roleName"]').text().trim();
		role = {roleId:itemId,roleDesc:roleDesc,roleName:roleName};
		//var role = RoleService.findRoleById(itemId);
		RoleItemService.initRoleItems(role,function(){});
		
		$(".actionbtn").addClass("l-btn-disabled");
		$(".formbtn").removeClass("l-btn-disabled");
		
	});
	// 点击 行cancel按钮，撤销编辑
	$(document).on('click', '.role_edit_cancel', function() {
		var $tr = $(this).closest('tr');
		$tr.detach();
		$("#role_create").removeClass("l-btn-disabled");
		$("#role_modal_submit").addClass("l-btn-disabled");
		
	});
	//移除角色权限
	$(document).on('click', '.role_auths_remove',removeRoleAuthsSubmit);
	// 点击  按钮，弹出编辑角色权限tab
	$(document).on('click', '#role_table .role_gears', addRoleAuthsTab);

});

/**用户角色，开始*/

/**
 * 将角色已经有的权限合并到权限列表对象的属性中，方便选择
 * @param authResult
 * @param roleAuthsData
 */
getRoleAuthsData = function(authResult,roleAuthsData){
	//将角色已经有的权限拼装到系统角色里．
	for(var i=0;i<authResult.length;i++){
		var atu = authResult[i];
		for(var j=0;j<roleAuthsData.length;j++){
			var roleAuth = roleAuthsData[j];
			if(roleAuth.authId==atu.authId){
				//勾选
				authResult[i].roleId = roleAuth.roleId;
				authResult[i].tagId = roleAuth.id;
				authResult[i].myAuth = 'yes';
			}
		}
	}
	return authResult;
}

/**添加角色权限tab*/
addRoleAuthsTab = function(){
	var roleAuths = [];
	var $tr = $(this).closest('tr');
	var roleId = $tr.data('id');
	var roleName = $tr.find('td[data-name="roleName"]').text().trim();
	var roleCode = $tr.find('td[data-name="roleCode"]').text().trim();
	role = {roleId:roleId,roleName:roleName,roleCode:roleCode};
	//var role = UserRoleService.findUserRoleById(itemId);
	roleAuths = RolesAuthoritiesService.findRoleAuthorities(role);
	var auths = RolesAuthoritiesService.findAuthoritiesList();
	//加工对象,合并属性
	auths.result = getRoleAuthsData(auths.result,roleAuths);
	var data = {roleAuths:roleAuths,auths:auths};
	
	//用角色的权限勾选权限列表
	//RolesAuthoritiesService.initRoleAuthorities(data);
	RoleAuthoritiesView.addTabPanel(role,data);
	//勾选角色的权限
	checkedRoleAuthsBox();
	if(roleAuths.length>0){
		$('#removeRoleAuths').removeClass("l-btn-disabled");
	}
}

//关闭tab并返回到角色列表
roleAuthItemsBack = function() {
	$('#Role_tt').tabs('close', role.roleName);
	//LookupView.insertLookupEditorRow(lookup);
	//$(".actionbtn").toggleClass("l-btn-disabled");
}

//把新增的数据id插入视图
buildRoleAuthsView = function(items){
	var roleId = items[0].roleId;
	//role_item_23_table
	var tabId = 'role_item_'+roleId+'_table';
	var trs = $('#'+tabId).find('tbody tr').find('input[name="id"]');
	for(var i=0;i<trs.length;i++){
		var item = trs[i];
		var authId = $(item).val();
		for(var j=0;j<items.length;j++){
			if(authId==items[j].authId){
				var item = items[j];
				//勾选
				$(trs[i]).attr('tagId',item.id);
				$(trs[i]).parent().find('input[name="tagId"]').val(item.id);
				$(trs[i]).parent().find('input[name="roleId"]').val(roleId);
			}
		}
	}
}

//保存角色权限
roleAuthItemsSave = function(){
	var params = getRoleAuth();
	if(params.length>0){
		var result = RolesAuthoritiesService.batchSaveRoleAuthorieies(params);
		if(result.status==1){
			buildRoleAuthsView(result.obj);
		}
	}
}

//删除角色的权限
removeRoleAuthsSubmit = function(){
	var $tr = $(this).closest('tr');
	var id = $tr.find('input[name="tagId"]').val();
	var ids = {id:id};
	console.info(id,$tr);
	if (confirm('Do you want to delete this Role authorities?')) {
		RolesAuthoritiesService.batchRemoveRoleAuthorities([ids]);
		$tr.find('input[name="id"]').prop("checked",false);;
		$tr.find('input[name="tagId"]').val('');
		$tr.find('input[name="roleId"]').val('');
		$tr.find('td[data-name="tagId"]').text('');
		$tr.find('td[data-name="myAuth"]').text('');
	}
	return false;
}

