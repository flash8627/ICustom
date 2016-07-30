var AjaxUtil = function() {
	console.info('AjaxUtil success...');
    $.ajaxSetup({
        statusCode: {
            401: function() {
                alert('401 - Unauthorized');
            },
            403: function() {
                alert('403 - Forbidden');
            }
        }
    });
    return {
        sendGetRequest: function(url, callback) {
            $.ajax({
                type: 'get',
                url: url,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        },
        sendFormData: function(url, json, callback) {
            $.ajax({
                type: 'post',
                url: url,
                data: json,
                dataType: 'json',
                contentType: 'application/json',
                success: function(data) {
                    callback(data);
                }
            });
        },
        sendPostData: function(url, json, callback) {
            $.ajax({
                type: 'post',
                url: url,
                data: JSON.stringify(json),
                dataType: 'json',
                contentType: 'application/json',
                success: function(data) {
                    callback(data);
                }
            });
        },
        sendPutData: function(url, json, callback) {
            $.ajax({
                type: 'put',
                url: url,
                data: JSON.stringify(json),
                dataType: 'json',
                contentType: 'application/json',
                success: function(data) {
                    callback(data);
                }
            });
        },
        sendDeleteRequest: function(url, callback) {
            $.ajax({
                type: 'delete',
                url: url,
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        },
        sendBatchRemove: function(url,json, callback) {
            $.ajax({
                type: 'delete',
                url: url,
                data: JSON.stringify(json),
                dataType: 'json',
                success: function(data) {
                    callback(data);
                }
            });
        }
    };
}();
