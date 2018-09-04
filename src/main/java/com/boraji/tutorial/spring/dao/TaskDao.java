package com.boraji.tutorial.spring.dao;

import com.boraji.tutorial.spring.model.Task;

import java.util.List;

public interface TaskDao {

   long save(Task task);

   Task get(long id);

   List<Task> list();

   void update(long id, Task task);

   void delete(long id);

}
