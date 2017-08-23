package leogle.chapter15.IOStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderAndBufferedWriter {

	public static void main(String[] args) throws IOException {
		// BufferedWriter缓存字符输出流
		// 1.定义字符串数组
		String[] content = { "好久不见", "最近好么", "常联系" };
		// 2.创建文件对象
		File file = new File("word.txt");
		// 3.创建FileWriter对象
		FileWriter fw = new FileWriter(file);
		// 4.创建BufferedWriter对象
		BufferedWriter bfw = new BufferedWriter(fw);
		// 5.循环遍历数组，
		for (int i = 0; i < content.length; i++) {
			// 6.将字符串数组中的元素写入到磁盘文件中
			bfw.write(content[i]);
			// 7.将数组中的单个元素以单行的形式写入文件
			bfw.newLine();
		}
		// 8.将BufferedWriter流关闭
		bfw.close();
		// 9.将FileWriter流关闭
		fw.close();

		// BufferedReader缓存字符输入流
		// 10.创建FileReader类对象
		FileReader fr = new FileReader(file);
		// 11.创建BufferedReader类对象
		BufferedReader bfr = new BufferedReader(fr);
		// 12.创建字符串对象
		String s = null;
		// 13.声明int型变量
		int i = 0;
		// 14.如果文件的文本行数不为null，则进入循环
		while ((s = bfr.readLine()) != null) {
			i++;
			// 15.输出文件数据
			System.out.println("第" + i + "行：" + s);
		}
		// 16.将BufferedReader流关闭
		bfr.close();
		// 17.将FileReader流关闭
		fr.close();
	}

}
