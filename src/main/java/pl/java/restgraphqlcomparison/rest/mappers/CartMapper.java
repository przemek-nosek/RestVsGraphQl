package pl.java.restgraphqlcomparison.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import pl.java.restgraphqlcomparison.common.entities.Cart;
import pl.java.restgraphqlcomparison.rest.dtos.CartDto;
import pl.java.restgraphqlcomparison.rest.dtos.CartResponseDto;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartDto toCartDto(Cart cart);
    Cart toCart(CartDto cartDto);
    Cart updateCart(CartDto cartDto, @MappingTarget Cart cart);

    @Mapping(target = "contactFirstName", source = "cart.customer.contactFirstName")
    @Mapping(target = "phone", source = "cart.customer.phone")
    CartResponseDto toCartResponseDto(Cart cart);
}
