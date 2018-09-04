package com.boraji.tutorial.spring.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserTaskId implements Serializable {
    int user;
    int task;
}
