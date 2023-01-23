package manytoone_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gani");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		School school=new School();
		school.setId(1);
		school.setNameString("ty");
		Student student=new Student();
		student.setId(1);
		student.setName("gani");
		student.setSchool(school);
		Student student1=new Student();
		student1.setId(2);
		student1.setName("3ani");
		student1.setSchool(school);
		entityTransaction.begin();
		entityManager.persist(school);
		entityManager.persist(student);
		entityManager.persist(student1);
		entityTransaction.commit();
	}
}
