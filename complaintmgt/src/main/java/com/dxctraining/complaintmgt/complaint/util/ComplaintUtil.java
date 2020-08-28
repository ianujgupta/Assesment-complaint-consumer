package com.dxctraining.complaintmgt.complaint.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmgt.complaint.dto.ComplaintDetails;

import com.dxctraining.complaintmgt.complaint.entities.Complaint;

@Component
public class ComplaintUtil {

	public ComplaintDetails complaintDetails(Complaint complaint, int consumerId, String consumerName) {
		ComplaintDetails details = new ComplaintDetails(complaint.getId(), complaint.getDescription());
		details.setConsumerId(consumerId);
		details.setConsumerName(consumerName);
		return details;
	}
}