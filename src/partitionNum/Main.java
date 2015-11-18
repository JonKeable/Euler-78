package partitionNum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	private static PartitionCalc calc = new PartitionCalc();
	
	public static void main(String[] args) {
		
		long x = 1000000;
		long time = 0;
		
		for(int i = 1; i <= 1000; i++) {
			
			long start = System.nanoTime();
			calcFirstDiv(x);
			long end = System.nanoTime();
			
			time += (end - start)/1000000; // gives time in milliseconds
		}
		
		System.out.println("time taken for 1000: " + time + "ms");
		time = time/1000;
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


	

