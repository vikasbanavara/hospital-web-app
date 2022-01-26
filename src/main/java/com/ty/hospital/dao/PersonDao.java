package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Person;

public class PersonDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	
	public void createPerson(Person person) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(person);
		
		entityTransaction.commit();
		
	}
	
	public List<Person> getAllPerson() {
		Query query = entityManager.createQuery("SELECT p FROM Person p");
		return query.getResultList();
	}

	public boolean deletePerson(int id) {
		return false;
	}
	
	public void updatePerson(Person person) {
		
	}
	
	public Person getPersonById(int id) {
		return entityManager.find(Person.class, id);
	}
}
