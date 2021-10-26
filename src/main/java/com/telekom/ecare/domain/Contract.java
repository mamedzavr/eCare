package com.telekom.ecare.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")
public class Contract implements Serializable {
    private static final long serialVersionUID = 2054280091877928379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", unique = true)
    private Long number;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToMany(mappedBy = "contracts")
    private Set<Option> options = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "blocked_by_client")
    private boolean blockedByClient = false;

    @Column(name = "blocked_by_admin")
    private boolean blockedByAdmin = false;
}