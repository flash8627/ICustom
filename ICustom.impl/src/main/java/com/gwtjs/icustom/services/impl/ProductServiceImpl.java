package com.gwtjs.icustom.services.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.icustom.entity.Product;
import com.gwtjs.icustom.services.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    private static final List<Product> productList = new ArrayList<Product>();

    static {
        productList.add(new Product(1, "iphone 5s", 5000));
        productList.add(new Product(2, "ipad mini", 2500));
    }

    public List<Product> findAllProducts(int pageSize,int curPage) {
        /*productList.clear();
        java.util.Random random = new java.util.Random();
        for (int i = 1; i <= 10000; i++) {
            productList.add(new Product(i, java.util.UUID.randomUUID().toString(), random.nextInt(10000)));
        }*/
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                return (product2.getId() > product1.getId()) ? 1 : -1;
            }
        });
        return productList;
    }

    public Product findProductById(long id) {
        Product targetProduct = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                targetProduct = product;
                break;
            }
        }
        return targetProduct;
    }

    public List<Product> retrieveProductsByName(String name) {
        List<Product> targetProductList = new ArrayList<Product>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                targetProductList.add(product);
            }
        }
        return targetProductList;
    }

    public Product createProduct(Product product) {
        product.setId(new Date().getTime());
        productList.add(product);
        return product;
    }

    public Product updateProductById(long id, Map<String, Object> fieldMap) {
        Product product = findProductById(id);
        if (product != null) {
            try {
                for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
                    Field field = Product.class.getDeclaredField(fieldEntry.getKey());
                    field.setAccessible(true);
                    field.set(product, fieldEntry.getValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return product;
    }

    public ResultWrapper deleteProductById(long id) {
        Product targetProduct = null;
        Iterator<Product> productIterator = productList.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getId() == id) {
                targetProduct = findProductById(id);
                productIterator.remove();
                break;
            }
        }
        return ResultWrapper.successResult("操作成功", targetProduct);
    }
}
