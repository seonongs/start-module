package seon.startmodule.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seon.startmodule.domain.Users;
import seon.startmodule.domain.Users;
import seon.startmodule.dto.UsersDTO;
import seon.startmodule.dto.UsersDTO;
import seon.startmodule.mapper.UsersMapper;
import seon.startmodule.repository.UsersRepository;
import seon.startmodule.repository.UsersRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class UsersService {
    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public Optional<Users> findOne(long seq) {
        return usersRepository.findBySeq(seq);
    }

    public void join (String id, String name, String password, String role) {
        Users users = Users.createUser(id, name, password, passwordEncoder);
        usersRepository.save(users);
    }

    public List<UsersDTO> getUsersList() {
        return usersMapper.getUsersList();
    }

}
