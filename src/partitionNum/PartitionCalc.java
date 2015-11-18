package partitionNum;

import java.math.BigInteger;
import java.util.HashMap;

public class PartitionCalc {
	
	BigInteger bigSavedPofn; 
	//HashMap<String, BigInteger> savedParts = new HashMap<String, BigInteger>();
	HashMap<Long, BigInteger> mapOfParts = new HashMap<Long, BigInteger>();
	//HashMap<Long, Long> longMap = new HashMap<Long, Long>();
	long savedPofn;
	
	protected long p(long n) {
		return p(n,n);
	}
	
	
	protected BigInteger bigPentP(long n) {
		
		if(n == 0) return BigInteger.ONE;
		
		BigInteger ans = mapOfParts.get(n);
		if(ans != null) {
			return ans; 
		}
		else {
			
			long pent;
			long k = 1;
			BigInteger sum = new BigInteger("0");
				
			while(true) {
					
				int sign = (k % 2 == 0) ? -1 : 1 ;
				pent = n - (k * (3 * k - 1) / 2);
				if(pent < 0) {
					break;
				}
				if(sign == -1) {
					sum = sum.add(bigPentP(pent).negate());
				}
				else {
					sum = sum.add(bigPentP(pent));
				}
				
					
				pent = n - (k * (3 * k + 1) / 2);
				if(pent < 0) {
					break;
				}
				if(sign == -1) {
					sum = sum.add(bigPentP(pent).negate());
				}
				else {
					sum = sum.add(bigPentP(pent));
				}
					
				k++;
			}
			
			mapOfParts.put(n, sum);
			return sum;
		}
		
	}

/*	
protected long longPentP(long n) {
		
		if(n == 0) return 1;
		if(n < 0) return 0;
		
		Long ans = longMap.get(n);
		if(ans != null) {
			return ans; 
		}
		else {
			
			long pent;
			long k = 1;
			long sum = 0;
				
			while(true) {
					
				int sign = (k % 2 == 0) ? -1 : 1 ;
				pent = n - (k * (3 * k - 1) / 2);
				if(pent < 0) {
					break;
				}
				if(sign == -1) {
					sum = sum - longPentP(pent);
				}
				else {
					sum = sum + longPentP(pent);
				}
				
					
				pent = n - (k * (3 * k + 1) / 2);
				if(pent < 0) {
					break;
				}
				if(sign == -1) {
					sum = sum - longPentP(pent);
				}
				else {
					sum = sum + longPentP(pent);
				}
					
				k++;
			}
			
			longMap.put(n, sum);
			return sum;
		}
		
	}
*/
	
	private BigInteger longToBig(Long l) {
		return new BigInteger(l.toString());
	}
	
/*	
	protected BigInteger bigP(long n) {
		return bigP(n,n);
	}
*/	
	private BigInteger a(long k, long j) {
		Long ans = -((-1)^k) * p(j);
		return new BigInteger(ans.toString());
	}
	
	protected long p(long n, long k) {

		if(n == k) {
			return 1 + p(n, k - 1);
		}
		if(k == 0 || n < 0 ) {
			return 0;
		}
		if(n == 0 || k == 1) {
			return 1;
		}
		
		return p(n, k - 1) + p(n - k, k);
	}

	/*
	protected BigInteger bigP(long n, long k) {
		
		if(n == k) {
			return bigP(n, k - 1).add(BigInteger.ONE);
		}
		
		if(k==0 || n < 0) {
			return BigInteger.ZERO;
		}
		
		if(n == 0 || k == 1) {
			return BigInteger.ONE;
		}
		
		String key = (n + "," + k);
		BigInteger ans = savedParts.get(key);
		
		if(ans != null) {
			return ans;
		}
		else {
			ans = bigP(n, k - 1).add(bigP(n - k, k));
			savedParts.put(key, ans);
			return ans;
		}
	}
	*/
	
	/*
	 protected BigInteger bigP(long n, long lim) {
	 
		if (n <= 1) return BigInteger.ONE;
		
		if (lim > n) return bigP(n,n);
		
		if(savedNumParts.containsKey(n)) {
			return savedNumParts.get(n);
		}
		else {
			BigInteger sum = BigInteger.ZERO;
		
			for(long i = 1; i <= lim; i++) {
				sum = sum.add(bigP(n-i, i));
			}
			return sum;
		}
		
	}
	*/
	
	
	protected long firstDivP(long div) {
		long n = 1;
		boolean done = false;
		long result = 0; 
		while (!done)  {
			long pOfn = p(n);
			if((pOfn % div) == 0) {
				done = true;
				result= n;
				savedPofn = pOfn;
			}
			else {
				n++;
				System.out.println("calculating for " + n);
			}
		}
		return result;
	}
	
	protected long bigFirstDivP(Long div) {
		BigInteger bigDiv = new BigInteger(div.toString());
		long n = 1;
		boolean done = false;
		long result = 0;
		while (!done)  {
			BigInteger pOfn = bigPentP(n);
			if((pOfn.mod(bigDiv)).equals(BigInteger.ZERO)) {
				done = true;
				result= n;
				bigSavedPofn = pOfn;
			}
			else {
				//savedNumParts.put(n, pOfn);
				n++;
				//System.out.println("calculating for " + n);
			}
		}
		return result;
	}
	
	private void saveResult(long n, BigInteger parts){
		//savedNumParts.put(n, parts);
	}
}
