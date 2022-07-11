/*
 * A service to manage user authentication
 */

package com.bankapp.bankapp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.bankapp.models.AuthUserDetails;
import com.bankapp.bankapp.models.User;
import com.bankapp.bankapp.repositaries.UserRepo;
import com.bankapp.bankapp.repositaries.UserRepoEmail;

//annotate to specify this class is to be used as a service
@Service
public class AuthUserDetailsService implements UserDetailsService {

	//instantiation of the userRepo object in order to verify user details
//    @Autowired
//    UserRepo userRepository;

    @Autowired
    UserRepoEmail eRepo;

    
	//functional method that are used by the controller
    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Optional<User> user = eRepo.findByUserEmail(Email);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + Email));

        return user.map(AuthUserDetails::new).get();
    }
}

