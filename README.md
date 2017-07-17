# n26_code

There exits two Rest api in this Spring boot maven project:

1) First one is called every time a transaction is made. It is also the sole input of this rest API. 

POST /transactions

URI: http://localhost:8080/transaction/

Sample JSON:

{

"amount": 300,

"timestamp": 1500283239147
}

Returns: Empty body with either 201 or 204.

● 201 - in case of success

● 204 - if transaction is older than 60 seconds

Assumption: Each transaction with unique timestamp in millis

2) Second Rest API returns the statistic based on the transactions which happened in the last 60

seconds.

URI:http://localhost:8080/statistics/

Returns:
{        
"sum": 1000,        
"avg": 100,        
"max": 200,        
"min": 50,        
"count": 10 
} 
