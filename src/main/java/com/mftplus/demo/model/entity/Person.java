package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.demo.model.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "personEntity")
@Table(name = "person_tbl")

public class Person extends Base {

    @Id
    @SequenceGenerator(name = "personSeq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personSeq")
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "person_firstName", length = 30)
//    @Pattern(regexp = "^[a-zA-Z]{2,30}$", message = "invalid name !")
    @JsonProperty("نام :") //todo --> not work!
    private String name;

    @Column(name = "person_lastName", length = 40)
//    @Pattern(regexp = "^[a-zA-Z]{2,40}$", message = "invalid family")
    @JsonProperty("نام خانوادگی :")
    private String family;

    @Column(name = "person_national_id", length = 10)
//    @Pattern(regexp = "^[0-9]{3,10}$", message = "invalid national id !")
    @JsonProperty("کد ملی :")
    private String nationalId;

    @Column(name = "person_birth_date")
    @JsonProperty("تاریخ تولد :")
    private LocalDate birthDate;

    @Column(name = "person_phone_number", length = 13)
//    @Pattern(regexp = "^[0-9]{3,13}$", message = "invalid phone number !")
    @JsonProperty("شماره تماس :")
    private String phoneNumber;

    @Column(name = "person_address", length = 200)
//    @Pattern(regexp = "^[a-zA-Z\\s]{5,200}$", message = "invalid address text !")
    @JsonProperty("ادرس :")
    private String address;

    @Column(name = "person_postal_code", length = 30)
//    @Pattern(regexp = "^[0-9]{1,30}$", message = "invalid postalCode !")
    @JsonProperty("کد پستی :")
    private String postalCode;

    @Column(name = "person_gender")
    @Enumerated(EnumType.ORDINAL)
    @JsonProperty("جنسیت :")
    private Gender gender;


    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "person_users", foreignKey = @ForeignKey(name = "user_fk"))
    @JsonProperty("اطلاعات کاربر :")
    private User user;

}


