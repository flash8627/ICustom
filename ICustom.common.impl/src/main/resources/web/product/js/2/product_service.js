var ProductService = function() {
    var BASE = '../services/product/productMgs';
    return {
        retrieveAllProducts: function(callback) {
            AjaxUtil.sendGetRequest(BASE + '/products/20/1', function(productList) {
                ProductView.renderProductTable(productList);
                callback();
            });
        },
        retrieveProductById: function(id) {
            AjaxUtil.sendGetRequest(BASE + '/product/' + id, function(product) {
                var title = 'Edit Product';
                ProductView.renderProductModal(title, product);
            });
        },
        retrieveProductsByName: function(name) {
            AjaxUtil.sendFormData(BASE + '/products', {
                name: name
            }, function(productList) {
                ProductView.renderProductTable(productList);
            });
        },
        createProduct: function(product) {
            AjaxUtil.sendPostData(BASE + '/create', product, function(product) {
                ProductView.insertProductRow(product);
            });
        },
        updateProductById: function(id, product) {
            AjaxUtil.sendPutData(BASE + '/update/' + id, product, function(product) {
                ProductView.updateProductRow(product);
            });
        },
        deleteProductById: function(id) {
            AjaxUtil.sendDeleteRequest(BASE + '/delete/' + id, function() {
                ProductView.deleteProductRow(id);
            });
        }
    }
}();