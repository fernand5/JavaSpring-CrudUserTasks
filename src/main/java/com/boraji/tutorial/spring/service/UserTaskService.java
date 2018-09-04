package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.Task;
import com.boraji.tutorial.spring.model.UserTask;

import java.util.List;

public interface UserTaskService {

   UserTask save(UserTask userTask);
   UserTask get(long id);
   List<UserTask> list();
   void update(long id, UserTask userTask);
   void delete(long id);
}
