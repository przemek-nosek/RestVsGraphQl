package pl.java.restgraphqlcomparison.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String contactFirstName;
    private String contactLastName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String creditLimit;// wydajnosc zapisu + odczytu
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Payment> payments;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Order> orders;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Cart cart;
}
