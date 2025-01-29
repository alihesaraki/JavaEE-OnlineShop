package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
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

@Entity(name = "productGroupEntity")
@Table(name = "productGroup_tbl")


public class ProductGroup extends Base {
    @Id
    @SequenceGenerator(name = "productGroupSeq", sequenceName = "productGroup_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productGroupSeq")
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
//    @Pattern(regexp = "^[a-zA-Z]{3,30}$", message = "invalid name!")
    private String name;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "productGroup-child")
    private List<ProductGroup> childList=new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private ProductGroup parent;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private GroupProperty groupProperty;




}


