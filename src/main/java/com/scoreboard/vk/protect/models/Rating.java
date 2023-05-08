package com.scoreboard.vk.protect.models;

import javax.persistence.*;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "category_id",referencedColumnName = "id",nullable = false)
    private Category category;

    @Column(nullable = false)
    private Long completed_tasks;

    public Rating() {
    }

    public Rating(User user, Category category, Long completed_tasks) {
        this.user = user;
        this.category = category;
        this.completed_tasks = completed_tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getCompleted_tasks() {
        return completed_tasks;
    }

    public void setCompleted_tasks(Long completed_tasks) {
        this.completed_tasks = completed_tasks;
    }
}
