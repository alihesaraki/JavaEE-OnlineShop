package com.mftplus.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString


@Entity(name = "groupProEntity")
@Table(name = "group_properties")
public class GroupProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    private Product product;

//    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
//    private ProductGroup productGroup; // Todo

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "value")
    private ProductPropertyValue productPropertyValue;
}
