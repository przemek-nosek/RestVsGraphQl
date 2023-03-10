package pl.java.restgraphqlcomparison.rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.restgraphqlcomparison.common.entities.Cart;
import pl.java.restgraphqlcomparison.common.entities.Customer;
import pl.java.restgraphqlcomparison.rest.dtos.CartDto;
import pl.java.restgraphqlcomparison.rest.dtos.CartResponseDto;
import pl.java.restgraphqlcomparison.rest.mappers.CartMapper;
import pl.java.restgraphqlcomparison.common.repositories.CartRepository;
import pl.java.restgraphqlcomparison.common.repositories.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CustomerRepository customerRepository;


    public CartDto getCart(long cartId) {
        return cartRepository.findById(cartId)
                .map(cartMapper::toCartDto)
                .orElseThrow();
    }
    @Transactional
    public void deleteCart(long cartId) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart does not exist.");
        }
        cartRepository.deleteById(cartId);
    }

    @Transactional
    public void createCart(long customerId, CartDto cartDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow();
        Cart entity = cartMapper.toCart(cartDto);
        entity.setCustomer(customer);
        cartRepository.save(entity);
    }

    @Transactional
    public void updateCart(long cartId, CartDto cartDto) {
        if (!cartRepository.existsById(cartId)) {
            throw new RuntimeException("Cart does not exist.");
        }
        Cart cart = cartRepository.getReferenceById(cartId);
        cartRepository.save(cartMapper.updateCart(cartDto, cart));
    }

    public CartResponseDto getCartWithCustomerName(long cartId) {
        return cartRepository.findById(cartId)
                .map(cartMapper::toCartResponseDto)
                .orElseThrow();
    }
}
