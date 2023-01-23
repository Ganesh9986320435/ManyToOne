package manytoone_uni.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.Bank;
import manytoone_uni.dto.Branch;
import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;

public class BranchCrud {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gani");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void save(List<Branch> list) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		for (Branch branch : list) {
			entityManager.persist(branch);
			Bank bank=branch.getBank();
			entityManager.merge(bank);

		}
				entityTransaction.commit();
	}

	public void update(int id, Branch branch) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch student2 = entityManager.find(Branch.class, id);
		if (student2 != null) {
			branch.setId(id);
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
		} else {
			System.out.println("branch not found");
		}
	}
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Branch school = entityManager.find(Branch.class, id);
		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void fetchId(int id) {
		EntityManager entityManager = getEntityManager();
		Branch company = entityManager.find(Branch.class, id);
		System.out.println(company);
	}

	public void fetch(int id) {
		EntityManager entityManager = getEntityManager();
		javax.persistence.Query query = entityManager.createQuery("select a from Branch a");
		List<Branch> list = query.getResultList();
		System.out.println(list);
	}
}
