package com.logic.java;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		System.out.println("Hi  pal start to sort array using merge sort");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("how many elements wants to sort " + n);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

		}
		sortArrray(arr);
	}

	private static int[] sortArrray(int[] arr) {
		
		mergeSort(arr)
		{
			
		}

		return null;
	}

	private static void mergeSort(int[] arr) {
		  int n =arr.length;
		  if(n<2)
		  {
			  return ;
		  } 
		  int mid = 0+n/2;
		  int left  = arr[mid-0];
		  int right =arr[n-mid];
		  for(int i =0;i<left;i++)
			  int leftArr []  =arr[i];
		  mergeSort(left);
		
	}
}