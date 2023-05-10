package com.scoreboard.vk.protect.services;

import com.scoreboard.vk.protect.models.Rating;
import com.scoreboard.vk.protect.models.User;
import com.scoreboard.vk.protect.repos.RatingRepository;
import com.scoreboard.vk.protect.repos.UserRepository;
import com.scoreboard.vk.protect.util.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RatingRepository ratingRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public List<UserRating> getProgress(String username){
        List<UserRating> userRatings = new LinkedList<>();
        User user = userRepository.findByUsername(username);
        int countOfUsers = userRepository.findCountOfUsers();
        List<Rating> ratingList = ratingRepository.findAllByUserId(user.getId());
        for(Rating rating: ratingList){
            int position = ratingRepository.findPos(rating.getCompleted_tasks(),rating.getCategory()) + 1;
            userRatings.add(new UserRating(rating.getCategory().getName(),rating.getCompleted_tasks()
                    ,rating.getCategory().getCount_of_tasks(),position,countOfUsers));
        }
        return userRatings;
    }
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
