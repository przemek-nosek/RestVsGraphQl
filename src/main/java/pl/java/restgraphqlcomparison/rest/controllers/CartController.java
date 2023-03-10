package pl.java.restgraphqlcomparison.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.java.restgraphqlcomparison.rest.dtos.CartDto;
import pl.java.restgraphqlcomparison.rest.dtos.CartResponseDto;
import pl.java.restgraphqlcomparison.rest.services.CartService;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{cartId}")
    public CartDto getCart(@PathVariable long cartId) {
        return cartService.getCart(cartId);
    }

    @GetMapping("/{cartId}/customer")
    public CartResponseDto getCartWithCustomerName(@PathVariable long cartId) {
        return cartService.getCartWithCustomerName(cartId);
    }

    @DeleteMapping("{cartId}")
    public void deleteCart(@PathVariable long cartId) {
        cartService.deleteCart(cartId);
    }

    @PostMapping("/customer/{customerId}")
    private void createCart(@RequestBody CartDto cartDto, @PathVariable long customerId) {
        cartService.createCart(customerId, cartDto);
    }

    @PutMapping("/{cartId}")
    private void updateCart(@PathVariable long cartId, @RequestBody CartDto cartDto) {
        cartService.updateCart(cartId, cartDto);
    }
}
