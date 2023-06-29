package com.jperez.banking.adapters.driven.jpa.sqlserver.adapter;

import com.jperez.banking.adapters.driven.jpa.sqlserver.entities.UserEntity;
import com.jperez.banking.adapters.driven.jpa.sqlserver.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByEmail(email).orElse(null);
        if (user == null) {
            //TODO create custom exception
        }
        return new UserDetailsImpl(user);
    }
}
