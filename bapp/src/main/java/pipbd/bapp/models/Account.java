package pipbd.bapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @JoinColumn(name = "clientid")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Client clientId;

    @Column(name = "balance")
    private Float balance;

    @Column(name = "percentage")
    private int percentage;

    @Column(name = "percentagespan")
    private int percentagespan;

    @Column(name = "percentagedate")
    private String percentagedate;

}
