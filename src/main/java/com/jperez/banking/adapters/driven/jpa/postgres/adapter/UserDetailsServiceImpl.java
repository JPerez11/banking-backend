package com.jperez.banking.adapters.driven.jpa.postgres.adapter;

import com.jperez.banking.adapters.driven.jpa.postgres.entities.UserEntity;
import com.jperez.banking.adapters.driven.jpa.postgres.exceptions.LoadUserException;
import com.jperez.banking.adapters.driven.jpa.postgres.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findUserEntityByEmail(email).orElse(null);
        if (user == null) {
            throw new LoadUserException();
        }
        return new UserDetailsImpl(user);
    }

}
