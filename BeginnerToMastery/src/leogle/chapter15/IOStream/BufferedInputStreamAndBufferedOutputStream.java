package leogle.chapter15.IOStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedInputStreamAndBufferedOutputStream {

	public static void main(String[] args) throws IOException {
		// 1.缓存字节输入流
		File file = new File("word.txt");
		if (file.length() != 0) {
			InputStream in = new FileInputStream(file);
			BufferedInputStream bufferedIn = new BufferedInputStream(in);
			byte[] byt = new byte[1024];
			int len = bufferedIn.read(byt);
			System.out.println(new String(byt, 0, len));
			bufferedIn.close();
			in.close();
		} else {
			System.out.println("文件为空！");
		}

		// 2.缓存字节输出流
		String outStr = "this is outbuffered word!";
		OutputStream out = new FileOutputStream("word.txt");
		BufferedOutputStream bufferedOut = new BufferedOutputStream(out);
		bufferedOut.write(outStr.getBytes());
		bufferedOut.flush();
		bufferedOut.close();
		out.close();
	}

}
