package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.User;

public class UserDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	
	public void createUser(int branchId,User user) {
		
		BranchDao branchDao = new BranchDao();
		Branch branch = branchDao.getBranchById(branchId);
		
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		user.setBranch(branch);
		entityManager.persist(user);
		
		entityTransaction.commit();
	}
	
	public User validateUser(String email,String password) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE email=?1 AND password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> users = query.getResultList();
		if(users != null && users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
}
