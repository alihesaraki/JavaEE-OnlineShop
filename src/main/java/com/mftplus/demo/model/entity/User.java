package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

@Entity(name = "userEntity")
@Table(name = "user_tbl")

public class User extends Base {
    @Id
    @JsonProperty(" : ردیف")
    @SequenceGenerator(name = "userSeq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name = "user_id", length = 19)
    private Long id;


    @Column(name = "username", length = 30, unique = true)
//    @Pattern(regexp = "^[a-zA-Z\\d\\s]{2,20}$", message = "Invalid Username")
    @NotBlank(message = "Username cant be Empty!")
    @JsonProperty(" : نام کاربری")
    private String username;


    @Column(name = "password", length = 30)
    @NotBlank(message = "Password cant be Empty")
//    @Pattern(regexp = "^[a-zA-Z\\d\\s]{2,20}$", message = "Invalid password")
    @JsonProperty(": رمز عبور")
//    @JsonbTransient
    private String password;

    @Column(name = "user_email", length = 30, unique = true)
//    @Pattern(regexp = "^[a-zA-Z\\d\\s]{8,50}$", message = "Invalid Email")
    @JsonProperty(": ایمیل")
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    @JsonProperty(": عنوان کاربر")
    private List<Role> roleList;

}
