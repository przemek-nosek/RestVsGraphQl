package pl.java.restgraphqlcomparison.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.java.restgraphqlcomparison.common.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
