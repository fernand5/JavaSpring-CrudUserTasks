package com.boraji.tutorial.spring.model;

public class Fila {
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    private Task task;
    private Integer duration;
}
