package securitytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import securitytest.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
