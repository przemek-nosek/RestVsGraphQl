package pl.java.restgraphqlcomparison.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate orderDate;
    private LocalDate requiredDate;
    private LocalDate shippedDate;
    private boolean status;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToMany(mappedBy = "orders")
    private Set<Product> products;
}
