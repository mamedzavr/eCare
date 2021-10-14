package com.telekom.ecare.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "contract")
@Entity
public class Contract implements Serializable {
    private static final long serialVersionUID = 2054280091877928379L;

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}