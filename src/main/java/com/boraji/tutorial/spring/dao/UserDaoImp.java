package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.Task;
import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.model.UserTask;
import com.boraji.tutorial.spring.service.TaskService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(User user) {
      sessionFactory.getCurrentSession().save(user);
      return user.getId();
   }

   @Override
   public User get(long id) {
      return sessionFactory.getCurrentSession().get(User.class, id);
   }

   @Override
   public List<User> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> root = cq.from(User.class);
      cq.select(root);
      Query<User> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, User user) {
      Session session = sessionFactory.getCurrentSession();
      User user2 = session.byId(User.class).load(id);
      user2.setName(user.getName());
      user2.setDependency(user.getDependency());
      user2.setProfile(user.getProfile());
      user2.setActive(user.getActive());
      user2.setBirthDate(user.getBirthDate());
      session.flush();
   }

   @Override
   public void addTask(long id, Task task) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.byId(User.class).load(id);
      user.setTasks(task);
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      User user = session.byId(User.class).load(id);
      session.delete(user);
   }

}
