package leogle.chapter18.Thread;

import org.junit.Test;

/**
 * 继承Thread类
 * 
 */
class ThreadTest extends Thread {
	private int count = 10;

	// 重写run方法
	public void run() {
		while (true) {
			System.out.print(count + " ");
			if (--count == 0) {
				return;
			}
		}

	}
}

public class ThreadExtendsThreadClass {
	@Test
	public void test() {
		ThreadTest thread = new ThreadTest();
		thread.start();
	}
}
