package com.gwtjs.common.services;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gwtjs.common.entity.Product;
import com.gwtjs.common.entity.ResultWrapper;

@Path("/productMgs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface IProductService {
	
    @GET
    @Path("/products/{pageSize}/{curPage}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findAllProducts(@PathParam("pageSize") int pageSize,@PathParam("curPage") int curPage);

    @GET
    @Path("/product/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Product findProductById(@PathParam("id") long id);

    @POST
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    List<Product> retrieveProductsByName(@FormParam("name") String name);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    Product createProduct(Product product);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    Product updateProductById(@PathParam("id") long id, Map<String, Object> fieldMap);

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    ResultWrapper deleteProductById(@PathParam("id") long id);
}

