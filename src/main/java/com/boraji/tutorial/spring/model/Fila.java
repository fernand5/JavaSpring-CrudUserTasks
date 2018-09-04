package com.boraji.tutorial.spring.model;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

@Embeddable
public class Fila {
    private Task task;
    private Integer duration;

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


}
