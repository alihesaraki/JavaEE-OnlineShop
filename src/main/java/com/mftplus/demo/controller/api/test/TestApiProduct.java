package com.mftplus.demo.controller.api.test;

import com.mftplus.demo.model.entity.GroupProperty;
import com.mftplus.demo.model.entity.Product;
import com.mftplus.demo.model.entity.ProductGroup;
import com.mftplus.demo.model.entity.ProductPropertyValue;
import com.mftplus.demo.model.service.GroupPropertyService;
import com.mftplus.demo.model.service.ProductGroupService;
import com.mftplus.demo.model.service.ProductPropertyValueService;
import com.mftplus.demo.model.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Path("/testProduct")
@Slf4j
public class TestApiProduct {

//    @Inject
//    private ProductService productService;

//    @GET
//    public String test() {
//        log.info("test get product");
////        ProductGroup child = new ProductGroup();
////        ProductGroup parent = new ProductGroup();
////        child.setName("digital");
////        parent.setName("electronic");
////        ProductPropertyValue productPropertyValue = ProductPropertyValue.builder().name("cable").build();
////        GroupProperty groupProperty = GroupProperty.builder().name("accessory").productPropertyValue(productPropertyValue).build();
////        ProductGroup productGroup = ProductGroup.builder().name("mobile").parent(parent).groupProperty(groupProperty).build();
//        Product product = Product.builder().name("aux").code(564l).price(52.6f).build();
//        productService.save(product);
//        return productService.findAll().toString();
//
//    }

//    @Inject
//    private ProductGroupService productGroupService;
//    @GET
//    public String test() {
//        log.info("test get product group");
//        ProductGroup child = new ProductGroup();
//        ProductGroup parent = new ProductGroup();
//        child.setName("digital");
//        parent.setName("electronic");
////        ProductPropertyValue productPropertyValue = ProductPropertyValue.builder().name("cable").build();
////        GroupProperty groupProperty = GroupProperty.builder().name("accessory").productPropertyValue(productPropertyValue).build();
//        ProductGroup productGroup = ProductGroup.builder().name("mobile").parent(parent).childList(List.of(child)).build();
//        productGroupService.save(productGroup);
//        return productGroupService.findAll().toString();
//
//    }
//    @Inject
//    private ProductPropertyValueService productPropertyValueService;
//
//    @GET
//    public String test (){
//        log.info("get pro group value");
//        GroupProperty groupProperty = GroupProperty.builder().name("accessory").build();
//        ProductPropertyValue productPropertyValue = ProductPropertyValue.builder().name("cable").groupProperty(groupProperty).build();
//        productPropertyValueService.save(productPropertyValue);
//       return productPropertyValueService.findAll().toString();
//    }


    @Inject
    private GroupPropertyService groupPropertyService;

    @GET
    public String test (){
        log.info("get  group property test");
        ProductPropertyValue productPropertyValue = ProductPropertyValue.builder().name("cable").build();
        GroupProperty groupProperty = GroupProperty.builder().name("mobile accessory").productPropertyValue(productPropertyValue).build();
        groupPropertyService.save(groupProperty);
        return groupPropertyService.findAll().toString();
    }
}
