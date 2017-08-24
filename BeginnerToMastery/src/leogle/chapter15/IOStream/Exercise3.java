package leogle.chapter15.IOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 3.编写程序，实现当用户输入姓名和密码时，将每一个姓名和密码加在文件中，如果用户输入done，就结束程序。
 * 
 */
public class Exercise3 {
	static final int lineLength = 81;

	public static void main(String[] args) throws IOException {
		FileOutputStream fos;
		byte[] phone = new byte[lineLength];
		byte[] name = new byte[lineLength];
		try {
			fos = new FileOutputStream("exercise3.txt");
			while (true) {
				System.err.println("请输入一个名字：");
				// 1.读入名字
				readLine(name);
				// 2.如果字符为done，退出循环
				if ("done".equalsIgnoreCase(new String(name, 0, 4))) {
					System.out.println("录入完毕！");
					break;
				}

				System.err.println("请输入电话号码：");
				// 3.读入电话
				readLine(phone);

				// 4.将名字写入文件
				for (int j = 0; name[j] != 0; j++) {
					fos.write(name[j]);
				}
				fos.write(',');

				// 5.将电话写入文件
				for (int i = 0; phone[i] != 0; i++) {
					fos.write(phone[i]);
				}

				System.out.println("信息已写入文件！");
			}
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 录入信息
	 */
	private static void readLine(byte[] name) throws IOException {
		int b = 0;
		int i = 0;
		// 将输入流中的字符读入字节数组
		while ((i < lineLength - 1) && (b = System.in.read()) != '\n') {
			name[i++] = (byte) b;
		}
		// 将字节数组最后一个元素置为0(标记)
		name[i] = (byte) 0;
	}

}
