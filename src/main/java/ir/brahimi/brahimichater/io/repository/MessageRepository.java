package ir.brahimi.brahimichater.io.repository;

import ir.brahimi.brahimichater.io.entity.MessageEntity;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Long> {
    MessageEntity findAllBySender(UserDto sender);
}
