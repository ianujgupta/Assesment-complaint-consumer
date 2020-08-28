package com.dxctraining.complaintmgt.complaint.dao;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

public interface IComplaintDao {
	
	Complaint add(Complaint complaint);

	Complaint findComplaintById(int id);
	
	List<Complaint> allComplaints();
	
	List<Complaint> allComplaintsByConsumer(int consumerId);

}
