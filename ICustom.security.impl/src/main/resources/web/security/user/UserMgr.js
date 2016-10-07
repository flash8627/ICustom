/**全局参数*/
var user={};
var userRoles=[];

var validateRemoveBtn = function() {
	var checkNum = $('input:checkbox[name=userId]:checked').length;
	if (checkNum > 0) {
		$(".optionbtn").removeClass("l-btn-disabled");
	} else {
		$(".optionbtn").addClass("l-btn-disabled");
	}
}

var validateRemoveBtn = function(){
	var checkNum = $('input:checkbox[name=id]:checked').length;
	if (checkNum > 0) {
		$(".userRoleOptionBtn").removeClass("l-btn-disabled");
	} else {
		$(".userRoleOptionBtn").addClass("l-btn-disabled");
	}
}

$(function() {

	// 显示所有产品
	// $('body').hide(); // 隐藏界面
	UserService.findUsers(function() {
		$('body').show(); // 显示界面
	});

	// 根据关键字查询产品
	$('#user_search_form').on('submit', function() {
		var keyword = $('#keyword').val().trim();
		UserService.findUsersByName(keyword);
		return false;
	});

	// 点击 Create 按钮，弹出创建产品对话框
	$('#user_create').on('click', function() {
		var user = {
			userId : 0,
			userAccount : '',
			username : '',
			password : '',
			userDesc : '',
			userEnabled : 1,
			issys : 0,
			userDept : 1,
			userDuty : 1,
			subSystem : 0,
			attribute1 : '',
			attribute2 : '',
			attribute3 : '',
			attribute4 : '',
			attribute5 : '',
			attribute6 : '',
			attribute7 : '',
			attribute8 : '',
			attribute9 : '',
			attribute10 : '',
			validStart : 'today',
			validEnd : getFormatDate(new Date(), "yyyy/MM/dd hh:mm"),
			orderCode : 1,
			createdUser : '10001',
			createdDate : getFormatDate(new Date(), "yyyy/MM/dd hh:mm"),
			updateLastUser : '10001',
			updateLastDate : getFormatDate(new Date(), "yyyy/MM/dd hh:mm")
		};
		UserView.insertUserEditorRow(user);

		$(".actionbtn").addClass("l-btn-disabled");
		$(".formbtn").removeClass("l-btn-disabled");
	});

	// 点击对话框中的 Save 按钮，创建或更新产品
	$('#user_modal_submit').on('click', function() {
		var id = $('#userId').val();

		var user = {
			userId : id,
			userAccount : $('#userAccount').val(),
			username : $('#username').val(),
			password : $('#password').val(),
			userDesc : $('#userDesc').val(),
			userEnabled : $('#userEnabled').is(':checked') ? 1 : 0,
			issys : 0,
			userDept : $('#userDept').val(),
			userDuty : $('#userDuty').val(),
			subSystem : 0,
			attribute1 : '',
			attribute2 : '',
			attribute3 : '',
			attribute4 : '',
			attribute5 : '',
			attribute6 : '',
			attribute7 : '',
			attribute8 : '',
			attribute9 : '',
			attribute10 : '',
			validEnd : $('#validEnd').val(),
			orderCode : $('#orderCode').val()
		};

		if (id == 0) {
			UserService.batchInsertUser([ user ]);
		} else {
			UserService.batchUpdateUser([ user ]);
		}
		$(".actionbtn").removeClass("l-btn-disabled");
		$(".formbtn").addClass("l-btn-disabled");
		// 删除当前行
		$("tr.user_form_template").detach();
	});

	// 点击 Edit 按钮，插入编辑行
	$(document).on('click', '#user_table .user_edit', function() {
		var $tr = $(this).closest('tr');
		var userId = $tr.data('id');
		var user = UserService.findUserById(userId);
		// 删除当前行
		UserView.deleteUserRow(userId);
		// 插入编辑行
		UserView.insertUserEditorRow(user.obj);
		$(".actionbtn").addClass("l-btn-disabled");
		$(".formbtn").removeClass("l-btn-disabled");
	});

	// 点击 Delete 按钮，删除产品
	$(document).on('click', '#user_remove', function() {
		var chkValues = [];
		$('input[name="userId"]:checked').each(function() {
			var item = {
				userId : $(this).val()
			}
			chkValues.push(item);
		});
		if (chkValues.length < 1) {
			//
			return;
		}
		if (confirm('Do you want to delete this User?')) {
			UserService.deleteUserRows(chkValues);
		}
		return false;
	});

	// 点击 Edit 按钮，弹出编辑产品对话框
	$(document).on(
			'click',
			'#user_table .user_item_edit',
			function() {
				var $tr = $(this).closest('tr');
				var userId = $tr.data('id');
				var userAccount = $tr.find('td[data-name="userAccount"]')
						.text().trim();
				var username = $tr.find('td[data-name="username"]').text()
						.trim();
				user = {
					userId : userId,
					userAccount : userAccount,
					username : username
				};
				// var user = UserService.findUserById(userId);
				UserItemService.initUserItems(user, function() {});

	});

	// 点击 行cancel按钮，撤销编辑
	$(document).on('click', '.user_edit_cancel', function() {
		var $tr = $(this).closest('tr');
		var userId = $tr.data('id');
		var user = {
			userId : userId,
			userAccount : $('#userAccount').val(),
			username : $('#username').val(),
			password : $('#password').val(),
			userDesc : $('#userDesc').val(),
			userEnabled : $('#userEnabled').is(':checked') ? 1 : 0,
			userDept : $('#userDept').val(),
			userDuty : $('#userDuty').val(),
			validEnd : $('#validEnd').val(),
			orderCode : $('#orderCode').val(),
			createdUser : $('#createdUser').val(),
			createdDate : $('#createdDate').val(),
			updateLastUser : $('#updateLastUser').val(),
			updateLastDate : $('#updateLastDate').val()
		};
		$tr.detach();
		UserView.insertUserRows([ user ]);
		$("#user_create").removeClass("l-btn-disabled");
		$("#user_modal_submit").addClass("l-btn-disabled");

	});

});

/** 用户角色，开始 */

// 点击 按钮，弹出编辑用户角色tab
$(document).on('click', '#user_table .user_roles_editor', function() {
	var $tr = $(this).closest('tr');
	var userId = $tr.data('id');
	var userAccount = $tr.find('td[data-name="userAccount"]').text().trim();
	var username = $tr.find('td[data-name="username"]').text().trim();
	user = {
		userId : userId,
		userAccount : userAccount,
		username : username
	};
	// var user = UserRoleService.findUserRoleById(itemId);
	// UserRolesService.initUserRoleItems(user,function(){});
	userRoles = UserRolesService.findUserRoles(user);
	var roles = UserRolesService.findSysRoles(user);
	var data = {
		userRoles : userRoles,
		roles : roles
	};

	UserRolesView.addTabPanel(user, data);
});

/**给用户添加角色*/
addUserRole = function(node) {
	var flag = $(node).prop('checked');
	var $tr = $(node).closest('tr');
	
	if (flag) {
		var roleId = $(node).val();
		var userId = $('#curEditorUserId').val();
		var userAccount = $('#curEditorUserAccount').val();
		var roleName = $tr.find('td[data-name="roleName"]').text().trim();
		var roleDesc = $tr.find('td[data-name="roleDesc"]').text().trim();
		var ur = [{roleId:roleId,userId:userId,roleName:roleName,roleDesc:roleDesc,id:0}];
		//console.warn(roleId,roleName+","+ur);
		var status = rolesCompareToUserRoles(userAccount,roleId);
		if(!status){
			UserRolesService.batchInsertUserRole(userAccount,ur);
		}
		
	}
	// 查询对象是否已经存在，如果存在，高亮一下；如果不存在，则添加到对象表格，并插入数据库

}
/*移除用户拥有的角色*/
removeUserRole = function() {
	var userAccount = $('#curEditorUserAccount').val();
	var trs = $('#user_roles_'+userAccount+'_table').find('tbody tr');
	for(var i=0;i<trs.length;i++){
		var rowId = $(trs[i]).attr('data-id');
		var $tr = $("#user_roles_"+rowId).closest('tr');
		var id=$tr.data('id');
	}
	var chkValues = [];
	$('input[name="id"]:checked').each(function() {
		var item = {
			id : $(this).val()
		}
		chkValues.push(item);
	});
	if (chkValues.length < 1) {
		return;
	}
	if (confirm('Do you want to delete this User Roles?')) {
		UserRolesService.batchRemoveUserRoles(userAccount,chkValues);
	}
	return false;
	
}
$(document).on(
		'click',
		'#userRoles_remove',removeUserRole);
/**
 * 验证当前用户　是否存在此角色
 * @param userAccount
 */
rolesCompareToUserRoles = function(userAccount,roleId){
	var result = false;
	var num = 0;
	var trs = $('#user_roles_'+userAccount+'_table').find('tbody tr');
	for(var i=0;i<trs.length;i++){
		var rowId = $(trs[i]).attr('data-id');
		var $tr = $("#user_roles_"+rowId).closest('tr');
		var userOldRoleId = $tr.find('input[name="roleId"]').val().trim();
		console.info(roleId,userOldRoleId);
		if(roleId==userOldRoleId){
			result = true;
			num++;
			break;
		}
	}
	return result;
}

/**
 * 比对初始化时的用户角色和现在视图中的用户角色是否否相等
 * 任何一个页面　元素在原初始化时的数组中找不到，即为新增了角色
 * */
compareUserRoles = function(userAccount){
	var trs = $('#user_roles_'+userAccount+'_table').find('tbody tr');
	for(var i=0;i<trs.length;i++){
		var rowId = $(trs[i]).attr('data-id');
		var $tr = $("#user_roles_"+rowId).closest('tr');
		console.warn(rowId,$tr);
		var id=$tr.data('id');
		console.warn(id,$tr);
		var roleName = $tr.find('td[data-name="roleName"]').text().trim();
		console.warn(id,roleName);
	}
}

// 点击 Create 按钮，弹出创建产品对话框
userItemBack = function() {
	$('#User_tt').tabs('close', user.userAccount);
	// LookupView.insertLookupEditorRow(lookup);
	// $(".actionbtn").toggleClass("l-btn-disabled");
}
