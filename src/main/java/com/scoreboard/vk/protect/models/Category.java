package com.scoreboard.vk.protect.models;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private Long count_of_tasks;

    public Category() {
    }

    public Category(String name, Long count_of_tasks) {
        this.name = name;
        this.count_of_tasks = count_of_tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount_of_tasks() {
        return count_of_tasks;
    }

    public void setCount_of_tasks(Long count_of_tasks) {
        this.count_of_tasks = count_of_tasks;
    }
}
