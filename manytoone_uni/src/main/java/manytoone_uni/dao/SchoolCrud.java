package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;
import manytoone_uni.dto.Teacher;

public class SchoolCrud {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gani");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void save(School school,int studentid ,int teacherid) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher teacher=entityManager.find(Teacher.class, teacherid);
		teacher.setSchool(school);
		Student teacher1=entityManager.find(Student.class, teacherid);
		teacher1.setSchool(school);
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(teacher1);
		entityManager.merge(school);
		entityTransaction.commit();
	}

	public void update(int id, School school) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School student2 = entityManager.find(School.class, id);
		if (student2 != null) {
			school.setId(id);
			entityTransaction.begin();
			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("stusdent not found");
		}
	}

	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student = entityManager.find(Student.class, id);
		School school=entityManager.find(School.class,id);
		Teacher teacher=entityManager.find(Teacher.class, id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityManager.remove(teacher);
		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void fetchId(int id) {
		EntityManager entityManager = getEntityManager();
		School company = entityManager.find(School.class, id);
		System.out.println(company);
	}

	public void fetch(int id) {
		EntityManager entityManager = getEntityManager();
		javax.persistence.Query query = entityManager.createQuery("select a from School a");
		List<School> list = query.getResultList();
		System.out.println(list);
	}

}
