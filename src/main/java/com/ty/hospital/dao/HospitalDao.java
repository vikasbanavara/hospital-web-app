package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Hospital;

public class HospitalDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	
	public void createHosptial(Hospital hospital) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(hospital);
		
		entityTransaction.commit();
	}
	
	public Hospital getHospitalById(int id) {
		return entityManager.find(Hospital.class, id);
	}
	
	public List<Hospital> getAllHospital() {
		Query query = entityManager.createQuery("SELECT h FROM Hospital h");
		return query.getResultList();
	}

	public boolean deleteHospital(int id) {
		return false;
	}
	
	public void updateHospital(Hospital hospital) {
		
	}
}
