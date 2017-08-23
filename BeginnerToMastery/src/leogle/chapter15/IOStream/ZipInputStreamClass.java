package leogle.chapter15.IOStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipInputStreamClass {

	public static void main(String[] args) throws IOException {
		// 1.创建ZipInputStream对象
		ZipInputStream zin;
		// 2.实例化对象，指明要进行解压的文件
		zin = new ZipInputStream(new FileInputStream("java.zip"));
		// 3.获取下一个ZipEntry
		ZipEntry entry = zin.getNextEntry();
		System.out.println(entry.getName());
		// 4.如果entry不为空并且不是目录
		while (((entry = zin.getNextEntry()) != null)) {
			String fileName = entry.getName();
			String unzipDir = "f:\\";
			// 有层级结构，就先创建目录
			String tmp;
			int index = fileName.lastIndexOf('/');
			if (index != -1) {
				tmp = fileName.substring(0, index);
				tmp = unzipDir + "/" + tmp;
				File f = new File(tmp);
				f.mkdirs();
			}

			// 创建文件
			fileName = unzipDir + "/" + fileName;
			File file = new File(fileName);
			file.createNewFile();

			FileOutputStream out = new FileOutputStream(file);
			int c;
			while ((c = zin.read()) != -1) {
				out.write(c);
			}
			zin.closeEntry();
			out.close();
			// 9.关闭当前entry
			System.out.println(entry.getName() + "解压成功！");
		}
		zin.close();

	}

}
