package com.telekom.ecare.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "options")
public class Option implements Serializable {
    private static final long serialVersionUID = -7331079906375020901L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "connection_price")
    private Long connectionPrice;

    @ManyToMany
    @JoinTable(
            name = "contracts_options",
            joinColumns = {@JoinColumn(name = "contract_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")}
    )
    private Set<Contract> contracts = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "incompatible_options",
            joinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "incompatible_option_id", referencedColumnName = "id")}
    )
    private Set<Option> incompatibleOptions = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "dependent_options",
            joinColumns = {@JoinColumn(name = "option_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "dependent_option_id", referencedColumnName = "id")}
    )
    private Set<Option> dependentOptions = new HashSet<>();
}