package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * Created by piotr on 18.02.16.
 */
@Service
class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    public UserRepository userRepository;
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findUserByUsername(username);

        if(u==null){
            throw new UsernameNotFoundException("Username not found"+username)
        }
        List<GrantedAuthority> authorities = new ArrayList<>()
        authorities.add(new SimpleGrantedAuthority("USER"))

        new org.springframework.security.core.userdetails.User(username,u.getPassword(),authorities)
    }
}
