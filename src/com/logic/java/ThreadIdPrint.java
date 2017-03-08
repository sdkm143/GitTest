package com.logic.java;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadIdPrint {
	Object monitor = new Object();
	AtomicInteger number = new AtomicInteger(0);

	public static void main(String[] args) {
		ThreadIdPrint tnp = new ThreadIdPrint();
		Thread t1 = new Thread(tnp.new Printer(0, 3));
		Thread t2 = new Thread(tnp.new Printer(1, 3));
		Thread t3 = new Thread(tnp.new Printer(2, 3));

		t3.start();
		t1.start();
		t2.start();
	}

	class Printer implements Runnable {

		int threadId;
		int numOfThreads;

		public Printer(int id, int nubOfThreads) {
			threadId = id;
			this.numOfThreads = nubOfThreads;
		}

		public void run() {
			print();
		}

		private void print() {
			try {
				while (true) {

					Thread.sleep(2000);
					synchronized (monitor) {
						// System.out.println("thread " + threadId);
						if (number.get() % numOfThreads != threadId) {
							// System.out.println("thread " + threadId + " going
							// to waiting state");
							monitor.wait();
						}

						else {
							System.out.println("ThreadId [" + threadId + "] printing -->" + number.getAndIncrement());
							// System.out.println("thread " + threadId);
							monitor.notifyAll();
						}

					}
					if (number.get() > 3) {
						System.out.println("ThreadId [" + threadId + "] printing -->" + number.getAndIncrement());

					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
