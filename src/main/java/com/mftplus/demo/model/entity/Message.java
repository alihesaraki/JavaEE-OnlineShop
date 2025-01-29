package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString


@Entity(name = "messageEntity")
@Table(name = "message_tbl")
public class Message extends Base {
    @Id
    @SequenceGenerator(name = "messageSeq", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageSeq")
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "text", length = 254)
    @JsonProperty("متن :")
    private String text;

    @Column(name = "title")
    @JsonProperty("مضوع :")
    private String title;

    @Column(name = "date_time")
    @JsonProperty("تاریخ و ساعت :")
    private String dateTime;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_message")
    private User user;


}
