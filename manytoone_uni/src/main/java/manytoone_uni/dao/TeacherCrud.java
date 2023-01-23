package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;
import manytoone_uni.dto.Teacher;

public class TeacherCrud {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gani");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void save(Teacher teacher,int schoolId) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school=entityManager.find(School.class, schoolId);
		teacher.setSchool(school);
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
	}

	public void update(int id, Teacher teacher) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher student2 = entityManager.find(Teacher.class, id);
		if (student2 != null) {
			teacher.setId(id);
			entityTransaction.begin();
			entityManager.merge(teacher);
			entityTransaction.commit();
		} else {
			System.out.println("stusdent not found");
		}
	}

	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher school = entityManager.find(Teacher.class, id);
		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void fetchId(int id) {
		EntityManager entityManager = getEntityManager();
		Teacher company = entityManager.find(Teacher.class, id);
		System.out.println(company);
	}

	public void fetch(int id) {
		EntityManager entityManager = getEntityManager();
		javax.persistence.Query query = entityManager.createQuery("select a from Teacher a");
		List<Teacher> list = query.getResultList();
		System.out.println(list);
	}

}
