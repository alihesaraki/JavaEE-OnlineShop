package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "roleEntity")
@Table(name = "role_tbl")

public class Role extends Base {
    @Id
    @SequenceGenerator(name = "roleSeq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSeq")
    @Column(name = "role_id", length = 22)
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "role_name", length = 20)
//    @Pattern(regexp = "^[a-zA-Z\\d\\s]{2,20}$", message = "Invalid role name")
    @NotBlank(message = "RoleName cant be Empty!")
    @JsonProperty("نقش کاربر :")
    private String roleName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission")
    private Set<Permission> permissionSet;


//    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JoinColumn(name = "role_Owner")
//    private User user;

}
