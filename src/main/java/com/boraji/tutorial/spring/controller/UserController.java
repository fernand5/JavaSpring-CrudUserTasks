package com.boraji.tutorial.spring.controller;

import com.boraji.tutorial.spring.model.User;
import com.boraji.tutorial.spring.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
public class UserController {

   @Autowired
   private UserService userService;

   /*---Add new user---*/
   @PostMapping("/user")
   public ResponseEntity<?> save(@RequestBody User user) {
      long id = userService.save(user);
      return ResponseEntity.ok().body("New User has been saved with ID:" + id);
   }

   /*---Get a user by id---*/
   @GetMapping("/user/{id}")
   public ResponseEntity<User> get(@PathVariable("id") long id) {
      User user = userService.get(id);
      return ResponseEntity.ok().body(user);
   }

   /*---get all users---*/
   @GetMapping("/user")
   public ResponseEntity<List<User>> list() {
      List<User> users = userService.list();
      return ResponseEntity.ok().body(users);
   }

   /*---Update a user by id---*/
   @PutMapping("/user/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) {
      userService.update(id, user);
      return ResponseEntity.ok().body("User has been updated successfully.");
   }

   /*---Delete a user by id---*/
   @DeleteMapping("/user/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      userService.delete(id);
      return ResponseEntity.ok().body("User has been deleted successfully.");
   }

   /*---Delete a user by id---*/
   @PutMapping("/user/{id}/addTask/{idTask}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @PathVariable("idTask") long idTask) {
      userService.addTask(id, idTask);
      return ResponseEntity.ok().body("Task added successfully.");
   }

   @RequestMapping(method = RequestMethod.GET,
           produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public List<User> handleAllUserRequest () {
      return userService.list();
   }
}