package com.n26.transaction;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.n26.transaction.model.Transaction;
import com.n26.transaction.service.TransactionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {
	
	

	@InjectMocks
	private TransactionServiceImpl transactionServiceImpl;

	@Test
	public void updateTransactionTest() {

		assertEquals(true, transactionServiceImpl.update(new Transaction(25.0, System.currentTimeMillis() )));
		assertEquals(true, transactionServiceImpl.update(new Transaction(100.0, System.currentTimeMillis()- 2000)));
		assertEquals(true, transactionServiceImpl.update(new Transaction(175.0, System.currentTimeMillis()- 3000)));
		
		// updating transaction value before 60 seconds, should return false
		assertEquals(false, transactionServiceImpl.update(new Transaction(25.0, System.currentTimeMillis()- 70000)));
	}
	
	
	@Test
	public void getStatisticsTest() {
		
        // asserting transaction data  previously entered
		assertEquals(300.0, transactionServiceImpl.processStatistics().getSum(), 0.0);
		assertEquals(100.0, transactionServiceImpl.processStatistics().getAverage(), 0.0);
		assertEquals(175.0, transactionServiceImpl.processStatistics().getMax_amount(), 0.0);
		assertEquals(25.0, transactionServiceImpl.processStatistics().getMin_amount(), 0.0);
		assertEquals(3, transactionServiceImpl.processStatistics().getCount());

	}
	
}
