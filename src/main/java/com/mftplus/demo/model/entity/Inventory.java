package com.mftplus.demo.model.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "inventoryEntity")
@Table(name = "inventory_table")

public class Inventory extends Base {

    @Id
    @SequenceGenerator(name = "inventory_seq", sequenceName = ("inventory_seq"), allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_seq")
    @JsonProperty("ردیف")
    private Long id;

//    @Pattern(regexp = "^[a-zA-Z\\s]{3,30}$",message = "نام اشتباه است!!")
    @Column(name = "title", length = 30)
//    @NotNull(message = "نام انبار را وارد نکرده اید!!")
    @JsonProperty("نام")
    private String title;

//    @Pattern(regexp = "^[a-zA-Z0-9]{3,300}$",message = "آدرس اشتباه است!!")
    @Column(name = "address", length = 200)
//    @NotNull(message = "آدرس را وارد نکرده اید!!")
    @JsonProperty("آدرس")
    private String address;

//    @Pattern(regexp = "^[0-9]{3,13}$",message = "شماره تماس اشتباه است!!")
    @Column(name = "phone", length = 13)
//    @NotNull(message = "شماره تماس را وارد نکرده اید!!")
    @JsonProperty("شماره تماس")
    private String phone;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH} , fetch = FetchType.EAGER)
    @JoinColumn(name = "inventoryProduct_inventory", foreignKey = @ForeignKey(name="fk_inventory_product"))
    @JsonProperty("کالا های انبار")
    private InventoryProduct inventoryProduct;





}
