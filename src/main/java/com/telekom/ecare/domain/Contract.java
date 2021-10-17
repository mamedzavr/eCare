package com.telekom.ecare.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contracts")
public class Contract implements Serializable {
    private static final long serialVersionUID = 2054280091877928379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

    @ManyToMany
    private Set<Option> options = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "blocked_by_client")
    private boolean blockedByClient = false;

    @Column(name = "blocked_by_admin")
    private boolean blockedByAdmin = false;
}