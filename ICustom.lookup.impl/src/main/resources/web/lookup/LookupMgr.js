/**
 * 
 */
var lookup = {};

var validateRemoveBtn = function() {
	var checkNum = $('input:checkbox[name=classId]:checked').length;
	if (checkNum > 0) {
		$(".optionbtn").removeClass("l-btn-disabled");
	} else {
		$(".optionbtn").addClass("l-btn-disabled");
	}
}

validateItemRemoveBtn = function() {
	var checkNum = $('input:checkbox[name=itemId]:checked').length;
	if (checkNum > 0) {
		$(".itemOptionbtn").removeClass("l-btn-disabled");
	} else {
		$(".itemOptionbtn").addClass("l-btn-disabled");
	}
}

$(function() {

	// 显示所有产品
	// $('body').hide(); // 隐藏界面
	LookupService.findLookups(function() {
		$('body').show(); // 显示界面
	});

	// $(".itemActionbtn").removeClass("l-btn-disabled");
	$(".itemOptionbtn").removeClass("l-btn-disabled");
	$(".itemFormActionbtn").removeClass("l-btn-disabled");

	// 根据关键字查询产品
	$('#lookup_search_form').on('submit', function() {
		var keyword = $('#keyword').val().trim();
		LookupService.findLookupsByName(keyword);
		return false;
	});

	// 点击 Create 按钮，弹出创建产品对话框
	$('#lookup_create').on('click', function() {
		var lookup = {
			classId : 0,
			classCode : '',
			orderCode : 1,
			className : '',
			classDesc : ''
		};
		LookupView.insertLookupEditorRow(lookup);
		$(".actionbtn").toggleClass("l-btn-disabled");
	});

	// 点击对话框中的 Save 按钮，创建或更新产品
	$('#lookup_modal_submit').on('click', function() {
		var id = $('#classId').val();
		var lookup = [ {
			classId : id,
			classCode : $('#classCode').val().trim(),
			orderCode : $('#orderCode').val().trim(),
			className : $('#className').val().trim(),
			classDesc : $('#classDesc').val().trim()
		} ];
		if (id == 0) {
			LookupService.batchInsertLookup(lookup);
		} else {
			LookupService.batchUpdateLookup(lookup);
		}
		// 删除当前行
		$("tr.template").detach();
	});

	// 点击 Edit 按钮，插入编辑行
	$(document).on('click', '#lookup_table .lookup_edit', function() {
		var $tr = $(this).closest('tr');
		var itemId = $tr.data('id');
		var lookup = LookupService.findLookupById(itemId);
		// 删除当前行
		LookupView.deleteLookupRow(itemId);
		// 插入编辑行
		LookupView.insertLookupEditorRow(lookup.obj);
		$(".actionbtn").toggleClass("l-btn-disabled");
	});

	// 点击 Delete 按钮，删除产品
	$(document).on('click', '#lookup_remove', function() {
		var chkValues = [];
		$('input[name="classId"]:checked').each(function() {
			var item = {
				classId : $(this).val()
			}
			chkValues.push(item);
		});
		if (chkValues.length < 1) {
			//
			return;
		}
		if (confirm('Do you want to delete this Lookup?')) {
			LookupService.deleteLookupRows(chkValues);
		}
		return false;
	});

	// 点击 Edit 按钮，弹出编辑产品对话框
	$(document).on('click', '#lookup_table .lookup_item_edit', function() {
		var $tr = $(this).closest('tr');
		var itemId = $tr.data('id');
		var classCode = $tr.find('td[data-name="classCode"]').text().trim();
		var className = $tr.find('td[data-name="className"]').text().trim();
		lookup = {
			classId : itemId,
			classCode : classCode,
			className : className
		};
		// var lookup = LookupService.findLookupById(itemId);
		LookupItemService.initLookupItems(lookup, function() { });

	});
	// 点击 行cancel按钮，撤销编辑
	$(document).on('click', '.lookup_edit_cancel', function() {
		var $tr = $(this).closest('tr');
		var lookupId = $tr.data('id');
		var classCode = $tr.find('input[id="classCode"]').val();
		var className = $tr.find('input[id="className"]').val();
		var orderCode = $tr.find('input[id="orderCode"]').val();
		var classDesc = $tr.find('input[id="classDesc"]').val();
		var createdUser = $tr.find('td[data-name="createdUser"]').text().trim();
		var createdDate = $tr.find('td[data-name="createdDate"]').text().trim();
		var updateLastUser = $tr.find('td[data-name="updateLastUser"]').text().trim();
		var updateLastDate = $tr.find('td[data-name="updateLastDate"]').text().trim();
		look = {
				classId : lookupId,
				classCode : classCode,
				className : className,
				orderCode:orderCode,
				classDesc:classDesc,
				createdUser:createdUser,
				createdDate:createdDate,
				updateLastUser:updateLastUser,
				updateLastDate:updateLastDate
		}
		$tr.detach();console.info(look);
		LookupView.insertLookupRows([look]);
		$("#lookup_create").removeClass("l-btn-disabled");
		$("#lookup_modal_submit").addClass("l-btn-disabled");

	});

	// 点击 行cancel按钮，撤销编辑
	$(document).on('click', '.lookup_item_row_edit_cancel', function() {
		var $tr = $(this).closest('tr');
		var itemId = $('#itemId').val();
		var lookupItem = LookupItemService.findLookupItemById(itemId);
		// 删除当前行
		$tr.detach();
		// 插入编辑行
		LookupItemView.insertLookupItemRow(lookup.classCode, lookupItem.obj);
		$(".itemActionbtn").removeClass("l-btn-disabled");
		$(".itemFormActionbtn").addClass("l-btn-disabled");
		$(".lookup_item_row_edit").removeClass("l-btn-disabled");
	});

	// 点击 行cancel按钮，撤销编辑
	$(document).on(
			'click',
			'.lookup_item_row_edit',
			function() {
				var $tr = $(this).closest('tr');
				var itemId = $tr.data('id');
				var lookupItem = LookupItemService.findLookupItemById(itemId);
				// 删除当前行
				$tr.detach();
				// 插入编辑行
				LookupItemView.insertLookupItemEditorRow(lookup.classCode,
						lookupItem.obj);
				$(".itemActionbtn").addClass("l-btn-disabled");
				$(".itemFormActionbtn").removeClass("l-btn-disabled");
				$(".lookup_item_row_edit").addClass("l-btn-disabled");
			});

});

// 点击 Create 按钮，弹出创建产品对话框
lookupItemBack = function() {
	$('#Lookup_tt').tabs('close', lookup.className);
	// LookupView.insertLookupEditorRow(lookup);
	// $(".actionbtn").toggleClass("l-btn-disabled");
}

// 点击 Create 按钮，弹出创建产品对话框
lookupItemSave = function() {
	var id = $('#itemId').val();
	var lookupItem = [ {
		itemId : id,
		itemCode : $('#itemCode').val().trim(),
		classId : lookup.classId,
		itemName : $('#itemName').val().trim(),
		itemLan : $('#itemLan').val().trim(),
		itemStatus : $('#itemStatus').val().trim(),
		remarks : $('#remarks').val().trim(),
		orderCode : $('#orderCode').val().trim(),
	} ];
	if (id == 0) {
		LookupItemService.batchInsertLookupItem(lookup.classCode, lookupItem);
	} else {
		LookupItemService.batchUpdateLookupItem(lookup.classCode, lookupItem);
	}
	// 删除当前行
	$("tr.item_form_template").detach();
	$(".itemActionbtn").removeClass("l-btn-disabled");
	$(".itemFormActionbtn").addClass("l-btn-disabled");
	$(".lookup_item_row_edit").removeClass("l-btn-disabled");

}

// 点击 Create 按钮，弹出创建产品对话框
lookupItemRemove = function() {
	var chkValues = [];
	$('input[name="itemId"]:checked').each(function() {
		var item = {
			itemId : $(this).val()
		}
		chkValues.push(item);
	});
	if (chkValues.length < 1) {
		//
		return;
	}
	if (confirm('Do you want to delete this Lookup?')) {
		LookupItemService.batchRemoveLookupItem(lookup.classCode, chkValues);
	}
	return false;
}

// 点击 Create 按钮，弹出创建产品对话框
lookupItemAdd = function() {
	var lookupItem = {
		itemId : 0,
		itemCode : '',
		classId : lookup.classId,
		classCode : lookup.classCode,
		itemName : '',
		itemLan : '',
		itemStatus : '',
		remarks : '',
		orderCode : 1
	};

	LookupItemView.insertLookupItemEditorRow(lookup.classCode, lookupItem);
	$(".lookup_item_row_edit").addClass("l-btn-disabled");
	$(".itemActionbtn").addClass("l-btn-disabled");
	// $(".itemOptionbtn").removeClass("l-btn-disabled");
	$(".itemFormActionbtn").removeClass("l-btn-disabled");
	// $(".actionbtn").toggleClass("l-btn-disabled");
}