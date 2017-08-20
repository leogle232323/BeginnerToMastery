package leogle.chapter15.IOStream;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FileReaderAndFileWriter extends JFrame {

	private static final long serialVersionUID = 1L;
	// 1.创建面板对象
	private JPanel jContentPane = null;
	// 2.创建文本域对象
	private JTextArea jTextArea = null;
	// 3.创建面板对象
	private JPanel ControlPanel = null;
	// 4.创建按钮对象
	private JButton openButton = null;
	// 5.创建按钮对象
	private JButton closeButton = null;

	private JButton getOpenButton() {
		if (openButton == null) {
			openButton = new JButton();
			openButton.setText("写入文件");
			openButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// 6.创建文件对象
					File file = new File("word.txt");
					// 7.创建FileWriter对象
					try {
						FileWriter out = new FileWriter(file, true);
						// 8.获取文本域中文本
						String s = jTextArea.getText();
						// 9.将信息写入磁盘文件
						out.write(s);
						// 10.关闭流
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});
		}
		return openButton;

	}

	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("读取文件");
			closeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					File file = new File("word.txt");
					try {
						FileReader in = new FileReader(file);
						// 11.创建char型数组
						char byt[] = new char[1024];
						// 12.将字节读入数组
						int len = in.read(byt);
						// 13.设置文本域的显示信息
						jTextArea.setText(new String(byt, 0, len));
						// 14.关闭流
						in.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			});
		}
		return closeButton;

	}

	private void initialize() {
		Container container = getContentPane();
		container.add(getJContentPane(), BorderLayout.CENTER);
		container.add(getControlPanel(), BorderLayout.SOUTH);
		this.setSize(300, 200);
		this.setTitle("JFrame");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JTextArea getTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea(6, 6);
			jTextArea.setLineWrap(true);
		}
		return jTextArea;
	}

	private JPanel getControlPanel() {
		if (ControlPanel == null) {
			ControlPanel = new JPanel();
			ControlPanel.add(getOpenButton());
			ControlPanel.add(getCloseButton());
		}
		return ControlPanel;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.add(getTextArea(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	public FileReaderAndFileWriter() {
		super();
		initialize();
	}

	public static void main(String[] args) {
		new FileReaderAndFileWriter();
	}

}
