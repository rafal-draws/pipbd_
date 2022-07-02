package pipbd.bapp.models.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class A2ATransactionDTO {
    private long senderacc;
    private long getteracc;
    private BigDecimal amount;
}
