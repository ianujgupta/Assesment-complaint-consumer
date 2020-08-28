package com.dxctraining.consumermgt.consumer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumermgt.consumer.dao.IConsumerDao;
import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.InvalidArgumentException;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {

	@Autowired
	private IConsumerDao dao;

	@Override
	public Consumer add(Consumer consumer) {
		validate(consumer);
		consumer = dao.add(consumer);
		return consumer;
	}

	@Override
	public Consumer findConsumerById(int id) {
		validate(id);
		Consumer consumer = dao.findConsumerById(id);
		return consumer;
	}

	@Override
	public List<Consumer> allConsumers() {
		List<Consumer> consumer = dao.allConsumers();
		return consumer;
	}

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
	}

}
