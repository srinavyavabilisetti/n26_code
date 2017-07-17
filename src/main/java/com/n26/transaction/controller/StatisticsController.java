package com.n26.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.n26.transaction.model.Statistics;
import com.n26.transaction.service.TransactionService;


/**
 * Rest api to get Statistics
 * 
 * @author deepthi
 *
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Autowired
	private TransactionService transactionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Statistics> getStatistics() {

		return new ResponseEntity<Statistics>(transactionService.processStatistics(), HttpStatus.OK);
	}

}
