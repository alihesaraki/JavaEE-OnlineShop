package com.mftplus.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
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

@Entity(name = "tGroupEntity")
@Table(name = "ticketGroup_tbl")
public class TicketGroup extends Base {
    @Id
    @SequenceGenerator(name = "groupSeq", sequenceName = "ticketGroup_Seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groupSeq")
    @JsonProperty("ردیف :")
    private Long id;

    @Column(name = "g_name")
    @JsonProperty("نام :")
    private String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonbTransient
    private List<TicketGroup> childList;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private TicketGroup parent;

}
