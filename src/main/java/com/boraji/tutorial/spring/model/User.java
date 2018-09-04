package com.boraji.tutorial.spring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity(name = "User")
public class User {

   public enum UserProfile {

      ADMINISTRADOR("ADMINISTRADOR"),
      OPERADOR("OPERADOR"),
      CONSULTA("CONSULTA");

      public String value;
      UserProfile(String value){
         this.value = value;
      }
   }

   public enum UserDependency {

      CONSULTORIA("CONSULTORIA"),
      FABRICA("FABRICA"),
      DESARROLLO("DESARROLLO");

      public String value;

      UserDependency(String value) {
         this.value = value;
      }
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Date birthDate;
   private Boolean active;

   @Enumerated(EnumType.STRING)
   private UserProfile profile;

   @Enumerated(EnumType.STRING)
   private UserDependency dependency;

   @Embedded
   @ManyToMany(fetch = FetchType.EAGER,
           cascade = {
                   CascadeType.ALL
           })
   @JoinTable(name = "user_task",
           joinColumns = { @JoinColumn(name = "user_id") },
           inverseJoinColumns = { @JoinColumn(name = "task_id") })
   private Set<Task> tasks = new HashSet<Task>();

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getBirthDate() {
      return birthDate;
   }

   public void setBirthDate(Date birthDate) {
      this.birthDate = birthDate;
   }

   public Boolean getActive() {
      return active;
   }

   public void setActive(Boolean active) {
      this.active = active;
   }

   public UserProfile getProfile() {
      return profile;
   }

   public void setProfile(UserProfile profile) {
      this.profile = profile;
   }

   public UserDependency getDependency() {
      return dependency;
   }

   public void setDependency(UserDependency dependency) {
      this.dependency = dependency;
   }


   public Set<Task> getTasks() {
      return tasks;
   }

   public void setTasks(Task task) {
      this.getTasks().add(task);
   }
}
