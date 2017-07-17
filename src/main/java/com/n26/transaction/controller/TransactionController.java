package com.n26.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.n26.transaction.model.Transaction;
import com.n26.transaction.service.TransactionService;



/**
 * Rest api to update transaction
 * 
 * @author deepthi
 *
 */
@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
    private TransactionService transactionService ;
	/**
	 * 
	 * @param trans
	 * @return empty body with http status code 201 for success or 204 status code in case of 60 seconds older transaction
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?>  updateTransaction(@RequestBody Transaction trans){

	    return transactionService.update(trans) ? new ResponseEntity<Transaction>(HttpStatus.CREATED) : new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT) ;
	}

}
