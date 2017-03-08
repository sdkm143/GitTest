package com.logic.java;

	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	public class Solution {
	    

	    public static void main(String[] args) {
	      //  Scanner in = new Scanner(System.in);
	      //  int arr[][] = new int[6][6];
	    	List<Integer> list = new ArrayList<Integer>(); 
	    	int arr[][] = {
	    					{1, 1, 1, 0, 0, 0},
	    					{0, 1, 0, 0, 0, 0},
	    					{1, 1, 1, 0, 0, 0},
	    					{0, 9, 2, -4, -4, 0},
	    					{0, 0, 0, -2, 0, 0},
	    					{0, 0, -1, -2, -4, 0}
	    	};
	        for(int r=0; r < 4; r++){
	        	
	            for(int c=0; c < 4; c++){
	            	
	            	 int[][] hg = new int[3][3];
	            	 int p = 0; int q = 0;
	            	 
	            	 for(int i=r; i < r+3 ; i++){
	            		 
	            		 for(int j=c; j < c+3; j++){
	            			 
	            			hg[p][q] = arr[i][j];
	            			q++; 
	            		 }
	            		 p++;
	            		 q=0;
	            	 }
	            	 for(int i=0; i < 3; i++){
	                     for(int j=0; j < 3; j++){
	                    	 System.out.print("\t"+hg[i][j]);
	                    	
	                     }
	                     System.out.println();
	                   }
	            	 System.out.println("_________________________________________________________________");
	            	 int sum = calHourGlassSum(hg);
	            	 list.add(sum);
	            	 }
	            }
	        Collections.sort(list);
	        System.out.println(list.get(list.size()-1));
	        
	    }
	    
	    public static int calHourGlassSum(int[][] hg){
	    	int sum = 0;
	    	 for(int i=0; i < 3; i++){
	             for(int j=0; j < 3; j++){
	            	 if(i == 0 || i == 2){
	            		 sum = sum + hg[i][j];
	            	 }
	            	 if( i == 1 && j == 1){
	            		 sum = sum + hg[1][1];
	            	 }
	             }
	         }
	    	return sum;
	    }
	}

