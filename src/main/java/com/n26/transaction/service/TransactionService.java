package com.n26.transaction.service;

import com.n26.transaction.model.Statistics;
import com.n26.transaction.model.Transaction;

/**
 * Interface for transaction service
 * 
 * @author deepthi
 *
 */
public interface TransactionService {
	
	 boolean update(Transaction trans);
	 Statistics processStatistics();

}
