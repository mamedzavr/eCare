package com.telekom.ecare.domain;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
@Table(name = "tariffs")
public class Tariff implements Serializable {
    private static final long serialVersionUID = -3290731289966372035L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price = 0L;

    @ManyToMany
    @JoinTable(
            name = "tariffs_options",
            joinColumns = {@JoinColumn(name = "tariff_id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id")}
    )
    private Set<Option> options = new HashSet<>();

    @OneToMany(mappedBy = "tariff")
    private Set<Contract> contracts;

    public Tariff(Tariff tariff) {
        this.id = tariff.getId();
        this.name = tariff.getName();
        this.price = tariff.getPrice();
        this.options = tariff.getOptions();
        this.contracts = tariff.getContracts();
    }
}