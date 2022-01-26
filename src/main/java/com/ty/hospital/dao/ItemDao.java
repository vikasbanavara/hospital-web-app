package com.ty.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class ItemDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	
	
	public boolean createItem(int orderId,Item item) {
		MedOrderDao dao = new MedOrderDao();
		MedOrder medOrder = dao.getOrderById(orderId);
		if(medOrder != null) {
			item.setMedOrder(medOrder);
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOrder(int id) {
		Item item = entityManager.find(Item.class, id);
		if(item != null) {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
}
