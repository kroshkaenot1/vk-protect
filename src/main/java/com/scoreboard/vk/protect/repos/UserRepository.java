package com.scoreboard.vk.protect.repos;

import com.scoreboard.vk.protect.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    @Query("SELECT COUNT(*) FROM User u")
    int findCountOfUsers();
}
