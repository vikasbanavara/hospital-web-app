package com.ty.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	
	public boolean createOrder(int encounterId,MedOrder medOrder) {
		EncounterDao encounterDao = new EncounterDao();
		Encounter encounter = encounterDao.getEncounterById(encounterId);
		if(encounter != null) {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			medOrder.setEncounter(encounter);
			entityManager.persist(medOrder);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
	
	public MedOrder getOrderById(int id) {
		return entityManager.find(MedOrder.class, id);
	}
}
