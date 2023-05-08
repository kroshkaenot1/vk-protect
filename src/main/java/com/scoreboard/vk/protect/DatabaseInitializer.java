package com.scoreboard.vk.protect;

import com.scoreboard.vk.protect.models.Role;
import com.scoreboard.vk.protect.models.User;
import com.scoreboard.vk.protect.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DatabaseInitializer implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(userRepository.findByUsername("user1") == null && userRepository.findByUsername("admin") == null){
            User user1 = new User();
            user1.setEnabled(true);
            user1.setUsername("user1");
            user1.setPassword("coolUser");
            user1.setRoles(Collections.singleton(Role.USER));

            User user2 = new User();
            user2.setEnabled(true);
            user2.setUsername("admin");
            user2.setPassword("root");
            user2.setRoles(Collections.singleton(Role.ADMIN));

            userRepository.save(user1);
            userRepository.save(user2);
        }
    }
}
