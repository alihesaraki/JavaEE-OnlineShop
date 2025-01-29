package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

@Entity(name = "transactionEntity")
@Table(name = "transaction_tbl")
public class Transaction {

    @Id
    @SequenceGenerator(name = "transactionSeq", sequenceName = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSeq")
    @JsonProperty("Transaction ID")
    private Long id;

    @Column(name = "tracking_code", nullable = false, unique = true)
    @NotNull(message = "Tracking code is required!")
    @JsonProperty("Tracking Code")
    private Long trackingCode;

    @Column(name = "transaction_date", nullable = false)
    @NotNull(message = "Transaction date is required!")
    @JsonProperty("Transaction Date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

    @OneToOne(mappedBy = "transaction", cascade = CascadeType.ALL)
    private Payment payment;
}
