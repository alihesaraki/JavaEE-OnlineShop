package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mftplus.demo.model.entity.enums.PaymentMethod;
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

@Entity(name = "paymentEntity")
@Table(name = "payment_tbl")
public class Payment {

    @Id
    @SequenceGenerator(name = "paymentSeq", sequenceName = "payment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentSeq")
    @JsonProperty("Payment ID")
    private Long id;

    @Column(name = "doc_number", nullable = false, unique = true)
    @NotNull(message = "Document number is required!")
    @JsonProperty("Document Number")
    private Long docNumber;

    @Column(name = "payment_date", nullable = false)
    @NotNull(message = "Payment date is required!")
    @JsonProperty("Payment Date")
    private LocalDate date;

    @Column(name = "description", length = 255)
    @JsonProperty("Description")
    private String description;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transaction transaction;
}
