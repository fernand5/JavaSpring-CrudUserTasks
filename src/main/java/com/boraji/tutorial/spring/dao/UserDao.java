package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.User;

import java.util.List;

public interface UserDao {

   long save(User user);

   User get(long id);

   List<User> list();

   void update(long id, User user);

   void delete(long id);

}
