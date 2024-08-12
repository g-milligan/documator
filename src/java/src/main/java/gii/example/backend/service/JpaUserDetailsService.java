package gii.example.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gii.example.backend.entity.SecurityUser;
import gii.example.backend.entity.UserEntity;
import gii.example.backend.repo.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepo.findByUserEmail(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("Username was not found: %s", username));
        }
        // need to prepend the password with {noop} since it's not encrypted
        // otherwise, login won't work... this is just a local dev workaround that would not be used in production
        user.get().setUserPwd("{noop}" + user.get().getUserPwd());

        return new SecurityUser(user.get());
    }
    
}
