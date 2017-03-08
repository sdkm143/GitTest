package com.logic.java;

import java.util.Scanner;
import java.util.Stack;

public class Test {
	static Stack<Integer> aStack = new Stack<Integer>();
	static Stack<Integer> bStack = new Stack<Integer>();

	public static void main(String[] args) {
		System.out.println("Enter the no of plants  ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int a = 0; a < n; a++) {
			aStack.push(a);
		}
		System.out.println(printDays(aStack));

	}
//  6,5,8,4,7,10,9
	private static int printDays(Stack<Integer> bStack) {
         while (bStack.isEmpty() && bStack.size() ==1)  return 0;
        for(int j =1;j<bStack.size();j++)
        {     int last =bStack.pop();
              int second_last=bStack.pop();
        	   if(second_last-last<0){
        		   aStack.push(second_last);
        	   }
        }
            		 
		return 0;
	}
}
