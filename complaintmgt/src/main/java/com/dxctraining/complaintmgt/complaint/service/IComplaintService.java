package com.dxctraining.complaintmgt.complaint.service;

import java.util.List;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

public interface IComplaintService {

	
	Complaint add(Complaint complaint);

	Complaint findComplaintById(int id);
	
	List<Complaint> allComplaints();
	
	List<Complaint> allComplaintsByConsumer(int consumerId);


}
