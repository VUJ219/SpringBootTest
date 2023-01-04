package com.vuj.practice.model.dto;

import java.time.LocalDate;

public class TodoDto {
    private Integer id;
    private String title;
    private LocalDate deadline;
    private String description;
    private Boolean IsItDone;

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

    public Boolean getItDone() {
        return IsItDone;
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

    public void setItDone(Boolean itDone) {
        IsItDone = itDone;
    }
}