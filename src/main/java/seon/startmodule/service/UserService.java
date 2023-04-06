package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seon.startmodule.domain.UserS;
import seon.startmodule.dto.UserDTO;
import seon.startmodule.mapper.UserMapper;
import seon.startmodule.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserS> getList() {
        return repository.findAll();
    }
    public Optional<UserS> getDuplicatedId(String id) {
        return repository.findById(id);
    }
    public UserS getOne(Long seq) {
        return repository.findBySeq(seq);
    }

    public void join (String id, String name, String password, String role, LocalDateTime createDate) {
        UserS userS = UserS.createUser(id, name, password, passwordEncoder, role, createDate);
        validateDuplicateMember(userS);
        repository.save(userS);
    }

    public void save (UserDTO dto) {
        LocalDateTime now = LocalDateTime.now();
        UserS userS = UserS.createUser(dto.getId(), dto.getName(), dto.getPassword(), passwordEncoder, dto.getRole(), now);
        validateDuplicateMember(userS);
        repository.save(userS);
    }

    private void validateDuplicateMember(UserS userS) {
        repository.findById(userS.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public void modify(UserS userS) {
        repository.save(userS);
    }
    public void delete(Long seq){
        repository.deleteById(seq);
    }
}
