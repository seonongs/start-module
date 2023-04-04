package seon.startmodule.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import seon.startmodule.domain.Member;
import seon.startmodule.service.MemberService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        Optional<Member> findOne = memberService.findOne(insertedUserId);
        Member member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));

        return User.builder()
                .username(member.getUserid())
                .password(member.getPw())
                .roles(member.getRoles())
                .build();
    }
}
