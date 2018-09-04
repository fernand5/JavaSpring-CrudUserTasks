package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.Task;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.model.UserTask;

import java.util.List;

public interface UserDao {

   long save(User user);

   User get(long id);

   List<User> list();

   void update(long id, User user);

   void addTask(long id, Task task);

   void delete(long id);

}
