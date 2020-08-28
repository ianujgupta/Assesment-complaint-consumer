package com.dxctraining.consumermgt.consumer.service;

import java.util.List;

import com.dxctraining.consumermgt.consumer.entities.Consumer;

public interface IConsumerService {
	
	Consumer add(Consumer consumer);

	Consumer findConsumerById(int id);
	
	List<Consumer> allConsumers();

}
