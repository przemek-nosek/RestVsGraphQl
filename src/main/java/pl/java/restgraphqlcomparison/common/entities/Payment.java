package pl.java.restgraphqlcomparison.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate paymentDate;
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
