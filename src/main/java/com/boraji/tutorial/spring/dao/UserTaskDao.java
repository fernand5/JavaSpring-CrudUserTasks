package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.UserTask;

import java.util.List;

public interface UserTaskDao {

   UserTask save(UserTask userTask);

   UserTask get(long id);

   List<UserTask> list();

   void update(long id, UserTask userTask);

   void delete(long id);

}
