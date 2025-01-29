package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "inventory_product")
@Table(name = "inventoryProduct_tbl")
public class InventoryProduct extends Base{

    @Id
    @SequenceGenerator(name = "inventory_product_seq", sequenceName = "inventory_product_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_product_seq")
    @JsonProperty("ردیف")
    private Long id;

    @Column(name = "quantity")
    @JsonProperty("تعداد کالا")
//    @NotNull(message = "تعداد کالا را وارد نکرده اید!!")
    private Double quantity;

    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "product", foreignKey = @ForeignKey(name="fk-product"))
    @JsonProperty("کالا")
//    @NotNull(message = "کالا را وارد نکرده اید!!")
    private Product product;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "inventory_product_transaction",
            joinColumns = @JoinColumn(name = "inventory_transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_product_id"))
//    @JoinColumn(name=("inv_transaction_inv_product"), foreignKey = @ForeignKey(name="fk-inv_transaction_inv_product"))
    @JsonProperty("تراکنش های انبار")
    //    @NotNull(message = "تراکنش های انبار را وارد نکرده اید !!")
    private List<InventoryTransaction> inventoryTransaction;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "inventory_product_inventory",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_product_id"))
//    @JoinColumn(name = ("inv_transaction_inv_product"),foreignKey = @ForeignKey(name = "fk-inventory_inventory_product"))
    @JsonProperty("انبار ها")
    private List<Inventory> inventory;
}
