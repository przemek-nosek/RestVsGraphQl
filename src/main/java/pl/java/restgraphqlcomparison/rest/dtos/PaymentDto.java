package pl.java.restgraphqlcomparison.rest.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
public class PaymentDto {
    private final long id;
    private final LocalDate paymentDate;
    private final BigDecimal amount;
}
