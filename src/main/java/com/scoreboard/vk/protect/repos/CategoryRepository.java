package com.scoreboard.vk.protect.repos;

import com.scoreboard.vk.protect.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
}
