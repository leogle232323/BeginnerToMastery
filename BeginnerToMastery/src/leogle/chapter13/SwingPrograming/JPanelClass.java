package leogle.chapter13.SwingPrograming;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class JPanelClass extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPanelClass() {
		setTitle("JPanel面板");
		Container container = getContentPane();
		// 1.将整个容器设置为2行1列的网格布局
		setLayout(new GridLayout(2, 1, 10, 10));
		// 2.创建面板
		JPanel p1 = new JPanel(new GridLayout(1, 3, 10, 10));
		p1.setLayout(new BorderLayout());
		JPanel p2 = new JPanel(new GridLayout(1, 2, 10, 10));
		JPanel p3 = new JPanel(new GridLayout(1, 2, 10, 10));
		JPanel p4 = new JPanel(new GridLayout(2, 1, 10, 10));
		// 3.在面板中添加按钮
		p1.add(new JButton("1"), BorderLayout.NORTH);
		p1.add(new JButton("2"), BorderLayout.EAST);
		p1.add(new JButton("3"), BorderLayout.SOUTH);
		p1.add(new JButton("333"), BorderLayout.CENTER);
		p2.add(new JButton("4"));
		p2.add(new JButton("5"));
		p3.add(new JButton("6"));
		p3.add(new JButton("7"));
		p4.add(new JButton("8"));
		p4.add(new JButton("9"));

		// 4.在容器中添加面板
		container.add(p1);
		container.add(p2);
		container.add(p3);
		container.add(p4);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JPanelClass();
	}

}
