package com.dxctraining.complaintmgt.complaint.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

@Repository
public class ComplaintDaoImpl implements IComplaintDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Complaint add(Complaint complaint) {
		entityManager.persist(complaint);
		return complaint;
	}

	@Override
	public Complaint findComplaintById(int id) {
		Complaint complaint = entityManager.find(Complaint.class, id);
		return complaint;
	}

	@Override
	public List<Complaint> allComplaints() {
		String ql = "from Complaint";
		TypedQuery<Complaint> query = entityManager.createQuery(ql, Complaint.class);
		List<Complaint> complaintList = query.getResultList();
		return complaintList;
	}

	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId) {
		String jpaql ="from Complaint where consumerId=:consumer"; 
		TypedQuery<Complaint> query = entityManager.createQuery(jpaql, Complaint.class);
		query.setParameter("consumer", consumerId);
		List<Complaint> complaintList = query.getResultList();
		return complaintList;
	}

}
