package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class BranchDao {
	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = null;
	private HospitalDao hospitalDao = new HospitalDao();
	
	public boolean createBranch(int hospitalId,Branch branch) {
		Hospital hospital = hospitalDao.getHospitalById(hospitalId);
		if(hospital != null) {
			
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			branch.setHospital(hospital);
			entityManager.persist(branch);
			
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}
	
	public Branch getBranchById(int branchId) {
		return entityManager.find(Branch.class, branchId);
	}

	public List<Branch> getAllBranchesByHospital(int hospitalId) {
		return null;
	}
	
	public boolean deleateBranch(int branchId) {
		return false;
	}
	
	public void updateBranch(Branch branch) {
		
	}
}
