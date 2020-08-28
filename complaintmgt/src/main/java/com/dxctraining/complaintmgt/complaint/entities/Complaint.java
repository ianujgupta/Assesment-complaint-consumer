package com.dxctraining.complaintmgt.complaint.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complaints")
public class Complaint {
	@Id
	@GeneratedValue
	private int id;
	private String description;
	private int consumerId;

	public Complaint() {
	}

	public Complaint(int consumerId, String description) {
		this.consumerId = consumerId;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || obj != obj.getClass()) {
			return false;
		}
		Complaint that = (Complaint) obj;
		return this.id == that.id;
	}

}
