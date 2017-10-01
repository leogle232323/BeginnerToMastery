package leogle.chapter15.IOStream;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.ProgressMonitorInputStream;

/**
 * 1.编写程序，实现读取文件时出现一个表示读取进度的进度条。可使用javax.swing包提供的输入
 * 流类ProgressMonitorInputStream
 * 
 */
public class Exercise1 {

	public static void main(String[] args) throws IOException {
		// 1.设置每次读取的字节数
		byte[] b = new byte[2];
		// 2.创建文件输入流对象
		FileInputStream fis = new FileInputStream("word.txt");
		// 3.创建ProgressMonitor输入流对象
		ProgressMonitorInputStream in = new ProgressMonitorInputStream(null, "读取文件", fis);
		// ProgressMonitor p = in.getProgressMonitor();
		while (in.read(b) != -1) {
			String s = new String(b);
			System.out.println(s);
			// 4.暂停500毫秒，方便观察
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("程序终止！");
			}
		}
		// 5.关闭输入流
		fis.close();
		in.close();
	}
}
