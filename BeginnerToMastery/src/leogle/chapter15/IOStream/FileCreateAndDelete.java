package leogle.chapter15.IOStream;

import java.io.File;
import java.io.IOException;

public class FileCreateAndDelete {

	public static void main(String[] args) {
		// 1.创建文件对象
		File file = new File("isExists.txt");
		if (file.exists()) {
			// 如果文件存在，则删除
			file.delete();
			System.out.println("文件已删除！");
		} else {
			try {
				file.createNewFile();
				System.out.println("文件已创建！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
