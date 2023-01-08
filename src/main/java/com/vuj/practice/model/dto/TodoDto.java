package com.vuj.practice.model.dto;

import com.vuj.practice.model.User;

import java.time.LocalDate;

public class TodoDto {
    private Integer id;
    private Integer ownerId;
    private String title;
    private LocalDate deadline;
    private String description;
    private Boolean isItDone;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsItDone() {
        return isItDone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsItDone(Boolean isItDone) {
        this.isItDone = isItDone;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
