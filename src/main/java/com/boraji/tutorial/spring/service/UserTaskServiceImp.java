package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.dao.UserTaskDao;
import com.boraji.tutorial.spring.model.UserTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserTaskServiceImp implements UserTaskService {

   @Autowired
   private UserTaskDao userTaskDao;

   @Transactional
   @Override
   public UserTask save(UserTask userTask) {
      return userTaskDao.save(userTask);
   }

   @Override
   public UserTask get(long id) {
      return userTaskDao.get(id);
   }

   @Override
   public List<UserTask> list() {
      return userTaskDao.list();
   }

   @Transactional
   @Override
   public void update(long id, UserTask userTask) {
      userTaskDao.update(id, userTask);
   }

   @Transactional
   @Override
   public void delete(long id) {
      userTaskDao.delete(id);
   }

}
