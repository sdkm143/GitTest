package com.logic.java;

import java.util.LinkedList;
import java.util.List;

public class StringReplaceTest {


		public StringReplaceTest() {
			// TODO Auto-generated constructor stub
		}

		public static void main(String[] args) {
			String str = "able to work in inside as well as in day also, if we are in home otherwise move in USA";
			String[] arr = str.split(" ");
			List<String> list = new LinkedList<String>();
			StringBuilder sb = new StringBuilder();
			for(String st : arr){
				if(st.equals("in")){
					sb.append("the");
				}else{
					sb.append(st);
				}
				sb.append(" ");
			}
			String s = sb.toString().trim();
			System.out.println(s);
			
			
		}

	}


