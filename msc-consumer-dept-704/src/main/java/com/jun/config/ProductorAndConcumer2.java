package com.jun.config;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorAndConcumer2 {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();

		Producter p = new Producter(clerk);
		Consumer c = new Consumer(clerk);

		new Thread(p, "生产者P1").start();
		new Thread(p, "生产者P2").start();
		new Thread(c, "消费者C1").start();
		new Thread(c, "消费者C2").start();

	}

}


class Clerk {

	private Lock lock = new ReentrantLock();

	private Condition condition = lock.newCondition();

	private int product = 0;

	public void get() {
		lock.lock();
		try {
			while(product >= 10) {
				System.err.println("产品已满，停止进货");
				try {
					condition.await();
				} catch (InterruptedException e) {
				}
			}
			condition.signalAll();
			System.err.println(Thread.currentThread().getName() + "进货 : " + ++product);

		} finally {
			lock.unlock();
		}

	}

	public void sale() {
		lock.lock();
		try {
			while(product <= 0) {
				System.err.println("缺货");
				try {
					condition.await();
				} catch (InterruptedException e) {
				}
			}
			condition.signalAll();
			System.err.println(Thread.currentThread().getName() + "销售： " + --product);
		} finally {
			lock.unlock();
		}
	}

}

class Producter implements Runnable {
	private Clerk clerk;

	public Producter(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.get();
		}
	}

}

class Consumer implements Runnable {

	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			clerk.sale();
		}
	}

}