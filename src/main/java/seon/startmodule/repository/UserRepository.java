package seon.startmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seon.startmodule.domain.UserS;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserS, Long> {
    List<UserS> findAll();
    Optional<UserS> findById(String id);
    UserS findBySeq(Long seq);

}
