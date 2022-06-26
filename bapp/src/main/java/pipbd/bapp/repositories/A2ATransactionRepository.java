package pipbd.bapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pipbd.bapp.models.dto.A2ATransactionDTO;

public interface A2ATransactionRepository extends JpaRepository<A2ATransactionDTO, Long> {
}
