package com.boraji.tutorial.spring.controller;

import com.boraji.tutorial.spring.model.Task;
import com.boraji.tutorial.spring.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

   @Autowired
   private TaskService taskService;

   /*---Add new task---*/
   @PostMapping("/task")
   public ResponseEntity<?> save(@RequestBody Task task) {
      long id = taskService.save(task);
      return ResponseEntity.ok().body("New Task has been saved with ID:" + id);
   }

   /*---Get a task by id---*/
   @GetMapping("/task/{id}")
   public ResponseEntity<Task> get(@PathVariable("id") long id) {
      Task task = taskService.get(id);
      return ResponseEntity.ok().body(task);
   }

   /*---get all tasks---*/
   @GetMapping("/task")
   public ResponseEntity<List<Task>> list() {
      List<Task> tasks = taskService.list();
      return ResponseEntity.ok().body(tasks);
   }

   /*---Update a task by id---*/
   @PutMapping("/task/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Task task) {
      taskService.update(id, task);
      return ResponseEntity.ok().body("Task has been updated successfully.");
   }

   /*---Delete a task by id---*/
   @DeleteMapping("/task/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      taskService.delete(id);
      return ResponseEntity.ok().body("Task has been deleted successfully.");
   }
}