package pipbd.bapp.models.dto;

import lombok.Getter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
public class A2ATransactionDTO {
    private long senderacc;
    private long getteracc;
    private BigInteger amount;
    private Timestamp date;
}
