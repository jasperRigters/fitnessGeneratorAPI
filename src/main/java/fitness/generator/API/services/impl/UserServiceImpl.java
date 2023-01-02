package fitness.generator.API.services.impl;

import fitness.generator.API.repositories.UserRepository;
import fitness.generator.API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

 private final UserRepository userRepository;

 @Autowired
    public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }


}

