package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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

@Entity(name = "ticketEntity")
@Table(name = "ticket_tbl")

public class Ticket extends Base {
    @Id
    @SequenceGenerator(name = "ticketSeq", sequenceName = "ticketSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketSeq")
    private Long id;

    @Column(name = "title")
    @JsonProperty("مضوع :")
    private String title;

    @Column(name = "text")
    @JsonProperty("متن :")
    private String text;

    @Column(name = "date_time")
    @JsonProperty("تاریخ و ساعت :")
    private String dateTime;

    @Column(name = "resp_status")
    @JsonProperty("موقعیت درخواست :")
    private String responseType;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Message> messages = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private TicketGroup ticketGroup;

}
