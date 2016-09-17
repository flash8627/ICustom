var AjaxUtil = function() {
    $.ajaxSetup({
        statusCode: {
            401: function() {
                alert('401 - Unauthorized');
            },
            403: function() {
                alert('403 - Forbidden');
            },
            403: function() {
                alert('405 - Method Not Allowed,POST,DELETE,GET,PUT???');
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
        sendGetAsyncRequest: function(url, callback) {
            $.ajax({
                type: 'get',
                url: url,
                dataType: 'json',
                async: false,
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
        sendPostAsyncData: function(url, json, callback) {
            $.ajax({
                type: 'post',
                url: url,
                data: JSON.stringify(json),
                dataType: 'json',
                async: false,
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
                type: 'DELETE',
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

var TemplateUtil = function() {
    var templates = {};
    var partials = {};
    $('script[type^="text/x-handlebars-template"]').each(function() {
        var id = $(this).attr('id');
        templates[id] = $(this).html();
        if ($(this).attr('type').lastIndexOf('partial') != -1) {
            partials[id] = $(this).html();
        }
    });
    return {
        getTemplate: function(id) {
            return templates[id];
        },
        registerPartical: function(name, id) {
            Handlebars.registerPartial(name, partials[id]);
        },
        renderHtml: function(id, data) {
            return Handlebars.compile(templates[id])(data);
        }
    };
}();