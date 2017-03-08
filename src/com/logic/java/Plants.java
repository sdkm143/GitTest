package com.logic.java;

import java.util.Scanner;
import java.util.Stack;

public class Plants {
	static Stack<Integer> aStack = new Stack<Integer>();
	static Stack<Integer> bStack = new Stack<Integer>();

	public static void main(String[] args) {
		System.out.println("Enter the no of plants ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			aStack.push(new Scanner(System.in).nextInt());
		}
		System.out.println(printdays(aStack)+ " day After no one plant is die");
	}

	static int printdays(Stack aStack) {
		int removed = -1;
		int count = 0;

		while (removed != 0) {
			removed = 0;
			int currvalue = 0;

			while (!aStack.empty()) {
				currvalue = (int) aStack.pop();
				if (!aStack.empty()) {
					int tempvalue = (int) aStack.pop();
					if (currvalue <= tempvalue) {
						bStack.push(currvalue);
					} else {
						removed++;
					}
					aStack.push(tempvalue);
				} else {
					bStack.push(currvalue);

				}
			}
			while (!bStack.empty()) {
				aStack.push(bStack.pop());
			}
			if (removed != 0) {
				count++;
			}

		}

		return count;

	}

}
