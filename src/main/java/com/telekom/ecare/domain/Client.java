package com.telekom.ecare.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client implements Serializable {
    private static final long serialVersionUID = 7823233339636262585L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport")
    private String passport;

    @Column(name = "adress")
    private String adress;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "client")
    private Set<Contract> contracts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "clients_roles",
            joinColumns = {@JoinColumn(name = "client_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    public Client(Client client) {
        this.id = client.getId();
        this.email = client.getEmail();
        this.password = client.getPassword();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.passport = client.getPassport();
        this.adress = client.getAdress();
        this.birthDate = client.getBirthDate();
        this.contracts = client.getContracts();
        this.roles = client.getRoles();
    }
}
