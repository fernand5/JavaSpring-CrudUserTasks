package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.dao.UserDao;
import com.boraji.tutorial.spring.model.Task;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.model.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Autowired
   private UserTaskService userTask;

   @Autowired
   private TaskService taskService;

   @Transactional
   @Override
   public long save(User user) {
      return userDao.save(user);
   }

   @Override
   public User get(long id) {
      return userDao.get(id);
   }

   @Override
   public List<User> list() {
      return userDao.list();
   }

   @Transactional
   @Override
   public void update(long id, User user) {
      userDao.update(id, user);
   }

   @Transactional
   @Override
   public void addTask(long id, long idTask) {
      Task task = taskService.get(idTask);
      userDao.addTask(id, task);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

}
