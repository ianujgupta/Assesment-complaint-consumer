package com.dxctraining.consumermgt.consumer.dao;

import java.util.List;

import com.dxctraining.consumermgt.consumer.entities.Consumer;

public interface IConsumerDao {
	
	Consumer add(Consumer consumer);

	Consumer findConsumerById(int id);
	
	List<Consumer> allConsumers();

}
