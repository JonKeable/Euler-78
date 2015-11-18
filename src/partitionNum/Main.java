package partitionNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	private static PartitionCalc calc = new PartitionCalc();
	
	public static void main(String[] args) {
		
		long x = 1000000;
		long time = 0;
		
		System.out.println("How many times would you like to run the code to calculate first p(n) divisible by 1 million? (default 1)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inNum = null;
		int its = 1;
		
		try {
			inNum = br.readLine();
			its = Integer.parseInt(inNum);
			System.out.println("Doing: " + its + " iterations");
		}
		catch(Exception e) {
			System.err.println("Something was wrong with your number! Doing 1 iteration");
		}
		
		for(int i = 1; i <= its; i++) {
			
			long start = System.nanoTime();
			calcFirstDiv(x);
			long end = System.nanoTime();
			
			time += (end - start)/1000000; // gives time in milliseconds
		}
		
		System.out.println("time taken for " + its + ": " + + time + "ms");
		time = time/its;
		System.out.println("time taken for 1: " + time + "ms");
		/*
		long test1 = 100;
		int test2 = 100;
		
		System.out.println("p(" + test1 + ") = " + calc.bigFirstDivP(test1));
		System.out.println("p(" + test2 + ") = " + calc.firstDivP(test2));
		*/
		
		/*
		for(long x = 0; x<=10; x++) {
			System.out.println("p(" + x +") = " + calc.bigP(x));
		}
		*/
		
		//long x = 5000;
		//System.out.println("p(" + x + ") = " + calc.longPentP(x));
		//System.out.println("p(" + x + ") = " + calc.bigPentP(x));
		
		
		
		
		
		/*
		n = calc.firstDivP(div);
		System.out.println("result = " + n);
		System.out.println("p(" + n + ") = " + calc.savedPofn);
		*/
	}
	
	private static void calcFirstDiv(long div) {
		PartitionCalc tempCalc = new PartitionCalc();
		long n = 0;
		n = tempCalc.bigFirstDivP(div);
		System.out.println("result = " + n);
		System.out.println("p(" + n + ") = " + tempCalc.bigSavedPofn);
	}
}


	

