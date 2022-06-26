package pipbd.bapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pipbd.bapp.models.A2ATransaction;
import pipbd.bapp.models.dto.A2ATransactionDTO;

public interface A2ATransactionRepository extends JpaRepository<A2ATransaction, Long> {
}
