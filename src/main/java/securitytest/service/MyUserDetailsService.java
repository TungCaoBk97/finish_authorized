package securitytest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import securitytest.model.Role;
import securitytest.model.User;
import securitytest.repository.UserRepository;

import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User 404");
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                getAuthorities(user));
    }

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        User user = repo.findByUsername(userName)
//                .orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//                getAuthorities(user));
//    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = repo.getRoles(user).stream().map(Role::getName).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
