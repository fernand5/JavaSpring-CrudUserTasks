package com.boraji.tutorial.spring.service;

import com.boraji.tutorial.spring.model.Task;

import java.util.List;

public interface TaskService {

   long save(Task task);
   Task get(long id);
   List<Task> list();
   void update(long id, Task task);
   void delete(long id);
}
