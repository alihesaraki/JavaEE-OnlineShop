package com.mftplus.demo.test;


import com.mftplus.demo.model.entity.Inventory;
import com.mftplus.demo.model.entity.InventoryProduct;


public class InventoryTest {
    public static void main(String[] args) {

        InventoryProduct inventoryProduct = InventoryProduct.builder().quantity(564d).build();

        Inventory inventory = Inventory.builder()
                .phone("555")
                .address("MMMMM")
                .title("NN")
                .inventoryProduct(inventoryProduct)
                .build();
        System.out.println("inventory: " + inventory);
    }
}
