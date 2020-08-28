package com.dxctraining.complaintmgt.complaint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.complaintmgt.complaint.dao.IComplaintDao;
import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.InvalidArgumentException;


@Transactional
@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	private IComplaintDao dao;

	@Override
	public Complaint add(Complaint complaint) {
		validate(complaint);
		complaint = dao.add(complaint);
		return complaint;
	}

	@Override
	public Complaint findComplaintById(int id) {
		validate(id);
		Complaint complaint = dao.findComplaintById(id);
		return complaint;
	}

	@Override
	public List<Complaint> allComplaints() {
		List<Complaint> complaint = dao.allComplaints();
		return complaint;
	}

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
	}

	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerId) {
		List<Complaint> complaintList= dao.allComplaintsByConsumer(consumerId);
		return complaintList;
	}

}
