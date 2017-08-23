package leogle.chapter15.IOStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamAndDataOutputStream {

	public static void main(String[] args) throws IOException {
		// DataOutputStream流对象
		// 1.创建FileOutputStream对象
		FileOutputStream fos = new FileOutputStream("word.txt");
		// 2.创建DataOutputStream对象
		DataOutputStream dos = new DataOutputStream(fos);
		// 3.写入磁盘文件数据
		dos.writeUTF("使用writeUTF()方法写入数据;");
		dos.writeChars("使用writeChars()方法写入数据;");
		dos.writeBytes("使用writeBy特色()方法写入数据;");
		dos.flush();
		dos.close();

		// DataInputStream流对象
		// 4.创建FileInputStream对象
		FileInputStream fis = new FileInputStream("word.txt");
		// 5.创建DataInputStream对象
		DataInputStream dis = new DataInputStream(fis);
		// 6.将文件数据输出
		System.out.println(dis.readUTF());
		dis.close();

	}

}
