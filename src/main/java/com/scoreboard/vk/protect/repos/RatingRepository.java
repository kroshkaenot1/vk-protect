package com.scoreboard.vk.protect.repos;

import com.scoreboard.vk.protect.models.Category;
import com.scoreboard.vk.protect.models.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {
    List<Rating> findAllByUserId(Long id);
    @Query("SELECT COUNT(*) FROM Rating r WHERE r.completed_tasks > ?1 AND r.category = ?2")
    int findPos(Long completed_tasks, Category category);
}
