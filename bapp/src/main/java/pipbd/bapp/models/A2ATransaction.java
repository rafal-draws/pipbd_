package pipbd.bapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "a2atransactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class A2ATransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "senderacc")
    private Long senderacc;

    @Column(name = "getteracc")
    private Long getteracc;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "finished")
    private boolean finished;

    @Column(name = "date")
    private Timestamp date;

}
