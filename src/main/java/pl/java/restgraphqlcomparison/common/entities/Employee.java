package pl.java.restgraphqlcomparison.common.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String jobTitle;
    @OneToMany(mappedBy = "employee")
    private List<Customer> customers;
}
