package com.activemq.producer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.activemq.producer.model.Employee;
import com.activemq.producer.service.JMSProducer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

	private final JMSProducer producer;

	@PostMapping("/employee")
	public ResponseEntity<Employee> add(@RequestBody Employee employee) {
		producer.sendMessage(employee);
		return ResponseEntity.ok(employee);
	}
}
