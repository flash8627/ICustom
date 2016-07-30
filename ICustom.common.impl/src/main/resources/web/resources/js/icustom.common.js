
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
