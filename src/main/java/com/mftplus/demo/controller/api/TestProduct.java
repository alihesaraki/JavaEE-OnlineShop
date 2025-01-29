package com.mftplus.demo.controller.api;


import com.mftplus.demo.model.entity.GroupProperty;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.entity.ProductGroup;
import com.mftplus.demo.model.entity.ProductPropertyValue;
import com.mftplus.demo.model.service.ProductGroupService;
import com.mftplus.demo.model.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/test5")
public class TestProduct {
    @Inject
    private ProductService productService;
    @GET
    public String test(){
        ProductGroup child = new ProductGroup();
        ProductGroup parent = new ProductGroup();
        child.setName("digital");
        parent.setName("electronic");
        ProductPropertyValue productPropertyValue= ProductPropertyValue.builder().name("64G").build();
        GroupProperty groupProperty = GroupProperty.builder().name("ram").productPropertyValue(productPropertyValue).build();
        ProductGroup productGroup =ProductGroup.builder().groupProperty(groupProperty).name("laptop").parent(parent).build();
        Product product =Product.builder()
                .name("laptop")
                .price(20F)
                .productGroup(productGroup)
                .code(1L)
                .build();

        productService.save(product);
        return product.toString();

    }
}
