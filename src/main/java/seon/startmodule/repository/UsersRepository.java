package seon.startmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seon.startmodule.domain.Users;
import seon.startmodule.domain.Users;
import seon.startmodule.dto.UsersDTO;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findById(String id);
    Optional<Users> findBySeq(long seq);
    List<Users> findAll();

}
