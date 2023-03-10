package pl.java.restgraphqlcomparison.graphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.restgraphqlcomparison.rest.dtos.CartDto;
import pl.java.restgraphqlcomparison.rest.services.CartService;

@RestController
@RequiredArgsConstructor
public class CartGraphQlController {

    private final CartService cartService;

    @QueryMapping
    public CartDto getCart(@Argument long id) { //getCartWithCustomerName
        return cartService.getCart(id);
    }

    @MutationMapping
    public long deleteCart(@Argument long id) {
        cartService.deleteCart(id);
        return id;
    }

    @MutationMapping
    public long createCart(@Argument long customerId, @Argument CartDto cartDto) {
        cartService.createCart(customerId, cartDto);
        return customerId;
    }

    @MutationMapping
    public long updateCart(@Argument long cartId, @Argument CartDto cartDto) {
        cartService.updateCart(cartId, cartDto);
        return cartId;
    }
}
