package com.telekom.ecare.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 2054280091877928379L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number")
    private Long number;

    @JoinColumn(name = "tariff_ID")
    @ManyToOne
    private Tariff tariff;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}