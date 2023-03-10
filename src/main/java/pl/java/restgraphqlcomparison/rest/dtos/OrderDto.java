package pl.java.restgraphqlcomparison.rest.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class OrderDto {
    private final long id;
    private final LocalDate orderDate;
    private final LocalDate requiredDate;
    private final LocalDate shippedDate;
    private final boolean status;
    private final String comment;
}
