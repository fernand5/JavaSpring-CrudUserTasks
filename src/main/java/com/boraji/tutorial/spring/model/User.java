package com.boraji.tutorial.spring.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "User")
public class User {

   public enum UserProfile {

      Admin("ADMINISTRADOR"),
      Consult("CONSULTA"),
      Operator("OPERADOR");

      public String value;

      UserProfile(String value) {
         this.value = value;
      }
   }

   public enum UserDependency {

      Consult("CONSULTORIA"),
      Company("FABRICA"),
      Development("DESARROLLO");

      public String value;

      UserDependency(String value) {
         this.value = value;
      }
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String title;
   private String author;
   private Date birthDate;
   private Boolean active;

   @Enumerated(EnumType.STRING)
   private UserProfile profile[];

   @Enumerated(EnumType.STRING)
   private UserDependency dependency;

   private List<Fila> queues;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
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

   public UserProfile[] getProfile() {
      return profile;
   }

   public void setProfile(UserProfile[] profile) {
      this.profile = profile;
   }

   public UserDependency getDependency() {
      return dependency;
   }

   public void setDependency(UserDependency dependency) {
      this.dependency = dependency;
   }

   public List<Fila> getQueues() {
      return queues;
   }

   public void setQueues(List<Fila> queues) {
      this.queues = queues;
   }
}
