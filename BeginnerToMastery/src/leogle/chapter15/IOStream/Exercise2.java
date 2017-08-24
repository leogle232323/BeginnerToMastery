package leogle.chapter15.IOStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 2.编写程序，使用字符输入、输出流读取文件，将一段文字加密后存入文件，然后再读取，并将加密前与加密后的文件输出
 */
public class Exercise2 {

	public static void main(String[] args) throws IOException {
		// 1.字符数组
		char[] a = "今天10点出发，你说好不好啊？？？？？".toCharArray();
		int n = 0;
		File out = new File("exercise2.txt");
		// 2.加密字符数组
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 'R');
		}
		FileWriter fw = new FileWriter(out);
		// 3.将加密后的字符数组写入文件
		fw.write(a, 0, a.length);
		fw.close();

		// 4.读取加密后的文件
		FileReader fr = new FileReader(out);
		char[] tom = new char[10];
		System.out.println("加密后：");
		while ((n = fr.read(tom, 0, n)) != -1) {
			String s = new String(tom, 0, n);
			System.out.print(s);
		}
		fr.close();

		// 5.解密并读取文件
		fr = new FileReader(out);
		System.out.println("\n明文：");
		while ((n = fr.read(tom, 0, n)) != -1) {
			for (int j = 0; j < n; j++) {
				tom[j] = (char) (tom[j] ^ 'R');
			}
			String str = new String(tom, 0, n);
			System.out.print(str);
		}
		fr.close();
	}

}
