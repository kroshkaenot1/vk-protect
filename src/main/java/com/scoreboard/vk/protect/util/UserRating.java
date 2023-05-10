package com.scoreboard.vk.protect.util;

public class UserRating {
    private String categoryName;
    private Long completedTasks;
    private Long countOfTasks;
    private int position;
    private int countOfUsers;

    public UserRating(String categoryName, Long completedTasks, Long countOfTasks, int position, int countOfUsers) {
        this.categoryName = categoryName;
        this.completedTasks = completedTasks;
        this.countOfTasks = countOfTasks;
        this.position = position;
        this.countOfUsers = countOfUsers;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(Long completedTasks) {
        this.completedTasks = completedTasks;
    }

    public Long getCountOfTasks() {
        return countOfTasks;
    }

    public void setCountOfTasks(Long countOfTasks) {
        this.countOfTasks = countOfTasks;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int rating) {
        this.position = rating;
    }

    public int getCountOfUsers() {
        return countOfUsers;
    }

    public void setCountOfUsers(int countOfUsers) {
        this.countOfUsers = countOfUsers;
    }
}
