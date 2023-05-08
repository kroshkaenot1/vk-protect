package com.scoreboard.vk.protect.services;

import com.scoreboard.vk.protect.models.Rating;
import com.scoreboard.vk.protect.models.User;
import com.scoreboard.vk.protect.repos.RatingRepository;
import com.scoreboard.vk.protect.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Map<String,String>> getProgress(String username){
        Map<String,Map<String,String>> result = new HashMap<>();

        Map<String, String> generalScore = new HashMap<>();
        Map<String, String> comparativeScore = new HashMap<>();
        int countOfUsers = userRepository.findCountOfUsers();
        User user = userRepository.findByUsername(username);
        List<Rating> ratingList = ratingRepository.findAllByUserId(user.getId());

        for(Rating rating: ratingList){
            String score = String.format("%s/%s%n",rating.getCompleted_tasks(),rating.getCategory().getCount_of_tasks());
            generalScore.put(rating.getCategory().getName(),score);

            int position = ratingRepository.findPos(rating.getCompleted_tasks(),rating.getCategory()) + 1;
            String compScore = String.format("%s/%s%n",position,countOfUsers);
            comparativeScore.put(rating.getCategory().getName(),compScore);
        }
        result.put("Рейтинг по отношению к общему количеству задач",generalScore);
        result.put("Рейтинг среди сотрудников",comparativeScore);
        return result;
    }
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
