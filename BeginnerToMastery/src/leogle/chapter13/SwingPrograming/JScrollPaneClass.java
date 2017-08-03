package leogle.chapter13.SwingPrograming;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class JScrollPaneClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JScrollPaneClass() {
		setTitle("�������������ֱ༭��");
		Container container = getContentPane();
		// 1.�����ı��������
		JTextArea jt = new JTextArea(20, 50);
		// 2.����JScrollPane������
		JScrollPane js = new JScrollPane(jt);
		// 3.�������ӵ�������
		container.add(js);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new JScrollPaneClass();
	}

}
