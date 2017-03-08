package com.logic.java;

import java.util.concurrent.atomic.AtomicInteger;

public class P {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(0 % 3 != 0);
		AtomicInteger ac=new AtomicInteger(0);
		System.out.println(ac.getAndIncrement());
		System.out.println(ac);
	}

}
