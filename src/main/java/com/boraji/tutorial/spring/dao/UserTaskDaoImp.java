package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.UserTask;
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
public class UserTaskDaoImp implements UserTaskDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public UserTask save(UserTask userTask) {
      sessionFactory.getCurrentSession().save(userTask);
      return userTask;
   }

   @Override
   public UserTask get(long id) {
      return sessionFactory.getCurrentSession().get(UserTask.class, id);
   }

   @Override
   public List<UserTask> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<UserTask> cq = cb.createQuery(UserTask.class);
      Root<UserTask> root = cq.from(UserTask.class);
      cq.select(root);
      Query<UserTask> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, UserTask userTask) {
      Session session = sessionFactory.getCurrentSession();
      UserTask userTask2 = session.byId(UserTask.class).load(id);
//      userTask2.setTitle(userTask.getTitle());
//      userTask2.setAuthor(userTask.getAuthor());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      UserTask userTask = session.byId(UserTask.class).load(id);
      session.delete(userTask);
   }

}
