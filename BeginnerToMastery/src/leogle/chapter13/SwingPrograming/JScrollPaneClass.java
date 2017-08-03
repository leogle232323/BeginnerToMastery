package leogle.chapter13.SwingPrograming;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JScrollPaneClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JScrollPaneClass() {
		setTitle("带滚动条的文字编辑器");
		Container container = getContentPane();
		// 1.创建文本区域组件
		JTextArea jt = new JTextArea(20, 50);
		// 2.创建JScrollPane面板对象
		JScrollPane js = new JScrollPane(jt);
		// 3.将面板添加到容器中
		container.add(js);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new JScrollPaneClass();
	}

}
