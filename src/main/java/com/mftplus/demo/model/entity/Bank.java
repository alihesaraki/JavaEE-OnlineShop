package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

@Entity(name = "bankEntity")
@Table(name = "bank_tbl")
public class Bank {

    @Id
    @SequenceGenerator(name = "bankSeq", sequenceName = "bank_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bankSeq")
    @JsonProperty("Bank ID")
    private Long id;

    @Column(name = "bank_name", length = 50 )//nullable = false
//    @NotNull(message = "Bank name is required!")
//    @Pattern(regexp = "^[A-Za-z\\s]{3,50}$", message = "Invalid bank name!")
    @JsonProperty("Bank Name")
    private String name;

    @Column(name = "account_number", length = 20, unique = true)//nullable = false
//    @NotNull(message = "Account number is required!")
//    @Pattern(regexp = "^[0-9]{10,20}$", message = "Invalid account number!")
    @JsonProperty("Account Number")
    private String accountNumber;

    @Column(name = "branch_code", length = 10)//nullable = false
//    @NotNull(message = "Branch code is required!")
    @JsonProperty("Branch Code")
    private Long branchCode;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
}
