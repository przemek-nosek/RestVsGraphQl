package pl.java.restgraphqlcomparison.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String line;
    private String scale;
    private String vendor;
    private String description;
    private BigDecimal buyPrice;
    private BigDecimal priceEach;
    private int quantityOrdered;
    private int quantityInStock;
    @ManyToMany
    @JoinTable
    private Set<Order> orders;
}
