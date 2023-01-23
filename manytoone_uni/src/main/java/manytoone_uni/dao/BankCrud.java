package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.Bank;
import manytoone_uni.dto.Branch;

public class BankCrud {
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("gani");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void save(Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(bank);
	    entityTransaction.commit();
	}

	public void update(int id, Bank bank) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank student2 = entityManager.find(Bank.class, id);
		if (student2 != null) {
			bank.setId(id);
			entityTransaction.begin();
			entityManager.merge(bank);
			entityTransaction.commit();
		} else {
			System.out.println("branch not found");
		}
	}
	public void delete(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Bank school = entityManager.find(Bank.class, id);
		entityTransaction.begin();
		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void fetchId(int id) {
		EntityManager entityManager = getEntityManager();
		Bank company = entityManager.find(Bank.class, id);
		System.out.println(company);
	}

	public void fetch(int id) {
		EntityManager entityManager = getEntityManager();
		javax.persistence.Query query = entityManager.createQuery("select a from Bank a");
		List<Bank> list = query.getResultList();
		System.out.println(list);
	}
}
