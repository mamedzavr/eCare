package com.telekom.ecare.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "option")
@Entity
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
}