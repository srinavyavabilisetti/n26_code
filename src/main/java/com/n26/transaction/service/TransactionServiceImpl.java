package com.n26.transaction.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import com.n26.transaction.model.Statistics;
import com.n26.transaction.model.Transaction;
import com.n26.transaction.util.TransactionHelper;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	
    /*
     *  A Concurrent hash map (thread safe)  to store every transaction
     */
	private static Map<Long, Transaction> statisticsMap = new ConcurrentHashMap<Long, Transaction>();

	
	/**
	 * Storing each transaction into a static ConcurrentHashMap 
	 * 
	 * @param trans  input transaction
	 * 
	 * @return true or false if transaction is older or within 60 seconds
	 */
	@Override
	public boolean update(Transaction trans) {

		if (TransactionHelper.checkValidInTime(trans.getTimestamp())) {
            //Assuming each transaction having different timestamp in millis and using it as Key in Map
			statisticsMap.put(trans.getTimestamp(), trans);
            return true;
		}

		return false;

	} 
    /**
     * Returns statistics of the last 60 second transaction and 
     * return zero values if no transaction exists
     * 
     * @return Statistics returns the current statistics as per map data
     * 
     */
	@Override
	public Statistics processStatistics() {

		double sum = 0;
		int count = 0;
		double max_amount = 0;
		double min_amount = 0;
		double average;

		for (long key : statisticsMap.keySet()) {

			if (TransactionHelper.checkInValidTime(key)) {
				statisticsMap.remove(key);
			} else {
				sum += statisticsMap.get(key).getAmount();
				max_amount = Math.max(max_amount, statisticsMap.get(key).getAmount());
				// initializing min amount value to the first transaction value
				if (min_amount == 0) {
					min_amount = statisticsMap.get(key).getAmount();
				}
				min_amount = Math.min(min_amount, statisticsMap.get(key).getAmount());

				count++;
			}

		}

		average = (count == 0) ? 0 : sum / count;

		return new Statistics(sum, average, max_amount, min_amount, count);

	}

}
