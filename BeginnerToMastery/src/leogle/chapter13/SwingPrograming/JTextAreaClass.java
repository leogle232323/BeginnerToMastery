package leogle.chapter13.SwingPrograming;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JTextAreaClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JTextAreaClass() {
		setTitle("文本域组件");
		setLayout(new FlowLayout(0, 10, 10));
		Container container = getContentPane();
		JTextArea jt = new JTextArea("文本域", 6, 6);
		// 设置自动换行
		jt.setLineWrap(true);
		JScrollPane js = new JScrollPane(jt);
		container.add(js);
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTextAreaClass();
	}

}
