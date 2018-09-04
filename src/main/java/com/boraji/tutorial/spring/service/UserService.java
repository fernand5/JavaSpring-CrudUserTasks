package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.User;

import java.util.List;

public interface UserService {

   long save(User user);
   User get(long id);
   List<User> list();
   void update(long id, User user);
   void addTask(long id, long idTask);
   void delete(long id);
}
