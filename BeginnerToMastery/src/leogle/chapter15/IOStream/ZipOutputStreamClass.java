package leogle.chapter15.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamClass {

	public void zip(String zipFileName, File inputFile) throws IOException {
		// 1.创建ZipOutputStream对象
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		// 2.调用方法
		zip(out, inputFile, "");
		out.close();
	}

	public void zip(ZipOutputStream out, File f, String base) throws IOException {
		// 3.测试此抽象路径名表示的文件是否是一个目录
		if (f.isDirectory()) {
			// 4.获取路径数组
			File[] fl = f.listFiles();
			// 5.写入此目录的entry
			out.putNextEntry(new ZipEntry(base + "/"));
			// 6.判断参数是否为空
			base = base.length() == 0 ? "" : base + "/";
			// 7.循环遍历数组中的文件
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i]);
			}
		} else {
			// 8.创建新的进入点
			out.putNextEntry(new ZipEntry(base));
			// 9.创建FileInputStream对象
			FileInputStream in = new FileInputStream(f);
			int b;
			System.out.println(base);
			// 10.将字节写入当前ZIP条目
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			// 11.关闭流
			in.close();
		}
	}

	public static void main(String[] args) throws IOException {
		// 12.创建本例对象
		ZipOutputStreamClass book = new ZipOutputStreamClass();
		// 13.调用方法
		book.zip("word.zip", new File("word.txt"));
	}

}
