package seon.startmodule.config;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import seon.startmodule.domain.UserS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import seon.startmodule.service.UserService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final UserService service;

    private final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Optional<UserS> findOne = service.getDuplicatedId(id);
        UserS userS = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(userS.getId())
                .password(userS.getPassword())
                .roles(userS.getRole())
                .build();
    }
}
