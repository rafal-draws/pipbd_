package pipbd.bapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pipbd.bapp.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
