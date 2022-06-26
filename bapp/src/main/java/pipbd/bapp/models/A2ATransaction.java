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

    @JoinColumn(name = "senderacc")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Client senderacc;

    @JoinColumn(name = "getteracc")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Client getteracc;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "date")
    private Timestamp date;

}
