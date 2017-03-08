package com.logic.java;

import java.util.ArrayList;
import java.util.Scanner;

public class TestArr {

	public static void main(String[] args) {
		System.out.println("Enter the valid no of plants as positive value ");
		int in = new Scanner(System.in).nextInt();
		System.out.println("Enter the value of pesticide for " + in + " plants ");
		Integer ass[] = new Integer[in];
		for (int b = 0; b < in; b++) {
			ass[b] = new Scanner(System.in).nextInt();
		}
	   System.out.println(	printDays(ass));

	}

	private static int printDays(Integer[] pesti) {
		ArrayList<Integer> lst = new ArrayList<Integer>();
		boolean flag = false;
		
		for (int s = 0; s < pesti.length - 1; s++) {
			if (pesti[s] - pesti[s + 1] >= 0) {
				if (s == 0) {
					lst.add(pesti[s]);
					lst.add(pesti[s + 1]);
				} else {
					lst.add(pesti[s + 1]);
				}
			} else {
				flag = true;
			}

		} 
		  Integer arr[]=new Integer[(lst.size())];
		  int count =1;
		    
			 for(int i=0;i<lst.size();i++){
			 
		       arr[i]=lst.get(i);
		       }
			printDays(arr);
			count++;
		 }
		   
		System.out.println(lst);
}
}}
