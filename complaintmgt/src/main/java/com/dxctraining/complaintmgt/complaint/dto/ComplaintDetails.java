package com.dxctraining.complaintmgt.complaint.dto;

public class ComplaintDetails {

	private int id;
	private int consumerId;
	private String description;	
	private String consumerName;

	public ComplaintDetails(int id, String description) {
		this.id=id;
		this.description=description;
	}

	public String getConsumerName() {
		return consumerName;
	}

	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
