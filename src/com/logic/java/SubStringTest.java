package com.logic.java;
import java.util.*;

public class SubStringTest {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         System.out.println("Enter the String ");
    	
    	Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        int len = str.length();
        int j = 0;
        String[] strArr = new String[len-k+1];
        Map<String,List<Boolean>> result = new LinkedHashMap<String,List<Boolean>>();
        for(int i = 0; i <= len-k; i++){
            j = i+k;
             StringBuilder sb = new StringBuilder();
            for(int x = i; x < j ; x++){
               sb.append(str.charAt(x));
            }
            strArr[i] = sb.toString();
        }
        	for(int p = 0; p < strArr.length ; p++){
			for (int q = 1 ; q < (strArr.length)-p ; q++){
                boolean comp = compareTwoStr(strArr[q-1],strArr[q]);
				if(comp){
					String temp = strArr[q-1];
					strArr[q-1] =strArr[q];
					strArr[q] = temp;
				}
			}
		}
        System.out.println(strArr[strArr.length - 1]);
        System.out.println(strArr[0]);       
    }
       
      public static boolean compareTwoStr(String A, String B)  {
        int aLength = 0;
        int bLength = 0;
        boolean status = false;
        for(char ch : A.toCharArray()){
            aLength++;
        }
         for(char ch : B.toCharArray()){
            bLength++;
        }
       
        int count = 0;
        if(aLength > bLength){
        	count = bLength;
        }else{
        	count = aLength;
        }
        boolean equal = false;
        for(int i = 0; i < count ; i++){
           char c = A.charAt(i);
            int a = (int)c;
           char d = B.charAt(i);
            int b = (int)d;
            if (a < b){
                status = true;
                equal = false;
                break;
            }
            else if (a > b){
                status = false;
                equal = false;
                break;
            }else{
            	equal = true;
            }
        }
        if(equal == true){
        	if(aLength > bLength){
        		status = false;
        	}else{
        		status = true;
        	}
        }
          return status;
      }
}