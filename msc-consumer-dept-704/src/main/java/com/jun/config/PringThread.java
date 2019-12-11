package com.jun.config;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PringThread {

	private int num = 1;

	private Lock lock = new ReentrantLock();

	Condition con1 = lock.newCondition();
	Condition con2 = lock.newCondition();
	Condition con3 = lock.newCondition();

	public void printA() {
		lock.lock();
		try {
			if(num != 1) {
				con1.await();
			}
			System.err.println("A");
			num = 2;
			con2.signal();
		}catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void printB() {
		lock.lock();
		try {
			if(num != 2) {
				con2.await();
			}
			System.err.println("B");
			num = 3;
			con3.signal();
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}

	public void printC() {
		lock.lock();
		try {
			if(num != 3) {
				con3.await();
			}
			System.err.println("C");
			num = 1;
			con1.signal();
		} catch (Exception e) {
		}finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		PringThread pt = new PringThread();

		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				pt.printA();
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				pt.printB();
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				pt.printC();
			}
		}).start();
	}

}
