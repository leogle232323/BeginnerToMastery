package leogle.chapter15.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndFileOutputStream {

	public static void main(String[] args) throws IOException {
		File file = new File("word.txt");
		try {
			// 1.创建FileOutputStream对象
			FileOutputStream out = new FileOutputStream(file);
			// 2.创建byte型数组
			byte[] buy = "我有一只小毛驴，我从来也不骑！".getBytes();
			// 3.将数组中的信息写入到文件中
			out.write(buy);
			// 4.将流关闭
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// 5.创建FileInputStream对象
			FileInputStream in = new FileInputStream(file);
			byte[] buy = new byte[1024];
			// 6.从文件中读取信息
			int len = in.read(buy);
			// 7.将文件中的信息输出
			System.out.println("文件中的信息是：" + new String(buy, 0, len));
			// 8.关闭流
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
