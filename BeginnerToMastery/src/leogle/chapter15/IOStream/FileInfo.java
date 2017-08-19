package leogle.chapter15.IOStream;

import java.io.File;
import java.util.Date;

public class FileInfo {

	public static void main(String[] args) {
		File file = new File("word.txt");
		if (file.exists()) {
			// 1.获取文件名称
			String name = file.getName();
			System.out.println("文件名称：" + name);
			// 2.判断文件是否是可读的
			boolean readable = file.canRead();
			System.out.println("文件可读？" + readable);
			// 3.判断文件是否可写
			boolean writeable = file.canWrite();
			System.out.println("文件可写？" + writeable);
			// 4.判断文件是否存在
			boolean isexist = file.exists();
			System.out.println("文件是否存在" + isexist);
			// 5.获取文件长度
			long length = file.length();
			System.out.println("文件长度为：" + length);
			// 6.获取文件绝对路径
			String absolutePath = file.getAbsolutePath();
			System.out.println("文件绝对路径为：" + absolutePath);
			// 7.获取文件的父路径
			String parentPath = file.getParent();
			System.out.println("文件父路径为：" + parentPath);
			// 8.判断是否为文件
			boolean isFile = file.isFile();
			System.out.println("是否为文件？" + isFile);
			// 9.判断是否为目录
			boolean isDirectory = file.isDirectory();
			System.out.println("是否为目录？" + isDirectory);
			// 10.判断是否为隐藏文件
			boolean isHidden = file.isHidden();
			System.out.println("是否为隐藏文件？" + isHidden);
			// 11.获取文件最后修改时间
			long lastModified = file.lastModified();
			System.out.println("文件最后修改时间为：" + new Date(lastModified));
		} else {
			System.out.println("该文件不存在！");
		}

	}

}
