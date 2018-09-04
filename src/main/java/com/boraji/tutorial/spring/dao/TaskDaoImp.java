package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.Task;
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
public class TaskDaoImp implements TaskDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public long save(Task task) {
      sessionFactory.getCurrentSession().save(task);
      return task.getId();
   }

   @Override
   public Task get(long id) {
      return sessionFactory.getCurrentSession().get(Task.class, id);
   }

   @Override
   public List<Task> list() {
      Session session = sessionFactory.getCurrentSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Task> cq = cb.createQuery(Task.class);
      Root<Task> root = cq.from(Task.class);
      cq.select(root);
      Query<Task> query = session.createQuery(cq);
      return query.getResultList();
   }

   @Override
   public void update(long id, Task task) {
      Session session = sessionFactory.getCurrentSession();
      Task task2 = session.byId(Task.class).load(id);
//      task2.setTitle(task.getTitle());
//      task2.setAuthor(task.getAuthor());
      session.flush();
   }

   @Override
   public void delete(long id) {
      Session session = sessionFactory.getCurrentSession();
      Task task = session.byId(Task.class).load(id);
      session.delete(task);
   }

}
