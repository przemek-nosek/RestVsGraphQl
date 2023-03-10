package pl.java.restgraphqlcomparison.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class CartResponseDto {
    private final long id;
    private final int totalItems;
    private final BigDecimal totalPrice;
    private final String discountCode;
    private final String contactFirstName;
    private final String phone;
}
