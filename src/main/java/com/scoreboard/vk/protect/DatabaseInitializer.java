package com.scoreboard.vk.protect;

import com.scoreboard.vk.protect.models.Category;
import com.scoreboard.vk.protect.models.Rating;
import com.scoreboard.vk.protect.models.Role;
import com.scoreboard.vk.protect.models.User;
import com.scoreboard.vk.protect.repos.CategoryRepository;
import com.scoreboard.vk.protect.repos.RatingRepository;
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
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public void run(ApplicationArguments args){
        if(userRepository.findByUsername("user1") == null && userRepository.findByUsername("admin") == null){
            User user1 = new User("user","user",Collections.singleton(Role.USER));
            User user2 = new User("admin","admin",Collections.singleton(Role.ADMIN));
            User user3 = new User("user1","user",Collections.singleton(Role.USER));
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            Category category1 = new Category("Кибербезопасность", 43L);
            Category category2 = new Category("Политики безопасности", 20L);
            Category category3 = new Category("Безопасность ОП", 35L);
            categoryRepository.save(category1);
            categoryRepository.save(category2);
            categoryRepository.save(category3);

            ratingRepository.save(new Rating(user1,category1,12L));
            ratingRepository.save(new Rating(user1,category2,14L));
            ratingRepository.save(new Rating(user1,category3,20L));

            ratingRepository.save(new Rating(user2,category1,21L));
            ratingRepository.save(new Rating(user2,category2,4L));
            ratingRepository.save(new Rating(user2,category3,25L));

            ratingRepository.save(new Rating(user2,category1,30L));
            ratingRepository.save(new Rating(user3,category2,1L));
            ratingRepository.save(new Rating(user3,category3,30L));
        }
    }
}
