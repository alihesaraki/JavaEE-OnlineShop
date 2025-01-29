package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "productEntity")
@Table(name = "product_tbl")


public class Product extends Base {
    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    private Long id;

    @Column(name = "name", length = 30) //todo nullable...
//  @Pattern(regexp = "^[a-zA-Z]{3,30}$",message = "invalid name!")
    private String name;

    @Column(name = "price", length = 30)
//    @Pattern(regexp = "^[0-9]{2,30}$",message = "invalid price")
    @Min(value = 0, message = "Cant be negative")
    private Float price;

    @Column(name = "product_code")
    private Long code;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "p_group")
    private ProductGroup productGroup;

}
