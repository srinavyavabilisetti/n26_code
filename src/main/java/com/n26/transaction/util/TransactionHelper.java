/**
 * 
 */
package com.n26.transaction.util;

import com.n26.transaction.Constants;

/**
 * Helper class for this rest api to methods like check and other util methods
 * @author deepthi
 *
 */
public class TransactionHelper {
	
	public static boolean checkValidInTime(long key) {
		
           // system time UTC time in milli seconds 
		if ((System.currentTimeMillis()  - key)/1000L < Constants.seconds_limit)
			return true;

		return false;
	}

	public static boolean checkInValidTime(long key) {
        
		   // system time UTC time in milli seconds 
		if ((System.currentTimeMillis()  - key)/1000L > Constants.seconds_limit)
			return true;

		return false;
	}
}
