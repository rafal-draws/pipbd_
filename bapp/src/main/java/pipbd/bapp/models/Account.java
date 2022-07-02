package pipbd.bapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "clientid") // JOIN .... CLIENT_ID
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Client clientId;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "percentagespan")
    private int percentagespan;

    @Column(name = "percentagedate")
    private String percentagedate;

}
