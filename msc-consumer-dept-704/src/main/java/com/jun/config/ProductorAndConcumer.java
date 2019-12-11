package com.jun.config;

public class ProductorAndConcumer {

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


/*class Clerk {

	private int product = 0;

	public synchronized void get() {
		while(product >= 10) {
			System.err.println("产品已满，停止进货");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		this.notifyAll();
		System.err.println(Thread.currentThread().getName() + "进货 : " + ++product);
	}

	public synchronized void sale() {
		while(product <= 0) {
			System.err.println("缺货");
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		this.notifyAll();
		System.err.println(Thread.currentThread().getName() + "销售： " + --product);
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

}*/