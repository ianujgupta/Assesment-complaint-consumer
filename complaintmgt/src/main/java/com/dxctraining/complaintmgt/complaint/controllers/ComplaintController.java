package com.dxctraining.complaintmgt.complaint.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaintmgt.complaint.dto.ComplaintDetails;
import com.dxctraining.complaintmgt.complaint.dto.ConsumerDetails;
import com.dxctraining.complaintmgt.complaint.dto.CreateComplaintRequest;
import com.dxctraining.complaintmgt.complaint.entities.Complaint;
import com.dxctraining.complaintmgt.complaint.service.IComplaintService;
import com.dxctraining.complaintmgt.complaint.util.ComplaintUtil;


@RestController
@RequestMapping("/complaints")
public class ComplaintController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ComplaintUtil util;
	
	@Autowired
	private IComplaintService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ComplaintDetails add(@RequestBody CreateComplaintRequest request ){
		int consumerId = request.getConsumerId();
		String description= request.getDescription();
		Complaint complaint = new Complaint(consumerId,description);
		complaint =service.add(complaint);
		ConsumerDetails consumerDetails = fetchFromConsumerById(consumerId);
		ComplaintDetails response= util.complaintDetails(complaint,consumerId,consumerDetails.getName());
		return response;
	}
	
	//fetch by using complaint Id
	@GetMapping("/get/{id}")
	public ComplaintDetails fetchComplaintById(@PathVariable("id") int id){
		Complaint complaint = service.findComplaintById(id);
		int consumerId = complaint.getConsumerId();
		ConsumerDetails details = fetchFromConsumerById(consumerId);
		ComplaintDetails response = util.complaintDetails(complaint, consumerId, details.getName());
		return response;
	}
	
	// fetch by using consumer Id
	@GetMapping("/consumer/{consumerId}")
	public List<ComplaintDetails> fetchAllComplaints(@PathVariable("consumerId") int consumerId) {
		List<Complaint> list = service.allComplaintsByConsumer(consumerId);
		List<ComplaintDetails> response = new ArrayList<>();
		ConsumerDetails consumerDetails = fetchFromConsumerById(consumerId);
		for (Complaint complaint : list) {
			ComplaintDetails details = util.complaintDetails(complaint, consumerId, consumerDetails.getName());
			response.add(details);
		}
		return response;
	}
	
	@GetMapping("/allcomplaints")
	public List<ComplaintDetails> fetchAllComplaints(){
		List<Complaint> list = service.allComplaints();
		List<ComplaintDetails> response = new ArrayList<>();
		for(Complaint complaint:list) {
			int consumerId = complaint.getConsumerId();
			ConsumerDetails consumerDetails = fetchFromConsumerById(consumerId);
			ComplaintDetails comlaintdetails = util.complaintDetails(complaint, consumerId, consumerDetails.getName());
			response.add(comlaintdetails);
		}
		return response;		
	}
	

	public ConsumerDetails fetchFromConsumerById(int consumerId) {
		String url = "http://localhost:8585/consumers/get/"+consumerId;
		ConsumerDetails details = restTemplate.getForObject(url, ConsumerDetails.class);//(URL, type of response is Class Consumer details)
		return details;
	}
	
}
